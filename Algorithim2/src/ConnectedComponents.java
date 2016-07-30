import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents
{

	private static int numberOfComponents(ArrayList<Integer>[] adj)
	{
		int connectedComponents = 0;
		boolean[] visited = new boolean[adj.length];

		for (int vertex = 0; vertex < adj.length; vertex++)
		{
			if (visited[vertex] == false)
			{
				connectedComponents++;
				explore(vertex, adj, visited);
			}
		}

		return connectedComponents;
	}

	static void explore(int vertex, ArrayList<Integer>[] adj, boolean[] visited)
	{
		visited[vertex] = true;
		for (int neighbour : adj[vertex])
		{
			if (visited[neighbour] == false)
				explore(neighbour, adj, visited);
		}

	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++)
		{
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++)
		{
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			adj[x - 1].add(y - 1);
			adj[y - 1].add(x - 1);
		}
		System.out.println(numberOfComponents(adj));
	}
}
