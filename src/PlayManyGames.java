import java.io.*;

public class PlayManyGames {
	
	public static void main (String[] args){
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter (new FileWriter("FeatureData.txt"));
			writer.write("Data for the Play Many Games Class");
			writer.newLine();
		} catch (Exception e){
			System.out.println("Can't open the file: Feature Data.txt");
		}
		
		int numRuns = 100;
		SpotQualityAlgorithm spotQuality = new SpotQualityAlgorithm (34, numRuns);
		
		for (int j=0; j<numRuns; j++){
			RunGame gameRunner = new RunGame(4, false, true, false); //will NOT used a fixed board
			int winningPlayer = gameRunner.runGameWithAI(false);
			GraphController theGraph = gameRunner.gl.graph;
			CatanVertex[] verticesInGraph = theGraph.vertices;
			Player[] players = gameRunner.getPlayers();
			int[][] initialSettlementsAllPlayers = gameRunner.getInitialPlayerSets();
			int worstPlayer = 0;
			int minVPs = 10;
			for (int i = 1; i<players.length; i++){
				if (i != winningPlayer){
					int vps = players[i].victoryPoints;
					if (vps< minVPs){
						minVPs = vps;
						worstPlayer = i;
					}
				}
			}
			
			
			for (int i = 1; i<initialSettlementsAllPlayers.length; i++){
				int [] playerStartSettlements = initialSettlementsAllPlayers[i];
				int spot1 = playerStartSettlements[1];
				int spot2 = playerStartSettlements[2];
				if (i == winningPlayer){
					saveDataAboutFeats(verticesInGraph[spot1], 1, writer);
					saveDataAboutFeats(verticesInGraph[spot2], 1, writer);
					learnAboutWinningVertex(verticesInGraph[spot1], spotQuality);
				}  else if (i == worstPlayer){
					saveDataAboutFeats(verticesInGraph[spot1], 0, writer);
					saveDataAboutFeats(verticesInGraph[spot2], 0, writer);
				}
			}
		}
		try{
			writer.close();
		} catch (Exception e){
			System.out.println("Can't close!");
		}
		//spotQuality.printFeatureWeights();
	}
		
	private static void getFeaturesWithGameState(CatanVertex v){
		//might require passing the entire board or information about player hand
	}
		
	private static void saveDataAboutFeats(CatanVertex v, int winLoss, BufferedWriter writer){
		GetSpotFeatures feats = new GetSpotFeatures();
		int[] features = feats.getFeaturesForVertex (v);
		
		//print stats in some meaningful way
		if (writer != null){
			try{
				writer.write("Feature information for vertex: "+v.vertexNumber);
				writer.newLine();
				for (int i = 0; i<features.length; i++){
					writer.write(" "+features[i]+",");
				}
				writer.write(" "+winLoss);
				writer.newLine();
				
			} catch (Exception e){
				System.out.println("OOPS");
			}
		}
		
	}
	
	private static void learnAboutWinningVertex (CatanVertex v, SpotQualityAlgorithm spotQuality){
		GetSpotFeatures feats = new GetSpotFeatures();
		int[] features = feats.getFeaturesForVertex (v);
		spotQuality.winnersFeatures(features);
	}
		
}