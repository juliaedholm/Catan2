
public class TestSmartAI {
	
	public static void main (String[] args){
		//creates Player classes for each player and stores in players[]
		int numRuns = 100;
		int [] numWinsPerPlayer = new int[5];
		
		for (int i = 0; i< numRuns; i ++){
			RunGame gameRunner = new RunGame(4, false, true);
			int winner = gameRunner.runGameWithAI(false);
			numWinsPerPlayer[winner] ++;
		}
		System.out.println("Ran "+ numRuns+ "games");
		System.out.println("Player 1 won: "+numWinsPerPlayer[1]);
		System.out.println("Player 2 won: "+numWinsPerPlayer[2]);		
		System.out.println("Player 3 won: "+numWinsPerPlayer[3]);
		System.out.println("Player 4 won: "+numWinsPerPlayer[4]);
	}
}
