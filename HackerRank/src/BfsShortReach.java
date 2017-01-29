import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsShortReach
{
	
	static ArrayList<ArrayList<Integer>> neighbours;
	static boolean[] visited;
	static int[] distance;
	static int[] parent;
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner=new FastScanner();
		
		int queries=scanner.nextInt();
		
		
		
		for(int i=0;i<queries;i++)
		{
			
			int numOfNodes=scanner.nextInt();
			int numOfEdges=scanner.nextInt();
			
			visited=new boolean[numOfNodes+1];
			neighbours=new ArrayList<ArrayList<Integer>>();
			distance=new int[numOfNodes+1];
			parent=new int[numOfNodes+1];
			
			for(int j=0;j<=numOfNodes;j++)
			{
				neighbours.add(new ArrayList<Integer>());
				distance[j]=0;
			}
			
			for(int j=0;j<numOfEdges;j++)
			{
				int a=scanner.nextInt();
				int b=scanner.nextInt();
				
				neighbours.get(a).add(b);
				neighbours.get(b).add(a);
			}
			
			int start=scanner.nextInt();
			
			bfs(start);
			
			String result="";
			for(int j=1;j<=numOfNodes;j++)
			{
				if(j==start)
					continue;
				if(distance[j]==0)
					result=result+"-1 ";
				else
					result=result+distance[j]+" ";
				
			}
		
			
			System.out.println(result);
		}
		
		
		
	}

	
	
	
	private static void bfs(int start)
	{
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		queue.add(start);
		visited[start]=true;
		
		while(!queue.isEmpty())
		{
			
			int current=queue.poll();
			
			for(int neighbour:neighbours.get(current))
			{
				if(visited[neighbour]==false)
				{
					visited[neighbour]=true;
					distance[neighbour]=distance[current]+6;
					queue.add(neighbour);
				}
				
			}
			
		}
		
	}






	static class FastScanner {
	    private BufferedReader reader;
	    private StringTokenizer tokenizer;

	    public FastScanner() {
	        reader = new BufferedReader(new InputStreamReader(System.in));
	        tokenizer = null;
	    }

	    public String next() throws IOException {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            tokenizer = new StringTokenizer(reader.readLine());
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	}
}
