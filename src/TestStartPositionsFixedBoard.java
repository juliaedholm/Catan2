import java.io.*;

public class TestStartPositionsFixedBoard {
	
	public static void main (String[] args){
		//creates Player classes for each player and stores in players[]
		int numRuns = 10;
		int [] numWinsPerSpot = new int[55];
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter (new FileWriter("data.txt"));
			writer.write("Data for the Test Start Positions Class");
			writer.newLine();
		} catch (Exception e){
			System.out.println("OOPS");
		}
		
		
		for (int i = 0; i< numRuns; i ++){
			RunGame gameRunner = new RunGame(4, false, true, true);
			
			int winningPlayer = gameRunner.runGameWithAI(false);
			int[][] initialSettlementsAllPlayers = gameRunner.getInitialPlayerSets();
			int[] winnerStats = initialSettlementsAllPlayers[winningPlayer];
			Player[] players= gameRunner.getPlayers();
			
			int spot1 = winnerStats[1];
			numWinsPerSpot[spot1] ++;
			int spot2 = winnerStats[2];
			numWinsPerSpot[spot2] ++;

			//print stats in some meaningful way
			if (writer != null){
				try{
					writer.write("Game "+i);
					writer.newLine();
					writer.write("Winner is: "+winnerStats[0]);
					writer.newLine();
					writer.write("Player Information:");
					writer.newLine();
					for (int j=1; j<players.length; j++){
						int[] stats = players[j].getGameStateStats();
						int numSetts = stats[0];
						int numCities = stats[1];
						int numRoads = stats[2];
						int numVPs = stats[3];
						writer.write("Player "+j+" : "+numVPs+" VPs "+numSetts+" settlements "+numCities+" cities "+numRoads+" roads.");
						writer.newLine();
					}
				} catch (Exception e){
					System.out.println("OOPS");
				}
			}
		}
		try{
			writer.close();
		} catch (Exception e){
			System.out.println("Can't close!");
		}
		
		System.out.println("Ran "+ numRuns+ "games");
		int spotWithMostWins = 0;
		for (int i = 0; i<numWinsPerSpot.length; i++){
			System.out.println("spot: "+i+ " has "+numWinsPerSpot[i]+ "wins");
			if (numWinsPerSpot[i] >= numWinsPerSpot[spotWithMostWins]){
				spotWithMostWins = i;
			}
		}
		System.out.println("Spot "+ spotWithMostWins+ "won in: " +numWinsPerSpot[spotWithMostWins]+ " games");
		

	}
}
