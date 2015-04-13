//class that represents the connection between verticies
public class Edge {

	CatanVertex 	v1;
	CatanVertex v2;
	boolean hasRoad;
	Player 	owner; //person who owns the road 

	public Edge(CatanVertex start, CatanVertex end){
		v1= start;
		v2 = end;
	}
	
	public void buildRoad(Player builder){
		if (hasRoad) {
			System.out.println("ERROR, this edge alread has a road!");
		} else {
			hasRoad = true;
			owner = builder;
		}
	}
}
