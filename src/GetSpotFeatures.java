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
	 * 23 = on 3 tiles
	 * 24 = on 2 tiles
	 * 25 = on 1 tile
	 * 26 = has >=2 builable spots
	 * 27 = has <2 buildable spots
	 * 28 = on Rock Port
	 * 29 = on Wheat Port
	 * 30 = on Brick Port
	 * 31 = on Wood Port
	 * 32 = on Sheep Port
	 */
	
	public int[] getFeaturesForVertex (CatanVertex v){
		boolean debug = true;
		int[] toReturn = new int[32];

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
		if (onThreeTiles(v)){
			toReturn[23] = 1;
		}
		if (onTwoTiles(v)){
			toReturn[24] = 1;
		}
		if (onOneTile(v)){
			toReturn[25] = 1;
		}
		if (hasAtLeast2BuildableSpots(v)){
			toReturn[26] = 1;
		}
		if (doesNotHave2BuildableSpots(v)){
			toReturn[27] = 1;
		}
		if (onRockPort(v)){
			toReturn[28] = 1;
		}
		if (onWheatPort(v)){
			toReturn[29] = 1;
		}
		if (onBrickPort(v)){
			toReturn[30] = 1;
		}
		if (onWoodPort(v)){
			toReturn[31] = 1;
		}
		if (onSheepPort(v)){
			toReturn[32] = 1;
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
	
	private boolean rock(CatanVertex v){
		//check graph if that vertex is on rock. Return true if so
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Rock){
				return true;
			}
		}
		return false;
	}
	
	private boolean wheat(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Wheat){
				return true;
			}
		}
		return false;
	}
	
	private boolean brick(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Brick){
				return true;
			}
		}
		return false;
	}
	
	private boolean wood(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Wood){
				return true;
			}
		}
		return false;
	}

	
	private boolean sheep(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].resource==translator.Sheep){
				return true;
			}
		}
		return false;
	}
	
	private boolean on2(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==2){
				return true;
			}
		}
		return false;
	}
	
	private boolean on3(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==3){
				return true;
			}
		}
		return false;
	}

	private boolean on4(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==4){
				return true;
			}
		}
		return false;
	}

	private boolean on5(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==5){
				return true;
			}
		}
		return false;
	}
	private boolean on6(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==6){
				return true;
			}
		}
		return false;
	}

	private boolean on8(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==8){
				return true;
			}
		}
		return false;
	}

	private boolean on9(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==9){
				return true;
			}
		}
		return false;
	}

	private boolean on10(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==10){
				return true;
			}
		}
		return false;
	}

	private boolean on11(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==11){
				return true;
			}
		}
		return false;
	}

	private boolean on12(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].roll==12){
				return true;
			}
		}
		return false;
	}

	
	private boolean oneDot (CatanVertex v){
		if(on2(v) || on12(v)){
			return true;
		}
		return false;
	}
	
	private boolean twoDot (CatanVertex v){
		if(on3(v) || on11(v)){
			return true;
		}
		return false;
	}

	private boolean threeDot (CatanVertex v){
		if(on4(v) || on10(v)){
			return true;
		}
		return false;
	}
	
	private boolean fourDot (CatanVertex v){
		if(on5(v) || on9(v)){
			return true;
		}
		return false;
	}
	private boolean fiveDot (CatanVertex v){
		if(on6(v) || on8(v)){
			return true;
		}
		return false;
	}
	
	private boolean touchesThreeDiffResources (CatanVertex v){
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
	
	private boolean touchesTwoDiffResources (CatanVertex v){
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
	
	private boolean touchesOneTypeOfResource (CatanVertex v){
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
	
	//false if you touch 2 or 3. 
	private boolean onThreeTiles (CatanVertex v){
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
	
	private boolean onTwoTiles (CatanVertex v){
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
	
	private boolean onOneTile (CatanVertex v){
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
	
	private boolean hasAtLeast2BuildableSpots (CatanVertex v){
		boolean debug2Away = false;
		int freeSpotCount = 0;
		CatanVertex [] twoAway = v.getVertices2Away();
		for (int i =0 ; i<twoAway.length; i++){
			if (twoAway[i].getSettlementType() == 0){
				freeSpotCount ++;
				if (debug2Away){
					System.out.println("At vertex: "+v.vertexNumber+" empty vertex "+twoAway[i].vertexNumber+" is 2 edges away");
				}
			}
		}
		return freeSpotCount >=2;
	}
	
	private boolean doesNotHave2BuildableSpots (CatanVertex v){
		boolean debug2Away = false;
		int freeSpotCount = 0;
		CatanVertex [] twoAway = v.getVertices2Away();
		for (int i =0 ; i<twoAway.length; i++){
			if (twoAway[i].getSettlementType() == 0){
				freeSpotCount ++;
				if (debug2Away){
					System.out.println("At vertex: "+v.vertexNumber+" empty vertex "+twoAway[i].vertexNumber+" is 2 edges away");
				}
			}
		}
		return freeSpotCount <2;
		}
	
	private boolean onRockPort(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].portType==1 && tiles[i].isPort){
				return true;
			}
		}
		return false;
	}
	private boolean onWheatPort(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].portType==2 && tiles[i].isPort){
				return true;
			}
		}
		return false;
	}	
	private boolean onBrickPort(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].portType==3 && tiles[i].isPort){
				return true;
			}
		}
		return false;
	}
	private boolean onWoodPort(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].portType==4 && tiles[i].isPort){
				return true;
			}
		}
		return false;
	}	
	private boolean onSheepPort(CatanVertex v){
		Tile [] tiles = v.getAdjacentTiles();
		for (int i=0; i<tiles.length; i++){
			if(tiles[i].portType==4 && tiles[i].isPort){
				return true;
			}
		}
		return false;
	}	
	
	private boolean onScarceResource(CatanVertex v){
		//must think about how to define scarce....
		return false;
	}
	
	
	
}