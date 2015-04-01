import java.util.Random;


public class TurnAI {
	private RunGame rg;
	private GameLogic gl;
	int[] possibleActions;
	Random generator;
	//will store int that corresponds to action type used in RunGame  
	//0= nothing, 1 = settlement, 2 = city, 3 = road,
	//4 = trade 4 to 1, 5 = trade other player, 6 = move robber, 7 = monopoly 8 = year of plenty
	//9 = road builder, 10 = knight
	int actionCount;
	int[] settlementVertices;
	int settlementVerticesCount;
	int[] cityVertices;
	int cityVerticesCount;
	int[][] roadVertices;
	int roadVerticesCount;
	int[] resourcesToTrade4to1;
	int tradeCounter;
	boolean debug = true;
	boolean printActions = true;
	private ResourceTranslator translator = new ResourceTranslator();
	int smartPlayer = 3;
	
	public TurnAI(RunGame r, GameLogic g, boolean printMessages){
		rg = r;
		gl = g;
		possibleActions = new int[10];
		generator =  new Random();
		printActions = printMessages;
		debug = printMessages;
	}
	
	public void turn(int p){
	//	if (p == smartPlayer){
			smartTurn(p);
	/*	} else {
			// check available actions
			checkPossible(p);
			//pick action randomly
			if (actionCount == 0){
				return;
			}
			int randIndex = generator.nextInt(actionCount);
			int actionToTake = possibleActions[randIndex];
			if (printActions){
				System.out.println("Taking action "+actionToTake);
			}
			
			switch (actionToTake) {
				case (1):
					settle(p);
					break;
				case (2):
					buildCity(p);
					break;
				case (3):
					buildRoad(p);
					break;
				case (4):
					makeTrade(p);
					break;
				case(11):
					buyDevCard(p);
					break;
			}
		}
		*/
	}
	
	private void smartTurn(int p){
		if (settlementPossible(p)) {
			settle(p);
		} else if (cityPossible(p)) {
			buildCity(p);
		} else if (roadPossible(p)) {
			buildRoad(p);
		} else if (devCardPossible(p)){
			buyDevCard(p);
		} else if (tradePossible4to1(p)){
			makeTrade(p);
		} 
	}
	
	//populate the array possibleActions with list of the moves you can make
	private void checkPossible(int p){
		actionCount = 0;
		if (settlementPossible(p)){
			possibleActions[actionCount] = 1;
			actionCount ++;
		}
		if (cityPossible(p)){
			possibleActions[actionCount] = 2;
			actionCount ++;
		}
		if (devCardPossible(p)){
			possibleActions[actionCount] = 11;
			actionCount ++;
		}
		if (roadPossible(p)){
			possibleActions[actionCount] = 3;
			actionCount ++;
		}
		if (tradePossible4to1(p)){
			possibleActions[actionCount] = 4;
			actionCount ++;
		}
	}
	
	//check if there is any vertex that you can build a settlement on
	private boolean settlementPossible(int p){
		settlementVertices = new int[54];
		settlementVerticesCount = 0;
		for (int i = 0; i<settlementVertices.length; i++){
			if (gl.buildSetCheck(p, i)){
				settlementVertices[settlementVerticesCount] = i;
				settlementVerticesCount ++;
				if (debug){
					System.out.println("Possible to build a settlment on vertex: "+i+ " for player "+p);
				}
			}
		}
		return settlementVerticesCount > 0;
	}
	
	private void settle(int p){
		rg.setActionType (1);
		int randIndex = generator.nextInt(settlementVerticesCount);
		int vertexToBuild = settlementVertices[randIndex];
		rg.setVertex(vertexToBuild);
	}
	
	private boolean cityPossible(int p){
		cityVertices = new int[10];
		cityVerticesCount = 0;
		int[] settlements = gl.getVerticesWithSettlements(p);
		for (int i=0; i<settlements.length; i++){
			if (gl.buildCityCheck(p, settlements[i])){
				cityVertices[cityVerticesCount] = settlements[i];
				cityVerticesCount ++;
			}
		}
		return  cityVerticesCount > 0;
	}
	
	private void buildCity (int p){
		rg.setActionType(2);
		int cityIndex = generator.nextInt(cityVerticesCount);
		int cityToBuild = cityVertices[cityIndex];
		rg.setVertex(cityToBuild);
	}
	
	private boolean devCardPossible(int p){
		boolean toReturn = gl.buildDevCheck(p);
			if (toReturn && debug ){
				System.out.println("Possible to buy a dev card for player "+p);
			}
		return toReturn;
	}
	
	private boolean roadPossible(int p){
		roadVertices = new int[54*54][2];
		roadVerticesCount = 0;
		for (int i = 0; i<54; i++){
			for (int j=0; j<54; j++){
				if (gl.buildRoadCheck(p,i,j)){
					roadVertices[roadVerticesCount][0] = i;
					roadVertices[roadVerticesCount][1] = j;
					roadVerticesCount ++;
				}
			}
		}
		return roadVerticesCount > 0;
	}
	
	private void buildRoad(int p){
		rg.setActionType(3);
		int roadIndex = generator.nextInt(roadVerticesCount);
		int v1 = roadVertices[roadIndex][0];
		int v2 =  roadVertices[roadIndex][1];
		rg.setVertex(v1);
		rg.setVertex(v2);
		return;
	}
	
	private boolean tradePossible4to1(int p){
		resourcesToTrade4to1 = new int[5];
		tradeCounter = 0;
		if (gl.hasResourcesToTrade(p, translator.Wheat, 4)){
			resourcesToTrade4to1[tradeCounter] = translator.Wheat;
			tradeCounter ++;
		}
		if (gl.hasResourcesToTrade(p, translator.Rock, 4)){
			resourcesToTrade4to1[tradeCounter] = translator.Rock;
			tradeCounter ++;
		}
		if (gl.hasResourcesToTrade(p, translator.Brick, 4)){
			resourcesToTrade4to1[tradeCounter] = translator.Brick;
			tradeCounter ++;
		}
		if (gl.hasResourcesToTrade(p, translator.Sheep, 4)){
			resourcesToTrade4to1[tradeCounter] = translator.Sheep;
			tradeCounter ++;
		}
		if (gl.hasResourcesToTrade(p, translator.Wood, 4)){
			resourcesToTrade4to1[tradeCounter] = translator.Wood;
			tradeCounter ++;
		}
		return tradeCounter > 0;
	}
	
	private void makeTrade(int p){
		int tradeIndex = generator.nextInt(tradeCounter);
		int resourceToTrade =  resourcesToTrade4to1[tradeIndex];
		int resourceDesired = generator.nextInt(5)+1;
		//make sure that the type of resourceDesired is not the same resource that you are trading away
		while (resourceDesired == resourceToTrade){
			resourceDesired = generator.nextInt(5)+1;
		}
		int[][] tradeArray = new int[][]{{resourceDesired, 1, 0},{resourceToTrade,4, p}};
		if (printActions){
			System.out.println("trading resource of type: "+tradeArray[1][0]+ " with bank for a resource of type: "+resourceDesired);
			System.out.println("player trading resource is player num "+tradeArray[1][2]);
		}
		rg.trade(tradeArray);
		return;
	}
	
	private void buyDevCard(int p){
		rg.setActionType(11);
	}
	
	
}
