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
		
//		add the planets s
		ArrayList<Integer> planets = new ArrayList<Integer>();
		planets.add(47);
		planets.add(45);
		planets.add(07);
		
		buildNeighbor(blackholes);
		
		Graph g = new Graph();
		
//		77 to closest
		ArrayList<Node> path = g.breadthFirstTraversal(array[7][7], getNode(planets.get(0)));
//		System.out.println(path);
		for(int i = 1; i < planets.size(); i++){
			resetArray(blackholes);
			ArrayList<Node> temp = g.breadthFirstTraversal(array[7][7], getNode(planets.get(i)));
//			System.out.println(temp.size());
			if(path.size() > temp.size()){
				path = temp;
			}
		}
		resetArray(blackholes);
		
//		System.out.println("after first clost" + path);
		
//		System.out.println(path.size());
//		System.out.println("last node" + path.get(path.size()-1));
		
		System.out.println("So we picked first" + path);
		
//		Node lastPlanet = path.get(path.size()-1);
		
		
//		System.out.println("her" + lastPlanet.toDigit());
//		System.out.println(getNode(lastPlanet).hashCode());
		
//		planets.remove((Object)lastPlanet.toDigit());
		
		
//		System.out.println("from " + lastPlanet + " to " + planets.get(0));
//		ArrayList<Node> testPath = g.breadthFirstTraversal(getNode(lastPlanet), getNode(planets.get(0)));
//		System.out.println(testPath);
		
		for(int i = 0; i < planets.size(); i++){
			resetArray(blackholes);
			Node lastPlanet = path.get(path.size()-1);
			path.remove(lastPlanet);
			System.out.println("removing " + lastPlanet.toDigit());
			planets.remove((Object)lastPlanet.toDigit());
			
			ArrayList<Node> testPath = g.breadthFirstTraversal(getNode(lastPlanet), getNode(planets.get(0)));
			System.out.println("from upre" + lastPlanet + "/" + getNode(lastPlanet) + " to " + getNode(planets.get(0)) + " " + testPath);
			
			for(int k = 1; k < planets.size(); k++){
				resetArray(blackholes);
				ArrayList<Node> temp = g.breadthFirstTraversal(getNode(lastPlanet), getNode(planets.get(k)));
				System.out.println("from " + lastPlanet + " to " + getNode(planets.get(k)) + " " + temp);
				System.out.println(temp.size());
				if(testPath.size() > temp.size()){
					testPath = temp;
				}
			}
			
			for(int c = 0; c < testPath.size(); c++){
				path.add(testPath.get(c));
			}
			
			System.out.println("path at this point" + path);
		}
		
//		
		System.out.println(path);
//		connecting to last
		resetArray(blackholes);
		Node lastPlanet = path.get(path.size()-1);
		path.remove(lastPlanet);
		ArrayList<Node> testPath = g.breadthFirstTraversal(getNode(lastPlanet), array[0][0]);
		for(int c = 0; c < testPath.size(); c++){
			path.add(testPath.get(c));
		}
		System.out.println(path);
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
	
	private static Node getNode(Node node){
		int x = node.x;
		int y = node.y;
		
		return array[x][y];
	}
	
	private static Node getNode(int xy){
		int x = xy / 10;
		int y = xy % 10;
		return array[x][y];
	}
	
	private static void buildNeighbor(ArrayList<Node> blackholes) {
//		 it builds the neighbor starting from the source node and then reaching to all of them.
//		avoids blackholes
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
					
				} catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
		}
		
	}
	
}