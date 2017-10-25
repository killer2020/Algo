import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JourneyScheduling
{

	
	private static class Node
	{
		
		List<Integer> neighbours=new ArrayList<Integer>();
		
		public void addNeighbour(int neighbour)
		{
			neighbours.add(neighbour);
		}
		
	}
	
	private static Node[] nodes;
	private static ArrayList<Integer>[] farthestNeighbours;
	
	private static int[][] matrix;
	
	private static void addEdge(int a,int b)
	{
		nodes[a].addNeighbour(b);
		nodes[b].addNeighbour(a);
	}
	
	public static void main(String[] args) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		int numOfNodes=scanner.nextInt();
		int numOfTests=scanner.nextInt();
		
		nodes= new Node[numOfNodes+1];
		matrix=new int[numOfNodes+1][numOfNodes+1];
		
		for(int i=0;i<=numOfNodes;i++)
		{
			nodes[i]=new Node();
		}
		
		for(int i=0;i<numOfNodes-1;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			
			addEdge(a,b);
			
			matrix[a][b]=1;
			matrix[b][a]=1;
		}
		
		boolean changed = true;
		int start=0;
		while(changed==true)
		{
			
		 changed =false;
		 start++;
		 
		 for(int i=1;i<=numOfNodes;i++)
		 {
			
			for(int j=1;j<=numOfNodes;j++)
			{
				
				if(matrix[i][j]==start)
				{
					for(int k=1;k<=numOfNodes;k++)
					{
						if(matrix[j][k]==1 && k!=i)
						{  
							if(matrix[i][k]==0)
							{matrix[i][k]=start+1;
							 changed=true;
							} 
						}
					}
				}
				
			}
			
		}
		
		}
		
		for(int i=1;i<=numOfNodes;i++)
		{
			
			for(int j=1;j<=numOfNodes;j++)
			{
				System.out.println(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	

	}
	
	 static class FastScanner
		{
			private BufferedReader reader;
			private StringTokenizer tokenizer;

			public FastScanner()
			{
				reader = new BufferedReader(new InputStreamReader(System.in));
				tokenizer = null;
			}

			public String next() throws IOException
			{
				while (tokenizer == null || !tokenizer.hasMoreTokens())
				{
					tokenizer = new StringTokenizer(reader.readLine());
				}
				return tokenizer.nextToken();
			}

			public int nextInt() throws IOException
			{
				return Integer.parseInt(next());
			}

			public long nextLong() throws IOException
			{
				return Long.parseLong(next());
			}
		}
}
