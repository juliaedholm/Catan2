import java.util.Random;

public class InitialPlacementAI {
	Random generator;
	RunGame rg;
	GameLogic gl;
	boolean fixedInitialPlacement;
	
	int[] settlementVertices;
	int settlementVerticesCount;
	int[][] roadVertices;
	int roadVerticesCount;
	boolean debug = false; 
	
	public InitialPlacementAI (RunGame r, GameLogic g, boolean printMessages, boolean f){
		generator =  new Random();
		rg = r;
		gl = g;
		fixedInitialPlacement = f;
	}
	
	// actions for first round (settlement and road placement) ///
		public int firstRoundPlaceSettlement(int player){
			int possibleSpot = 100;
			if (fixedInitialPlacement){
				///figure out some way to be systematic about the starting position for each player and make sure that all vertices are ttried at some point....
			}else {
				possibleSpot = spotToBuild(player );
				rg.placeSettlementFirstRound(possibleSpot);
			}
			return possibleSpot;
		}
		
		private int spotToBuild(int p){
			settlementVertices = new int[54];
			settlementVerticesCount = 0;
			for (int i = 0; i<settlementVertices.length; i++){
				if (gl.placeSetCheck(p, i)){
					settlementVertices[settlementVerticesCount] = i;
					settlementVerticesCount ++;
					if (debug){
						System.out.println("Possible to build a settlment on vertex: "+i+ " for player "+p);
					}
				}
			}
			int randIndex = generator.nextInt(settlementVerticesCount);
			int vertexToBuild = settlementVertices[randIndex];
			return vertexToBuild;
		}
		
		public void firstRoundRoad(int p){
			findLegalRound1Road(p);
			int randIndex = generator.nextInt(roadVerticesCount);
			int v1 = roadVertices[randIndex][0];
			int v2 =  roadVertices[randIndex][1];
			rg.placeRoadFirstRound(v1);
			rg.placeRoadFirstRound(v2);
		}
		
		private void findLegalRound1Road(int p){
			roadVertices = new int[54*54][2];
			roadVerticesCount = 0;
			for (int i = 0; i<54; i++){
				for (int j=0; j<54; j++){
					if (gl.round1RoadCheck(i,j,p)){
						roadVertices[roadVerticesCount][0] = i;
						roadVertices[roadVerticesCount][1] = j;
						roadVerticesCount ++;
					}
				}
			}
		}
}