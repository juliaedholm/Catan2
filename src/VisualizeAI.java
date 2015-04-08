
public class VisualizeAI {
	
	public static void main (String[] args){
		//creates Player classes for each player and stores in players[]
		RunGame gameRunner = new RunGame(4, false, true, true);
		gameRunner.runGameWithAI(false);
		
		/* get the game state graphically*/
		GraphController theGraph = gameRunner.gl.graph;
		int[][]board = gameRunner.board;
		int[][] newBoard = new int[19][2];
		for (int i = 0; i<newBoard.length; i++){
			newBoard[i][0]= board[0][i];
			newBoard[i][1]= board[1][i];
		}
		Hexanew h = new Hexanew(newBoard);
		int[][] citiesAndSets = theGraph.getVerticesAndSettlementTypes();
		for (int i=0; i<citiesAndSets.length; i++){
			if (citiesAndSets[i][0] == 1){
				System.out.println("found a settlement!");
				h.addSettlementWithAI(i, citiesAndSets[i][1]);
			} else if (citiesAndSets[i][0] == 2){
				h.addCityWithAI(i, citiesAndSets[i][1]);
			}
		}
		h.repaint();
		
	}
}
