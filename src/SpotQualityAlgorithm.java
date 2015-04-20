/* algorithm that determines the qulaity of a spot based on a set of features and associated weights */


public class SpotQualityAlgorithm {
	double[] weightOfVertexNum; //test learning= try to determine something meaningful about the weight of vertex for winning	
	double[] weightOfAllFeats;
	int numberOfGames;
	
	public SpotQualityAlgorithm(int numFeatures, int numGames){
		weightOfVertexNum = new double[55];
		weightOfAllFeats = new double[numFeatures];
		for (int i = 0; i<weightOfAllFeats.length; i++){
			weightOfAllFeats[i] = 0;
		}
		numberOfGames = numGames;
	} 
	
	public void incrementVertexNumWeight (int v){
		weightOfVertexNum[v] += .1;
		System.out.println(weightOfVertexNum[v] );
	}
	
	public void decrementVertexNumWeight (int v){
		weightOfVertexNum[v] -= .1;
	}
	
	public void winnersFeatures(int[] goodFeats){
		for (int i = 0; i<goodFeats.length; i++){
			if (goodFeats[i] == 1){
				weightOfAllFeats[i] = weightOfAllFeats[i] + 1;
			} else if (goodFeats[i] == 0){
				weightOfAllFeats[i]= weightOfAllFeats[i] - 0 ;
			}
		}
	}

	public void loosersFeatures(int[] badFeats){
		for (int i = 0; i<badFeats.length; i++){
			if (badFeats[i] == 1){
				weightOfAllFeats[i] -= 1;
			} 
		}
	}
	
	public void printFeatureWeights(){
		/*for (int i=0; i<weightOfVertexNum.length; i++){
			System.out.println("Weight of vertex: "+i+" is "+weightOfVertexNum[i]);
		}
		*/
		for (int i=0; i<weightOfAllFeats.length; i++){
			weightOfAllFeats[i] = weightOfAllFeats[i]/numberOfGames;
		}
		for (int i=0; i<weightOfAllFeats.length; i++){
			System.out.println("Weight of feature: "+i+" is "+weightOfAllFeats[i]);
		}
	}
}