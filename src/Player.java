import javax.annotation.Resource;

//CJ

public class Player {
	private int playerID;
	public int victoryPoints;
	private boolean largestArmy;
	private boolean longestRoad;

	public int numberOfSettlements; //max 5
	public int[] settlementVertices;
	private int numberOfCities; //max 4
	private int numberOfRoads; //max 15
	
	private Ports portTracker;
	private ResourceTranslator translator = new ResourceTranslator();
	private ResourceCards resourceTracker;
	public DevCards dCardTracker;
	//settlements and cities and roads are pointed to from the graph

	private boolean printToTerminal = false;

	public Player(int id){
		playerID = id;
		victoryPoints = 0;

		numberOfSettlements=0;
		settlementVertices = new int[10];
		numberOfRoads=0;
		numberOfCities=0;

		resourceTracker = new ResourceCards();

		dCardTracker = new DevCards();

		portTracker = new Ports();
	}

	public int[] getPlayerStats(){
		//this method returns an array with the following information: 
		//index 0 number of sheep
		// 1 numer of rock
		// 2 number of wheat
		// 3 number of brick
		// 4 number of wood
		// 5 number of victory points
		// 6 number of played knights
		// 7 number of unplayed knights
		// 8 number of road builders
		// 9 number of monopoly cards
		// 10 number of year of plenty cards

		int[] stats = new int[11];
		stats[0] = resourceTracker.getSheep();
		stats[1] = resourceTracker.getRock();
		stats[2] = resourceTracker.getWheat();
		stats[3] = resourceTracker.getBrick();
		stats[4] = resourceTracker.getWood();
		stats[5] = victoryPoints;
		stats[6] = dCardTracker.armySize();
		stats[7] = dCardTracker.getK();
		stats[8] = dCardTracker.getRB();
		stats[9] = dCardTracker.getM();
		stats[10] = dCardTracker.getYoP();

		return stats;

	}
	
	public int numResourcesOfType (int i){
		if(i== translator.Rock)
			return resourceTracker.getRock();
		if(i== translator.Wheat)
			return resourceTracker.getWheat();
		if(i== translator.Brick)
			return resourceTracker.getBrick();
		if(i==translator.Wood)
			return resourceTracker.getWood();
		if(i==translator.Sheep)
			return resourceTracker.getSheep();
		else 
			return 0;
	}
	
	public void addResource(int i, int q){
		if(i== translator.Rock)
			resourceTracker.addRock(q);
		if(i== translator.Wheat)
			resourceTracker.addWheat(q);
		if(i== translator.Brick)
			resourceTracker.addBrick(q);
		if(i==translator.Wood)
			resourceTracker.addWood(q);
		if(i==translator.Sheep)
			resourceTracker.addSheep(q);
	}
	
	//used in trading
	public boolean looseResource(int i, int q){
		if(i== translator.Rock)
			return resourceTracker.useRock(q);
		if(i== translator.Wheat)
			return resourceTracker.useWheat(q);
		if(i== translator.Brick)
			return resourceTracker.useBrick(q);
		if(i==translator.Wood)
			return resourceTracker.useWood(q);
		if(i==translator.Sheep)
			return resourceTracker.useSheep(q);

		System.out.println("Something is wrong if this prints - looseResource");
		return false;
	}

	public int getAllX(int x){
		return resourceTracker.monopX(x);
	}
	
	public int[] getResourceArray(){
		int[] stats = new int[5];
		stats[0] = resourceTracker.getSheep();
		stats[1] = resourceTracker.getRock();
		stats[2] = resourceTracker.getWheat();
		stats[3] = resourceTracker.getBrick();
		stats[4] = resourceTracker.getWood();
		return stats;
	}

	//methods for largest army
	public int getArmySize(){
		return dCardTracker.armySize();
	}

	public boolean checkLgArmy(){
		return largestArmy;
	}

	public void changeLgArmy(){
		if(largestArmy==true){
			largestArmy=false;
			victoryPoints = victoryPoints-2;
		}
		else{
			largestArmy=true;
			victoryPoints = victoryPoints+2;
		}
	}

	//methods for longest road
	public int getNumRoads(){
		return numberOfRoads;
	}
	
	public boolean checkLongRoad(){
		return longestRoad;
	}

	public void changeLongRoad(){
		if(longestRoad==true){
			longestRoad=false;
			victoryPoints = victoryPoints-2;
		}
		else{
			longestRoad=true;
			victoryPoints = victoryPoints+2;
		}
	}

	public boolean buildSetCheck(){
		if(resourceTracker.getSheep()<1 || resourceTracker.getWheat()<1 || resourceTracker.getWood()<1 || resourceTracker.getBrick()<1){
			if (printToTerminal){
				System.out.println("You do not have enough resources to build a settlement.");
			}
			return false;
		}
		if(numberOfSettlements==5){
			if (printToTerminal){
				System.out.println("You have already built the maximum number of settlements.");
			}
			return false;
		}
		return true;
	}

	public void placeSettlement(int v){
		settlementVertices[numberOfSettlements] = v;
		numberOfSettlements ++;
		victoryPoints++;
		
	}
	
	public void buildSettlement(int v){
		resourceTracker.useSheep(1);
		resourceTracker.useWheat(1);
		resourceTracker.useWood(1);
		resourceTracker.useBrick(1);
		placeSettlement(v);
	}
	
	public int[] getSettlementVertices(){
		int[] toReturn = new int[numberOfSettlements];
		for (int i=0; i<numberOfSettlements; i++){
			toReturn[i] = settlementVertices[i];
		}
		return toReturn;
	}

	public boolean buildDevCheck(){
		if(resourceTracker.getSheep()<1 || resourceTracker.getWheat()<1 || resourceTracker.getRock()<1){
			if (printToTerminal){
				System.out.println("You do not have enough resources to build a development card.");
			}
			return false;
		}
		return true;
	}

	public boolean buildDev(int i){
		resourceTracker.useSheep(1);
		resourceTracker.useRock(1);
		resourceTracker.useWheat(1);

		if(i == 0)
			dCardTracker.addKnight();

		if(i == 1){
			victoryPoints++;
			dCardTracker.addVictory();
		}

		if(i == 2)
			dCardTracker.addRoadBuilder();

		if(i == 3)
			dCardTracker.addMonopoly();

		if(i == 4)
			dCardTracker.addYearOfPlenty();

		return true;

	}
	
	public boolean useDevCard (int i){
		if(i==0)
			return dCardTracker.useKnight();

		if(i==3)
			return dCardTracker.useRoadBuilder();	

		if(i==4)
			return dCardTracker.useMonopoly();

		if(i==5)
			return dCardTracker.useYearOfPlenty();
		return false;
	}

	public boolean canUseDevCard(int i){
		if(i==0)
			return (dCardTracker.getK()>0);

		if(i==3)
			return (dCardTracker.getRB()>0);	

		if(i==4)
			return dCardTracker.getM() > 0 ;

		if(i==5)
			return dCardTracker.getYoP() >0 ;
		
		System.out.println("Something is wrong if this prints - usedevcard.");
		return false;
	}

	public void sevenRoll(){
		int total = resourceTracker.getNumber();
		if (total>7){
			for (int i=0; i<(total/2); i++)
				resourceTracker.randomDelete();
		}
	}
	
	public int stealResource() {
		int resource = resourceTracker.randomDelete();
		return resource;
	}

	public boolean buildCityCheck(){
		if(resourceTracker.getWheat()<2 || resourceTracker.getRock()<3){
			if (printToTerminal){
				System.out.println("You do not have enough resources to build a city.");
			}
			return false;
		}
		if(numberOfSettlements==4){
			if (printToTerminal){
				System.out.println("You have already built the maximum number of cities.");
			}
			return false;
		}
		return true;
	}

	public void buildCity(){
		resourceTracker.useRock(3);
		resourceTracker.useWheat(2);
		numberOfSettlements --;
		numberOfCities++;
		victoryPoints++;
	}

	public boolean buildRoadCheck(){
		if(resourceTracker.getBrick()<1 || resourceTracker.getWood()<1){
			if (printToTerminal){
				System.out.println("You do not have enough resources to build a road.");
			}
			return false;
		}
		if(numberOfRoads==15){
			if (printToTerminal){
				System.out.println("You have already built the maximum number of roads.");
			}
			return false;
		}
		return true;
	}
	
	public void addPort(int i){
		if(i==0)
			portTracker.addThreePort();
		if(i==1)
			portTracker.addRockPort();
		if(i==2)
			portTracker.addWheatPort();
		if(i==3)
			portTracker.addBrickPort();
		if(i==4)
			portTracker.addWoodPort();
		if(i==5)
			portTracker.addSheepPort();
	}

	public boolean usePortCheck(int portType){
		return portTracker.getxPort(portType);
	}

	
	public void placeRoad(){
		numberOfRoads++;
	}
	
	public void buildRoad(){
		resourceTracker.useBrick(1);
		resourceTracker.useWood(1);
		placeRoad();
	}
	
	public int getID(){
		return playerID;
	}
	
	public void printStats(){
		System.out.println("Stats for player: "+playerID);
		System.out.println("Number of Settlements: " +numberOfSettlements);
		System.out.println("Number of Cities: " +numberOfCities);
		System.out.println("Number of Roads: " +numberOfRoads);
		System.out.println("Victory Points: " +victoryPoints);
	}
	
	public int[] getGameStateStats(){
		int[] toReturn = new int[4];
		toReturn[0] = numberOfSettlements;
		toReturn[1] = numberOfCities;
		toReturn[2] = numberOfRoads;
		toReturn[3] = victoryPoints;
		
		return toReturn;
	}
	
	//method for testing
	public void giveSettlementResources(){
		resourceTracker.addWheat(1);
		resourceTracker.addBrick(1);
		resourceTracker.addWood(1);
		resourceTracker.addSheep(1);
	}
	
	public void giveCityResources(){
		resourceTracker.addWheat(2);
		resourceTracker.addRock(3);
	}
	
	public void giveRoadResources(){
		resourceTracker.addBrick(1);
		resourceTracker.addWood(1);
	}

}
