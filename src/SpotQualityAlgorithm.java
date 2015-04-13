/* algorithm that determines the qulaity of a spot based on a set of features and associated weights */


public class SpotQualityAlgorithm {
	double[] weightOfVertexNum; //test learning= try to determine something meaningful about the weight of vertex for winning	
	
	public SpotQualityAlgorithm(){
		weightOfVertexNum = new double[55];
	} 
	
	public void incrimentVertexNumWeight (int v){
		weightOfVertexNum[v] += .1;
		System.out.println(weightOfVertexNum[v] );
	}
	
	public void decrimentVertexNumWeight (int v){
		weightOfVertexNum[v] -= .1;
	}
	
	
	public void printVertexNumAndWeights(){
		for (int i=0; i<weightOfVertexNum.length; i++){
			System.out.println("Weight of vertex: "+i+" is "+weightOfVertexNum[i]);
		}
	}
}