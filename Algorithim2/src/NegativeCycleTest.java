import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycleTest {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        
    	int[] distance=new int[adj.length];
    	
    	for(int i=0;i<distance.length;i++)
    	{
    		distance[i]=1000001;
    	}
    	
    	int source=0;
    	for(int k=0;k<adj.length;k++)
    	{
    		if(adj[k].size()>0)
    		{	source=k;
    		    break;
    		}
    		return 0;
    	}
    	
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
        int n = 1000;
        int m = 999;
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = i+1;
            y = i+2;
            w = 1000;
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}

