import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class MST 
{ 
	private static int graph[][] = null;
	//so dinh cua cay 
    private static int V;
	
	
	//so sanh gia tri min
    int minKey(int key[], Boolean Mst[]) 
    { 
 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (Mst[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    }
	
	public static int setVer(int Ver){
		V = Ver;
		return V;
	}
  
    void primMST(int graph[][]) 
    { 
        int parent[] = new int[V]; 
        int key[] = new int [V]; 
		
		//the hien cac dinh chua duoc xet
        Boolean Mst[] = new Boolean[V]; 
  
		//dat min value cua cac key la inf
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            Mst[i] = false; 
        } 
		
		//dat value cua dinh dau tien = 0 de thuat toan chay tu day
        key[0] = 0;     
        parent[0] = -1;
		//2 bien total va temp de tinh tong weight cua tree.
		int total = 0;
		int temp = 0;
		
  
		// < so dinh cua graph 
        for (int count = 0; count < V-1; count++) 
        { 

            int u = minKey(key, Mst); 
			
			//dinh da duoc xet
            Mst[u] = true; 
  
            for (int v = 0; v < V; v++) 

                if (graph[u][v]!=0 && Mst[v] == false &&  graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v];
					temp = key[v];
					total = total + temp;

                } 
        } 
		//print cac dinh co ket noi voi nhau va total weight cua tree.
        System.out.println("Connected Vertices:"); 
        for (int i = 1; i < V; i++) 
		{
            System.out.println(parent[i]+" - "+i);
			
		}
		System.out.println("Total weight = " + total);
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