
public class PlayManyGames {
	
	public static void main (String[] args){
		SpotQualityAlgorithm spotQuality = new SpotQualityAlgorithm ();
		int numRuns = 10;
		
		for (int j=0; j<numRuns; j++){
			RunGame gameRunner = new RunGame(4, false, true, true); //will used a fixed board
			gameRunner.runGameWithAI(false);
			GraphController theGraph = gameRunner.gl.graph;
			Vertex[] verticesInGraph = theGraph.vertices;
			
			int winningPlayer = gameRunner.runGameWithAI(false);
			int[][] initialSettlementsAllPlayers = gameRunner.getInitialPlayerSets();
			
			for (int i = 1; i<initialSettlementsAllPlayers.length; i++){
				int [] playerStartSettlements = initialSettlementsAllPlayers[i];
				int spot1 = playerStartSettlements[1];
				int spot2 = playerStartSettlements[2];
				if (i == winningPlayer){
					Vertex v1 = verticesInGraph[spot1];
					/*  incriment feature weights for the winning player */
					spotQuality.incrimentVertexNumWeight(spot1);
					spotQuality.incrimentVertexNumWeight(spot2);
				}  else {
					/*decriment feature weights for loosing players */
					spotQuality.decrimentVertexNumWeight(spot1);
					spotQuality.decrimentVertexNumWeight(spot2);
				}
			}
		}
		
		spotQuality.printVertexNumAndWeights();
			
	}
}