import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
       
    	Queue<Integer> queue=new LinkedList<Integer>();
    	boolean[] visited=new boolean[adj.length];
    	int[] distance=new int[adj.length];
    	for(int i=0;i<adj.length;i++)
    	{
    		distance[i]=-1;
    	}
    	queue.add(s);
    	visited[s]=true;
    	distance[s]=0;
    	while(!queue.isEmpty())
    	{
    		
    		int num=queue.remove();
    		for(Integer neighbour:adj[num])
    		{
    			if(visited[neighbour]==false)
    			 {queue.add(neighbour);
    			  distance[neighbour]=distance[num]+1;
    			  visited[neighbour]=true;
    			  if(neighbour==t)
    				  return distance[num]+1;
    			 }
    		}
    		
    		
    	}
    	
    	
        return -1;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

