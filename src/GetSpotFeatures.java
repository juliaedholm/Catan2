/* class will take a vertex object and return the boolean prescence of  features in an array */

public class GetSpotFeatures {
	ResourceTranslator translator = new ResourceTranslator();
	/*
	 * 0 = rock
	 * 1 = wheat
	 * 2 = brick
	 * 3 = wood
	 * 4 = sheep	 
	 * 
	 * 15 = touches 3 different Resouces
	 * 16 = touches 2 different resources
	 * 17 = touches 1 different resource
	 */
	
	public int[] getFeaturesForVertex (Vertex v){
		boolean debug = true;
		
		int[] toReturn = new int[20];


		if (rock(v)){
			toReturn[0] = 1;
		}
		if (wheat(v)){
			toReturn[1] = 1;
		}
		if (brick(v)){
			toReturn[2] = 1;
		}
		if (wood(v)){
			toReturn[3] = 1;
		}
		if (sheep(v)){
			toReturn[4] = 1;
		}
		if (touchesThreeDiffResources(v) ){
			toReturn[15] = 1;
		}
		if (touchesTwoDiffResources(v)){
			toReturn[16] = 1;
		}
		if (touchesOneTypeOfResource(v)){
			toReturn[17] = 1;
		}

		
		if (debug){
			System.out.println("features for vertex "+v.vertexNumber);
			for (int i = 0; i<toReturn.length; i++){
				System.out.println(toReturn[i]);
			}
		}
		return toReturn;
	}
	
	//Julia P do stuff from here
	private boolean rock(Vertex v){
		//check graph if that vertex is on rock. Return true if so
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Rock){
				return true;
			}
		}
		return false;
	}
	
	private boolean wheat(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Wheat){
				return true;
			}
		}
		return false;
	}
	
	private boolean brick(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Brick){
				return true;
			}
		}
		return false;
	}
	
	private boolean wood(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Wood){
				return true;
			}
		}
		return false;
	}

	
	private boolean sheep(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Sheep){
				return true;
			}
		}
		return false;
	}
	
	private boolean on2(Vertex v){
		return false;
	}
	
	private boolean on3(Vertex v){
		return false;
	}

	private boolean on4(Vertex v){
		return false;
	}

	private boolean on5(Vertex v){
		return false;
	}
	private boolean on6(Vertex v){
		return false;
	}

	private boolean on8(Vertex v){
		return false;
	}

	private boolean on9(Vertex v){
		return false;
	}

	private boolean on10(Vertex v){
		return false;
	}

	private boolean on11(Vertex v){
		return false;
	}

	private boolean on12(Vertex v){
		return false;
	}

	
	private boolean oneDot (Vertex v){
		return false;
	}
	
	private boolean twoDot (Vertex v){
		return false;
	}
	//etc for all dots through 5
	
	//Julia P stop here
	
	//Julia E start here
	private boolean touchesThreeDiffResources (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int[] resourceCounts = new int[6];
		int numDiffResourcesOnSpot = 0;
		
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (resourceCounts[r] == 0){
				resourceCounts[r] ++;
				numDiffResourcesOnSpot ++;
			}
		}
		
		return numDiffResourcesOnSpot == 1;
	}
	
	private boolean touchesTwoDiffResources (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int[] resourceCounts = new int[6];
		int numDiffResourcesOnSpot = 0;
		
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (resourceCounts[r] == 0){
				resourceCounts[r] ++;
				numDiffResourcesOnSpot ++;
			}
		}
		
		return numDiffResourcesOnSpot == 2;
	}
	
	private boolean touchesOneTypeOfResource (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int[] resourceCounts = new int[6];
		int numDiffResourcesOnSpot = 0;
		
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (resourceCounts[r] == 0){
				resourceCounts[r] ++;
				numDiffResourcesOnSpot ++;
			}
		}
		
		return numDiffResourcesOnSpot == 3;
	}
	
	//false if you touch 2 or 3. 
	private boolean onSingleResource (Vertex v){
		
		return false;
	}
	
	private boolean onTwoResources (Vertex v){
		return false;
	}
	
	private boolean onOneResource (Vertex v){
		return false;
	}
	
	private boolean hasAtLeast2BuildableSpots (Vertex v){
		return false;
	}
	
	private boolean doesNotHave2BuildableSpots (Vertex v){
		return false;
	}
	
	private boolean onScarceResource(Vertex v){
		//must think about how to define scarce....
		return false;
	}
	
	//julia e stop here
	
	//CJ do all stuff from here
	private boolean onRockPort(Vertex v){
		return false;
	}
	
	private boolean onBrickPort(Vertex v){
		return false;
	}
	//same for all ports
	
	
	
}