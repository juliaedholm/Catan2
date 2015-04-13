/* class will take a vertex object and return the boolean prescence of  features in an array */

public class GetSpotFeatures {
	/*
	 * 0 = sheep
	 */
	public int[] getFeaturesForVertex (Vertex v){
		boolean debug = false;
		
		int[] toReturn = new int[5];
		if (sheep(v)){
			toReturn[0] = 1;
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
		return false;
	}
	
	private boolean wheat(Vertex v){
		return false;
	}
	
	private boolean brick(Vertex v){
		return false;
	}
	
	private boolean wood(Vertex v){
		return false;
	}
	
	private boolean sheep(Vertex v){
		return false;
	}
	
	private boolean on2(Vertex v){
		return false;
	}
	
	private boolean on3(Vertex v){
		return false;
	}
	///etc for all rolls through 12
	
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
		return false;
	}
	
	private boolean touchesTwoDiffResources (Vertex v){
		return false;
	}
	
	private boolean touchesOneTypeOfResource (Vertex v){
		return false;
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
	
	private boolean onScarceResource(Veretx v){
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