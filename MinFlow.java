import java.util.LinkedList; 
import java.util.Queue;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList; 

public class MinFlow{
	private int graph[][];
	static final int V =6 ;
	
    private static boolean bfs(int[][] rGraph, int s, int t, int[] parent){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (!q.isEmpty()){
            int v = q.poll();
            for (int i = 0; i < V; i++){
                if (rGraph[v][i] > 0 && !visited[i]){
                    q.offer(i); 
                    visited[i] = true; 
                    parent[i] = v; 
                }
            }
        }   
        return (visited[t] == true); 
    }
    private static void dfs(int[][] rGraph, int s, boolean[] visited) { 
        visited[s] = true; 
        for (int i = 0; i < V; i++) { 
                if (rGraph[s][i] > 0 && !visited[i]) { 
                    dfs(rGraph, i, visited); 
                } 
        } 
    }
    public static void minCut(int[][] graph, int s, int t) { 
        int u,v;
        int[][] rGraph = new int[V][V];  
        for (int i = 0; i < V; i++) { 
            for (int j = 0; j < V; j++) { 
                rGraph[i][j] = graph[i][j]; 
            } 
        }
        int[] parent = new int[V];     
        while (bfs(rGraph, s, t, parent)) { 
            int pathFlow = Integer.MAX_VALUE;          
            for (v = t; v != s; v = parent[v]) { 
                u = parent[v]; 
                pathFlow = Math.min(pathFlow, rGraph[u][v]); 
            }
            for (v = t; v != s; v = parent[v]) { 
                u = parent[v]; 
                rGraph[u][v] = rGraph[u][v] - pathFlow; 
                rGraph[v][u] = rGraph[v][u] + pathFlow; 
            } 
        } 
   
        boolean[] isVisited = new boolean[V];      
        dfs(rGraph, s, isVisited);   
        for (int i = 0; i < V; i++) { 
            for (int j = 0; j < V; j++) { 
                if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) { 
                    System.out.println(i + " - " + j); 
                }
            }
        }
    }
	public int[][] readGraph(){
		try{
            FileReader reader = new FileReader("graph.txt");
			BufferedReader buffreader = new BufferedReader(reader);
			this.graph = new int[this.V][this.V];
			for ( int i = 0 ; i<this.V; i++){
				String line = buffreader.readLine(); 
				String[] ee = line.split(" "); 
				for ( int j = 0; j < this.V; j++)
					this.graph[i][j] = Integer.parseInt(ee[j]);
				//return this.graph;
			}
        buffreader.close();
        }
		catch (Exception e){
            System.out.println(e);
		}
		return this.graph;
        //System.out.println("Ghi file thanh cong...");
    }
}