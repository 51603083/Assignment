import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class MST 
{ 
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
		System.out.println("total weight = " + total);
    } 
  
    public static void main (String[] args) 
    { 

		//input so dinh cua cay
		Scanner reader = new Scanner(System.in);
		System.out.print("hay input so dinh cua cay: ");
		V = reader.nextInt();
        MST t = new MST(); 
		//theo thu tu cac dinh( moi dinh la 1 dong ), vertex nao co ket noi voi vertex khac thi gia tri cua edge giua 2 vertex do se la so khac 0 ( tu cho ),tai vi tri cua chinh vertex thi gia tri cua edge la 0.
        int graph[][] = new int[][] {
									{0, 5, 1, 4, 0 , 0, 0}, 
                                    {5, 0, 0, 0, 0, 6, 0}, 
                                    {1, 0, 0, 3, 2, 0, 0}, 
                                    {4, 0, 3, 0, 0, 8, 0}, 
                                    {0, 0, 2, 0, 0, 7, 9},
									{0, 6, 0, 8, 7, 0, 0},
									{0, 0, 0, 0, 9, 0, 0}
									}; 
 
        t.primMST(graph); 
    } 
} 