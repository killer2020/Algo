import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        
    	int[] distance=new int[adj.length];
    	
    	for(int i=0;i<distance.length;i++)
    	{
    		distance[i]=1000001;
    	}
    	
    	int source=0;
//    	for(int k=0;k<adj.length;k++)
//    	{
//    		if(adj[k].size()>0)
//    		{	source=k;
//    		    break;
//    		}
//    		return 0;
//    	}
    	
    	distance[source]=0;
    	
    	for(int j=0;j<adj.length;j++)
    	{   
    		boolean relaxed=false;
    		for(int r=0;r<adj.length;r++)
    		{ 
    		 int costNum=0;	
    		 for(int adjNode:adj[r])
    		 {
    			if(distance[r]+cost[r].get(costNum)<distance[adjNode])
    			{
    				distance[adjNode]=distance[r]+cost[r].get(costNum);
    				relaxed=true;
    			}
    			costNum++;
    		 }
    		}
    		
    		if(relaxed==false)
    			return 0;
    		
    	}
    	
    	
    	
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        
        for(int j=0;j<n;j++)
        {
        	adj[0].add(j+1);
        	cost[0].add(0);
        }
        
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x].add(y);
            cost[x].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}
