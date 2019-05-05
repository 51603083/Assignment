import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class ShortestPath 
{ 
	private static int graph[][] = null;
	//So dinh cua graph
    private static int V = 7; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        //Khoi tao gia tri be nhat 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
	
	public static int setVer(int Ver){
		V = Ver;
		return V;
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
  
    //Ham in kq
    void printSolution(int dist[], int n) 
    { 
        System.out.println("Dinh     Khoang cach toi source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+"        "+dist[i]); 
    } 
  
    //Ham tim duong di ngan nhat theo thuat toan Dijkstra 
    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V]; //Mang chua output
  
        //sptSet[i] = true neu dinh i da duoc duyet va chua output
        Boolean sptSet[] = new Boolean[V]; 
  
        //Khoi tao moi khoang cach voi gia tri vo cuc va sptSet[i] = false
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        //Khoang cach tu source toi chinh no luon = 0 
        dist[src] = 0; 
  
        //Tim khoang cach ngan nhat
        for (int count = 0; count < V-1; count++) 
        { 
            //Chon dinh co khoang cach ngan nhat toi source trong danh sach
            //cac dinh chua duyet. u luon la source trong lan lap dau tien.
            int u = minDistance(dist, sptSet); 
  
            //Danh dau dinh dang duyet
            sptSet[u] = true; 
  
            //Update khoang cach moi cho dinh dang duyet
            for (int v = 0; v < V; v++) 
  
                //Update dist[v] chi khi sptSet[] = false, co mot canh 
                //tu u den v, va khoang cach tu source toi v qua u 
                //nho hon khoang cach dist[v] hien tai 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        printSolution(dist, V); 
    } 
  
} 
