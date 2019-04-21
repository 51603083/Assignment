public class Test{
public static void main (String[] args) throws java.lang.Exception 
    {
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0}, 
                                     {0, 0, 10, 12, 0, 0}, 
                                     {0, 4, 0, 0, 14, 0}, 
                                     {0, 0, 9, 0, 0, 20}, 
                                     {0, 0, 0, 7, 0, 4}, 
                                     {0, 0, 0, 0, 0, 0} 
                                   }; 
        MaxFlow m = new MaxFlow(); 
		MinFlow n = new MinFlow();       
		System.out.println("The maximum flow is " + m.fordFulkerson(graph, 0, 5));
		System.out.println("The minimum cut is ");	
		n.minCut(graph, 0, 5); 
    } 
} 