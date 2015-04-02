
public class TestStartPositionsFixedBoard {
	
	public static void main (String[] args){
		//creates Player classes for each player and stores in players[]
		int numRuns = 100;
		int [] numWinsPerSpot = new int[55];
		
		for (int i = 0; i< numRuns; i ++){
			RunGame gameRunner = new RunGame(4, false, true, true);
			int[] winnerStats = gameRunner.runGameWithAI(false); //game runner will return an int[] that contians winning player and the two start vertices
			int spot1 = winnerStats[1];
			numWinsPerSpot[spot1] ++;
			int spot2 = winnerStats[2];
			numWinsPerSpot[spot2] ++;
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
