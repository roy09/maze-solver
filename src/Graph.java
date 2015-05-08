
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
		
		Stack<Node> path = new Stack<Node>();
		int i = 0;
		Node temp = destNode;
		while(temp != null){
			path.push(temp);
//			System.out.println(temp);
			temp = temp.parent;
		}
		
		
		ArrayList<Node> revertedPath = new ArrayList<Node>();
		while(!path.isEmpty()){
			revertedPath.add(path.pop());
		}
		return revertedPath;
	}
	
}