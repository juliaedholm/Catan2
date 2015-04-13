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
		return edges;
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
	
	public CatanVertex[] getVertices2Away(){
		/*
		int numSpotsToBuild = 0;
		for (int i=0; i<edges.length;  i++){
			//edges will connect you to vertex 1 away
			Edge e = edges[i];
			Vertex vertexA = e.v1;
			Vertex vertexB = e.v2;
			Edge[] twoAway = vertexA.getEdges();
			numEs = vertexA.getNumEdges();
			if (vertexA = this){
				twoAway = vertexB.getEdges();
				numEs = vertexB.getNumEdges();
			}

			for (int j = 0; j<numEs; j++){
				Vertex v1 = twoAway[j].v1;
				Vertex v2 = aEs[j].v2;
				if (v1 != vertexA){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexA){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
			
			for (int j = 0; j< vertexB.getNumEdges(); j++){
				Vertex v1 = bEs[j].v1;
				Vertex v2 = bEs[j].v2;
				if (v1 != vertexB){
					if (v1.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				} else if (v2 != vertexB){
					if (v2.getSettlementType() == 0){
						numSpotsToBuild ++;
					}
				}
			}
		}
		*/
		return new CatanVertex[2];
	}
	
	public CatanVertex[] getAdjacentVs(){
		/*
		Vertex[] toReturn = new Vertex[3];
		int vCount = 0;
		for (int i=0; i<edges.length;  i++){
			//edges will connect you to vertex 1 away
			Edge e = edges[i];
			Vertex vertexA = e.v1;
			Vertex vertexB = e.v2;
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
			Vertex[] smallerArray = new Vertex[vCount];
			for (int i = 0; i<vCount; i++){
				smallerArray[i] = toReturn[i];
			}
			return smallerArray;
		}
		*/
		return new CatanVertex[2];
	}
	
}
