import java.util.ArrayList;
import java.util.Stack;


public class Main {
	static Node array[][] = new Node[8][8];
	
	public static void main(String[] args) {
			
//		Add the nodes
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				array[i][j] = new Node(i,j);
			}
		}
		
//		add the blackholes
		ArrayList<Node> blackholes = new ArrayList<Node>();
		blackholes.add(array[0][4]);
		blackholes.add(array[0][2]);
		blackholes.add(array[1][2]);
		
//		add the planets 
		ArrayList<Node> planets = new ArrayList<Node>();
		planets.add(array[4][7]);
		planets.add(array[3][7]);
		
		buildNeighbor(blackholes);
//		System.out.println("traversal");
		
		Graph g = new Graph();
//		g.breadthFirstTraversal(array[7][7], array[4][7]);
//		System.out.println("Distace to 37");
		resetArray(blackholes);
//		g.breadthFirstTraversal(array[7][7], array[3][7]);
		
		
//		77 to nearest
		ArrayList<ArrayList<Node>> path = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < planets.size(); i++){
			ArrayList<Node> temp = g.breadthFirstTraversal(array[7][7], planets.get(i));
			System.out.println(temp.size());
			resetArray(blackholes);
		}
//		
//		print distance
		System.out.println("Short distance");
		for(int i = 0; i < path.size(); i++){
			System.out.println(path.get(i).size());
		}
		
		
	}


	private static void resetArray(ArrayList<Node> blackholes) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				array[i][j] = new Node(i,j);
			}
		}
		buildNeighbor(blackholes);
	}


	private static void printNodes() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.println(array[i][j]);
			}
		}
	}
	
	
	private static void buildNeighbor(ArrayList<Node> blackholes) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				// avoid blackhole
				if (blackholes.contains(array[i][j])){
					continue;
				}
				try{
					if (!blackholes.contains(array[i+1][j])){
						array[i][j].addAdjacentNode(array[i+1][j]);
					}
					
					if (!blackholes.contains(array[i][j+1])){
						array[i][j].addAdjacentNode(array[i][j+1]);
					}
//					array[i][j].addAdjacentNode(array[i+1][j]);
//					array[i][j].addAdjacentNode(array[i][j+1]);
					
				} catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
		}
		
	}
	
}