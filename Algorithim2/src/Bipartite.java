import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
    	Queue<Integer> queue=new LinkedList<Integer>();
    	boolean[] visited=new boolean[adj.length];
    	int[] color=new int[adj.length];
    	for(int i=0;i<adj.length;i++)
    	{
    		color[i]=-1;
    	}
    	queue.add(0);
    	visited[0]=true;
    	color[0]=0;
    	while(!queue.isEmpty())
    	{
    		
    		int num=queue.remove();
    		for(Integer neighbour:adj[num])
    		{
    			if(color[num]==color[neighbour])
    				return 0;
    			
    			if(visited[neighbour]==false)
    			 {queue.add(neighbour);
    			  color[neighbour]=flipColor(color[num]);
    			  visited[neighbour]=true;
    			 }
    		}
    		
    		
    	}
    	
    	
        return 1;
    }

    static int flipColor(int color)
    {
    	if(color==0)
    			return 1;
    	else
    		if(color==1)
    			return 0;
        return color;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

