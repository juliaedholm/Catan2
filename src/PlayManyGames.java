
public class PlayManyGames {
	
	public static void main (String[] args){
		SpotQualityAlgorithm spotQuality = new SpotQualityAlgorithm ();
		int numRuns = 10;
		
		GetSpotFeatures feats = new GetSpotFeatures();
		
		for (int j=0; j<numRuns; j++){
			RunGame gameRunner = new RunGame(4, false, true, true); //will used a fixed board
			int winningPlayer = gameRunner.runGameWithAI(false);
			GraphController theGraph = gameRunner.gl.graph;
			CatanVertex[] verticesInGraph = theGraph.vertices;
			
			int[][] initialSettlementsAllPlayers = gameRunner.getInitialPlayerSets();
			
			for (int i = 1; i<initialSettlementsAllPlayers.length; i++){
				int [] playerStartSettlements = initialSettlementsAllPlayers[i];
				int spot1 = playerStartSettlements[1];
				int spot2 = playerStartSettlements[2];
				if (i == winningPlayer){
					CatanVertex v1 = verticesInGraph[spot1];
					/*  incriment feature weights for the winning player */
					int[] features = feats.getFeaturesForVertex (v1);
					spotQuality.incrementVertexNumWeight(spot1);
					spotQuality.incrementVertexNumWeight(spot2);
				}  else {
					/*decriment feature weights for loosing players */
					spotQuality.decrementVertexNumWeight(spot1);
					spotQuality.decrementVertexNumWeight(spot2);
				}
			}
		}
		
		//spotQuality.printVertexNumAndWeights();
			
	}
}