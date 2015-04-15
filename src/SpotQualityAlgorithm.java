/* algorithm that determines the qulaity of a spot based on a set of features and associated weights */


public class SpotQualityAlgorithm {
	double[] weightOfVertexNum; //test learning= try to determine something meaningful about the weight of vertex for winning	
	double[] weightOfAllFeats;
	
	public SpotQualityAlgorithm(){
		weightOfVertexNum = new double[55];
		weightOfAllFeats = new double[35];
	} 
	
	public void incrementVertexNumWeight (int v){
		weightOfVertexNum[v] += .1;
		System.out.println(weightOfVertexNum[v] );
	}
	
	public void decrementVertexNumWeight (int v){
		weightOfVertexNum[v] -= .1;
	}
	
	public void incrementFeatures(int[] goodFeats){
		for (int i = 0; i<goodFeats.length; i++){
			if (goodFeats[i] == 1){
				weightOfAllFeats[i] += .1;
			}
		}
	}
	
	public void printFeatureWeights(){
		/*for (int i=0; i<weightOfVertexNum.length; i++){
			System.out.println("Weight of vertex: "+i+" is "+weightOfVertexNum[i]);
		}
		*/
		for (int i=0; i<weightOfAllFeats.length; i++){
			System.out.println("Weight of feature: "+i+" is "+weightOfAllFeats[i]);
		}
	}
}