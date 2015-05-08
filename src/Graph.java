
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	List nodes = new ArrayList();
	
	public ArrayList<Node> breadthFirstTraversal(Node rootNode, Node destNode){
		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited = true;
		while(!q.isEmpty()){
			Node n = (Node) q.poll();
//			System.out.println(n);
			if (n == destNode){
//				System.out.println("Dest reached " + n.parent + n.parent.parent + n.parent.parent.parent);
				break;
			}
			while(!n.adjacentNodes.isEmpty()){
				Node adj = (Node)n.adjacentNodes.remove(0);
				
				if(!adj.visited){
					adj.parent = n;
					adj.visited = true;
					q.add(adj);
				}
				
			}
		}
//		System.out.println("path boshai");
		
		
//		
		ArrayList<Node> path = new ArrayList<Node>();
		int i = 0;
		Node temp = destNode;
		while(temp != null){
			path.add(temp);
//			System.out.println(temp);
			temp = temp.parent;
		}
		
		return path;
	}
	
}