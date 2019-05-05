import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList; 
  
class MaxFlow {
	private static int graph[][];
    private static int V;
	private static int s;
	
	public static int setVer(int Ver){
		V = Ver;
		return V;
	}	
	
    boolean bfs(int rGraph[][], int s, int t, int parent[]) 
    {
		//Tao 1 mang moi va danh dau tat cac cac dinh la chua duoc duyet
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i) {visited[i]=false;}
		
		//Tao 1 hang doi, duyet do thi va danh dau dinh nguon khi da duoc duyet qua
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
        while (queue.size()!=0)
        {
            int u = queue.poll();
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
		//Neu da duyet den dich do thi thi tra ve tru, chua thi false
        return (visited[t] == true); 
    }
	
	//Phuong thuc nay se tra ve maximum cut tu dinh toi nguon trong do thi da cho
    int fordFulkerson(int graph[][], int s, int t) 
    {
        int rGraph[][] = new int[V][V]; 
        for (int i = 0; i < V; i++){
			for (int j = 0; j < V; j++){
				rGraph[i][j] = graph[i][j];
			}
		}
        int parent[] = new int[V]; 
        int max_flow = 0;
        while (bfs(rGraph, s, t, parent)) 
        {
            int path_flow = Integer.MAX_VALUE; 
            for (int j=t; j!=s; j=parent[j]) 
            { 
                int i = parent[j]; 
                path_flow = Math.min(path_flow, rGraph[i][j]); 
            }
            for (int j=t; j!=s; j=parent[j]) 
            { 
                int i = parent[j]; 
                rGraph[i][j] -= path_flow; 
                rGraph[j][i] += path_flow; 
            }
            max_flow += path_flow; 
        }
        return max_flow; 
    }
	public static int[][] readgraph(){
		try{
            FileReader reader = new FileReader("graph.txt");
			BufferedReader buffreader = new BufferedReader(reader);
			graph = new int[V][V];
			for ( int i = 0 ; i<V; i++){
				String line = buffreader.readLine();
				String[] ee = line.split(" "); 
				for ( int j = 0; j < V; j++)
					graph[i][j] = Integer.parseInt(ee[j]);
			}
        buffreader.close();
        }
		catch (Exception e){
            System.out.println(e);
		}
		return graph;
	}
}