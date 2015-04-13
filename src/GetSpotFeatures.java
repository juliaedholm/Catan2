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
	
	private boolean sheep(Vertex v){
		//check graph if that vertex is on sheep. Return true if so
	
		return false;
	}
}