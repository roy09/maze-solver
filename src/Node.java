import java.util.List;
import java.util.LinkedList;

public class Node {
	int x;
	int y;
	public String data;
	public boolean visited = false;
	public List adjacentNodes = new LinkedList();
	Node parent = null;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void addAdjacentNode(final Node node){
		adjacentNodes.add(node);
		node.adjacentNodes.add(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(x)+ Integer.toString(y);
	}
	
	public void printNeighbor(){
		for(int i = 0; i < adjacentNodes.size(); i++){
			System.out.print(adjacentNodes.get(i) + " ");
		}
		System.out.println();
	}
}