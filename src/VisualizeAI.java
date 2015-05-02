
public class VisualizeAI {
	
	public static void main (String[] args){
		//creates Player classes for each player and stores in players[]
		RunGame gameRunner = new RunGame(4, false, true, true); 
		
		/* get the game state graphically*/
		GraphController theGraph = gameRunner.gl.graph;
		int[][]board = gameRunner.board;
		int[][] newBoard = new int[19][2];
		for (int i = 0; i<newBoard.length; i++){
			newBoard[i][0]= board[0][i];
			newBoard[i][1]= board[1][i];
		}
		Hexanew h = new Hexanew(newBoard);
		
		CatanVertex[] verticesInGraph = theGraph.vertices;
		for (int i = 0; i< verticesInGraph.length; i++){
			CatanVertex currentV = verticesInGraph[i];
			//add city/settlements as appropriate
			if (currentV.getOwner() != null){
				if (currentV.getSettlementType() == 1){
					System.out.println("found a settlement!");
					h.addSettlementWithAI(i, currentV.getOwner().getID());
				} else if (currentV.getSettlementType() == 2){
					h.addCityWithAI(i, currentV.getOwner().getID());
				}
			}
			//add roads if they were buit
			Edge[] edges = currentV.getEdges();
			for (int j = 0; j<currentV.getNumEdges(); j++ ){
				Edge e = edges[j];
				if (e.owner != null) {
					h.addRoad(e.v1.vertexNumber, e.v2.vertexNumber, e.owner.getID());
				}
			}
		}
			
		h.repaint();
		
	}
}
