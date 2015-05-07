

public class LearnedWeights {
	double[] weightOfAllFeats;
	GetSpotFeatures featFinder;
	GraphController graph;
	CatanVertex[] verticesInGraph;
	
	public LearnedWeights(GraphController g){
		weightOfAllFeats = new double[71];
		weightOfAllFeats[4] = 2.002;
		weightOfAllFeats[20] = 0;
		weightOfAllFeats[22] = 0.0004;
		weightOfAllFeats[23] =    -0.0003;
		weightOfAllFeats[25] =    -0.0002;
		weightOfAllFeats[43] =    -0.0006;
		weightOfAllFeats[48] =    -0.0004;
		weightOfAllFeats[53] =    -0.0001;
		weightOfAllFeats[58] =    -0.0001;
		
		featFinder = new GetSpotFeatures();
		graph = g;
		verticesInGraph = graph.vertices;
	}
	
	public double getSpotWeight(int v){
		double weight =   -0.9996;
		CatanVertex vert = verticesInGraph[v];
		int[] feats = featFinder.getFeaturesForVertex(vert, graph);
		for (int i = 0; i<weightOfAllFeats.length; i++){
			weight += weightOfAllFeats[i]*feats[i];
		}
		return weight;
	}
	
}