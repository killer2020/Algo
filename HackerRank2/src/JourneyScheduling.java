import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	private static Queue<Integer>[] farthestNeighbours;
	private static ArrayList<Integer>[] edge_1;
	
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
		long numOfTests=scanner.nextLong();
		
		nodes= new Node[numOfNodes+1];
		matrix=new int[numOfNodes+1][numOfNodes+1];
		
		farthestNeighbours=new LinkedList[numOfNodes+1];
		edge_1=new ArrayList[numOfNodes+1];
		boolean[] freeze=new boolean[numOfNodes+1];
		
		for(int i=0;i<=numOfNodes;i++)
		{
			nodes[i]=new Node();
			farthestNeighbours[i]=new LinkedList<Integer>();
			edge_1[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<numOfNodes-1;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			
			addEdge(a,b);
			
			matrix[a][b]=1;
			matrix[b][a]=1;
			farthestNeighbours[a].add(b);
			farthestNeighbours[b].add(a);
			
			edge_1[a].add(b);
			edge_1[b].add(a);
		}
		
		boolean changed = true;
		int start=0;
		while(changed==true)
		{
			
		 changed =false;
		 start++;
		 
		 for(int i=1;i<=numOfNodes;i++)
		 {
			boolean localChange=false;
			 
			 if(freeze[i]==true)
				 continue;
			 
			 Queue<Integer> temp=new LinkedList<Integer>();
			 
			for(int edge:farthestNeighbours[i])
			{
				
					for(int edge2:edge_1[edge])
					{
						
							if(matrix[i][edge2]==0 && i!=edge2)
							{matrix[i][edge2]=start+1;
							 changed=true;
							 temp.add(edge2);
							 localChange=true;
							} 
						
					}
				
			
		}
			
			if(localChange)		
				farthestNeighbours[i]=temp;
				else
				freeze[i]=true;	
			
			
			
		}
		
		
		
	

	}
		
	/*	for(int i=1;i<farthestNeighbours.length;i++)
		{
			
			for(int a:farthestNeighbours[i])
			{
				System.out.println(a);
			}
			System.out.println("--");
		}
	*/
		
		
	for(long i=0;i<numOfTests;i++)
	{
		
		boolean[] visited=new boolean[numOfNodes+1];
		int startNode=scanner.nextInt();
		long jumps=scanner.nextLong();
		long ans=0;
		for(long j=0;j<jumps;j++)
		{
			int nextNode=farthestNeighbours[startNode].poll();
			
			if(visited[nextNode]==true)
			{
				long newJump=jumps/j;
				j=j*newJump;
				ans=ans*newJump;
				visited[nextNode]=false;
			}
			
			ans=ans+matrix[startNode][nextNode];
			farthestNeighbours[startNode].add(nextNode);
			startNode=nextNode;
			visited[nextNode]=true;
		}
		
		System.out.println(ans);
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
