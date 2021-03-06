import java.util.LinkedList; 
import java.util.Queue;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList; 


class Main{	  
	private static int V;
	private static int s;
	private static int f;
    public static void main (String[] args) 
    { 	
		//input so dinh cua cay
		Scanner reader = new Scanner(System.in);
		System.out.println("Choose your desired algorithm: ");
		System.out.println("Enter 1 for Maximum Network Flow");
		System.out.println("Enter 2 for Shortest Path");
		System.out.println("Enter 3 for Minimum Spanning Tree");
		int M;
		M = reader.nextInt();
		if( M == 1){
			System.out.print("Input number of vertices :");
			V = reader.nextInt();
			System.out.print("Input source point: ");
			s = reader.nextInt();
			System.out.print("Input end point: ");
			f = reader.nextInt();
			MaxFlow m = new MaxFlow(); 
			MaxFlow.setVer(V);
			int g[][] = MaxFlow.readgraph();
			System.out.println("MaxFlow: " +  m.fordFulkerson(g, s, f));
		}
		else if( M == 2){
			System.out.print("Input number of vertices: ");
			V = reader.nextInt();
			System.out.print("Input source point: ");
			s = reader.nextInt();
			ShortestPath t = new ShortestPath();
			ShortestPath.setVer(V);
			int g[][] = ShortestPath.readgraph();			
			t.dijkstra(g,s); 
		}
		else if(M == 3){
			System.out.print("Input number of vertices: ");
			V = reader.nextInt();
			MST.setVer(V);
			MST t = new MST(); 
			int g[][] = MST.readgraph();
			t.primMST(g); 
		}
		else{
			System.out.println("Please input the correct number for your desired algorithm");

		}
		
    } 
}
