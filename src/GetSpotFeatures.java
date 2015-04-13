/* class will take a vertex object and return the boolean prescence of  features in an array */

public class GetSpotFeatures {
	ResourceTranslator translator = new ResourceTranslator();
	/*
	 * 0 = rock
	 * 1 = wheat
	 * 2 = brick
	 * 3 = wood
	 * 4 = sheep	 
	 * 5 = on2
	 * 6 = on3
	 * 7 = on4
	 * 8 = on5
	 * 9 = on6
	 * 10 = on8
	 * 11 = on9
	 * 12 = on10
	 * 13 = on11
	 * 14 = on12
	 * 15 = oneDot
	 * 16 = twoDot
	 * 17 = threeDot
	 * 18 = fourDot
	 * 19 = fiveDot
	 * 20 = touches 3 different Resouces
	 * 21 = touches 2 different resources
	 * 22 = touches 1 different resource
	 */
	
	public int[] getFeaturesForVertex (Vertex v){
		boolean debug = true;
		
		int[] toReturn = new int[30];


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
		if (on2(v)){
			toReturn[5] = 1;
		}
		if (on3(v)){
			toReturn[6] = 1;
		}
		if (on4(v)){
			toReturn[7] = 1;
		}
		if (on5(v)){
			toReturn[8] = 1;
		}
		if (on6(v)){
			toReturn[9] = 1;
		}
		if (on8(v)){
			toReturn[10] = 1;
		}
		if (on9(v)){
			toReturn[11] = 1;
		}
		if (on10(v)){
			toReturn[12] = 1;
		}
		if (on11(v)){
			toReturn[13] = 1;
		}
		if (on12(v)){
			toReturn[14] = 1;
		}
		if (oneDot(v)){
			toReturn[15] = 1;
		}
		if (twoDot(v)){
			toReturn[16] = 1;
		}
		if (threeDot(v)){
			toReturn[17] = 1;
		}
		if (fourDot(v)){
			toReturn[18] = 1;
		}
		if (fiveDot(v)){
			toReturn[19] = 1;
		}
		if (touchesThreeDiffResources(v) ){
			toReturn[20] = 1;
		}
		if (touchesTwoDiffResources(v)){
			toReturn[21] = 1;
		}
		if (touchesOneTypeOfResource(v)){
			toReturn[22] = 1;
		}

		
		if (debug){
			System.out.println("features for vertex "+v.vertexNumber);
			for (int i = 0; i<toReturn.length; i++){
				System.out.print(i+": ");
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
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==2){
				return true;
			}
		}
		return false;
	}
	
	private boolean on3(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==3){
				return true;
			}
		}
		return false;
	}

	private boolean on4(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==4){
				return true;
			}
		}
		return false;
	}

	private boolean on5(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==5){
				return true;
			}
		}
		return false;
	}
	private boolean on6(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==6){
				return true;
			}
		}
		return false;
	}

	private boolean on8(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==8){
				return true;
			}
		}
		return false;
	}

	private boolean on9(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==9){
				return true;
			}
		}
		return false;
	}

	private boolean on10(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==10){
				return true;
			}
		}
		return false;
	}

	private boolean on11(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==11){
				return true;
			}
		}
		return false;
	}

	private boolean on12(Vertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==12){
				return true;
			}
		}
		return false;
	}

	
	private boolean oneDot (Vertex v){
		if(on2(v) || on12(v)){
			return true;
		}
		return false;
	}
	
	private boolean twoDot (Vertex v){
		if(on3(v) || on11(v)){
			return true;
		}
		return false;
	}

	private boolean threeDot (Vertex v){
		if(on4(v) || on10(v)){
			return true;
		}
		return false;
	}
	
	private boolean fourDot (Vertex v){
		if(on5(v) || on9(v)){
			return true;
		}
		return false;
	}
	private boolean fiveDot (Vertex v){
		if(on6(v) || on8(v)){
			return true;
		}
		return false;
	}
	

	
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
	private boolean onThreeTiles (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int numResourcesOnSpot = 0;
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (r != 0){
				numResourcesOnSpot ++;
			}
		}
		return numResourcesOnSpot == 3;
	}
	
	private boolean onTwoTiles (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int numResourcesOnSpot = 0;
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (r != 0){
				numResourcesOnSpot ++;
			}
		}
		return numResourcesOnSpot == 2;
	}
	
	private boolean onOneTile (Vertex v){
		Tile[] tiles = v.getAdjacentTiles();
		int numResourcesOnSpot = 0;
		for (int i =0; i<tiles.length; i++){
			Tile t = tiles[i];
			int r = t.resource;
			if (r != 0){
				numResourcesOnSpot ++;
			}
		}
		return numResourcesOnSpot == 1;
	}
	
	private boolean hasAtLeast2BuildableSpots (Vertex v){
		Edge[] es = v.getEdges();
		int numSpotsToBuild = 0;
		for (int i=0; i<v.getNumEdges(); i++){
			Edge e = es[i];
			Vertex vertexA = e.v1;
			Vertex vertexB = e.v2;
			Edge[] aEs = vertexA.getEdges();
			Edge[] bEs = vertexB.getEdges();
			
			for (int j = 0; j< vertexA.getNumEdges(); j++){
				Vertex v1 = aEs[j].v1;
				Vertex v2 = aEs[j].v2;
				if (v1 != vertexA){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexA){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
			
			for (int j = 0; j< vertexB.getNumEdges(); j++){
				Vertex v1 = bEs[j].v1;
				Vertex v2 = bEs[j].v2;
				if (v1 != vertexB){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexB){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
		}
		return numSpotsToBuild >=2;		
	}
	
	private boolean doesNotHave2BuildableSpots (Vertex v){
		Edge[] es = v.getEdges();
		int numSpotsToBuild = 0;
		for (int i=0; i<v.getNumEdges(); i++){
			Edge e = es[i];
			Vertex vertexA = e.v1;
			Vertex vertexB = e.v2;
			Edge[] aEs = vertexA.getEdges();
			Edge[] bEs = vertexB.getEdges();
			
			for (int j = 0; j< vertexA.getNumEdges(); j++){
				Vertex v1 = aEs[j].v1;
				Vertex v2 = aEs[j].v2;
				if (v1 != vertexA){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexA){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
			
			for (int j = 0; j< vertexB.getNumEdges(); j++){
				Vertex v1 = bEs[j].v1;
				Vertex v2 = bEs[j].v2;
				if (v1 != vertexB){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexB){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
		}
		return numSpotsToBuild <2;
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