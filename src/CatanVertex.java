/* JE
 * The vertex object reflects each intersection of tiles on the catan board. 
 * Each vertex links to three tiles (either a standard resource or a port tile)
 * The vertex may be occupied with a settlement or a city 
 */

public class CatanVertex {
	private Tile[] adjacentTiles; //the list of Tiles that this vertex touches
	private Tile port; //the port associated with this spot, if there is one
	private Player owner;
	private int 	settlementType; //0= empty, 1= settlement, 2= city
	private Edge[] edges;
	private int numEdgesSet;
	public int vertexNumber;
	
	public CatanVertex(Tile[] t, int num){
		adjacentTiles = t;
		edges = new Edge[3];
		numEdgesSet= 0;
		settlementType = 0;
		vertexNumber = num;
	}
	
	public void addEdge(Edge e){
		edges[numEdgesSet] = e;
		numEdgesSet ++;
	}
	
	public void addPort (Tile p){
		port = p;
	}
	
	public Tile[] getAdjacentTiles(){
		return adjacentTiles;
	}
	
	public Edge[] getEdges(){
		if (numEdgesSet == edges.length){
			return edges;
		} else {
			Edge[] toReturn = new Edge[numEdgesSet];
			for (int i=0; i<numEdgesSet; i++){
				toReturn[i] = edges[i];
			}
			return toReturn;
		}
	}
	
	public int getNumEdges(){
		return numEdgesSet;
	}
	
	public void printResources(){
		for (int i=0; i<adjacentTiles.length; i++){
			adjacentTiles[i].printTile();
		}
	}
	
	public void setOwner(Player p){
		owner = p;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void buildSettlement(Player p){
		settlementType = 1;
		setOwner(p);
		if (port != null){
			owner.addPort(port.portType);
		}
	}
	
	public void buildCity(){
		if (settlementType !=1 ){
			System.out.println("Error, trying to build city w/o settlement");
			return;
		}
		settlementType = 2;
	}
	
	public int getSettlementType() {
		return settlementType;
	}
	
	//returns an array with all of the vertices 2 from current vertex
	public CatanVertex[] getVertices2Away(){
		boolean debug2away = false;
		CatanVertex[] toReturn = new CatanVertex[6];
		int numInReturnArray = 0;
		for (int i=0; i<numEdgesSet;  i++){
			Edge e = edges[i];
			//edges will connect you to vertex 1 away
			CatanVertex vertexA = e.v1;
			CatanVertex vertexB = e.v2;
			//twoAway will contain the vertices one away from vertexA or vertexB
			CatanVertex[] twoAway = getAdjacentVs(vertexA);
			if (debug2away){
				System.out.println("on edge number "+i+" vertex A: "+e.v1.vertexNumber+" vertex B: "+e.v2.vertexNumber);
				System.out.println("Adjacent vs for vertex A: ");
				for (int j =0 ; j<twoAway.length; j++){
					System.out.println(twoAway[j].vertexNumber);
				}
			}
			if (vertexA == this){
				twoAway = getAdjacentVs(vertexB);
				if (debug2away){
					System.out.println("Vertex A was this vertex. using vertex B");
					System.out.println("Adjacent vs for vertex B: ");
					for (int j =0 ; j<twoAway.length; j++){
						System.out.println(twoAway[j].vertexNumber);
					}
				}
			}

			for (int j = 0; j<twoAway.length; j++){
				//check that this vertex has not already been added to the array
				boolean inArray = false;
				for (int c = 0; c<numInReturnArray; c++){
					if (toReturn[c] == twoAway[j]){
						inArray = true;
					}
				}
				if (!inArray){
					if (twoAway[j]!= vertexA && twoAway[j]!= vertexB && twoAway[j] != this){
						toReturn[numInReturnArray] = twoAway[j];
						numInReturnArray ++;
					}
				}
			}
		}
		if (numInReturnArray == toReturn.length){
			return toReturn;
		} else {
			CatanVertex[] smallerArray = new CatanVertex[numInReturnArray];
			for (int i = 0; i<numInReturnArray; i++){
				smallerArray[i] = toReturn[i];
			}
			return smallerArray;
		}
	}
	
	//returns an Array with the vertices 1 away from current vertex
	public CatanVertex[] getAdjacentVs(CatanVertex v){
		CatanVertex[] toReturn = new CatanVertex[3];
		Edge[] es = v.getEdges();
		int vCount = 0;
		for (int i=0; i<es.length;  i++){
			//edges will connect you to vertex 1 away
			Edge e = es[i];
			CatanVertex vertexA = e.v1;
			CatanVertex vertexB = e.v2;
			if (vertexA != v){
				toReturn[vCount] = vertexA;
				vCount ++;
			} else {
				toReturn[vCount] = vertexB;
				vCount ++;
			}
		}
		
		if (vCount == 3){
			return toReturn;
		} else {
			CatanVertex[] smallerArray = new CatanVertex[vCount];
			for (int i = 0; i<vCount; i++){
				smallerArray[i] = toReturn[i];
			}
			return smallerArray;
		}
	}
	
}
