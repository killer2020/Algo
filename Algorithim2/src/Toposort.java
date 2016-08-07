import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean visited[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
       
        for(int i=0;i<adj.length;i++)
		{
			dfs(adj,i,visited,order);
			
		}
       
        return order;
    }



	private static void dfs(ArrayList<Integer>[] adj, int i, boolean[] visited,ArrayList<Integer> order) {
		if(visited[i]==true)
			return;
		visited[i]=true;
		for(Integer neighbour:adj[i])
		{   
			dfs(adj,neighbour,visited,order);
		}
		order.add(i);
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x=order.size()-1;x>=0;x--) {
            System.out.print((x + 1) + " ");
        }
    }
}

