import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
	static int order=0;
    private static int acyclic(ArrayList<Integer>[] adj,ArrayList<Integer>[] reverseAdj) {
        
    int[] postOrder=new int[adj.length];
    boolean[] visited=new boolean[adj.length];
    
    //to get sink node
    fillPostOrder(0,reverseAdj,postOrder,visited);
    
    for(int i=postOrder.length-1;i>=0;i--)
    {
    	if(adj[postOrder[i]].size()>0)
    	{
    		return 1;
    	}
    	
    	//Remove sink node from graph
    	for(Integer neighbour:reverseAdj[postOrder[i]])
    	{
    		adj[neighbour].remove((Object)postOrder[i]);
    	}
    }
    
    return 0;	
    }

    
    
  


	private static void fillPostOrder(int root,ArrayList<Integer>[] adj, int[] postOrder, boolean[] visited) {
		 
		for(int i=0;i<adj.length;i++)
		{
			bfs(adj,i,visited,postOrder);
			
		}
    	
	}




	private static void bfs(ArrayList<Integer>[] adj, int i, boolean[] visited,int[] postOrder) {
		if(visited[i]==true)
			return;
		visited[i]=true;
		for(Integer neighbour:adj[i])
		{   
			bfs(adj,neighbour,visited,postOrder);
		}
		postOrder[order]=i;
		order=order+1;
	}






	




	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] reverseAdj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            reverseAdj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            reverseAdj[y-1].add(x-1);
        }
        System.out.println(acyclic(adj,reverseAdj));
    }
}

