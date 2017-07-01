import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KthParent
{
    
	
	static int[] parentNode;
    static int[] depth;
    static boolean isLeaf[];
    static int size=1000001;
    static int jumpSize=100;
    
    static int[] prevJumpParent;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		int testCases=scanner.nextInt();
		
		for(int count=0;count<testCases;count++)
		{int numberOfNodes=scanner.nextInt();
		
		
		parentNode=new int[size];
        depth=new int[size];
		isLeaf=new boolean[size];
		prevJumpParent=new int[size];
        
		for(int i=0;i<size;i++)
		{
			parentNode[i]=-1;
		}
		
		for(int i=0;i<numberOfNodes;i++)
		{
			
			int child=scanner.nextInt();
			int parent=scanner.nextInt();
			
			parentNode[child]=parent;
			isLeaf[child]=true;
			isLeaf[parent]=false;
		    	
			if(parent==0)
			{	depth[child]=1;
			    prevJumpParent[child]=child;
			}
		}

		
		createDepth();
		
		int noOfQueries=scanner.nextInt();
		
		for(int i=0;i<noOfQueries;i++)
		{int choice=scanner.nextInt();
		
		
		switch(choice)
		{
		case 0:
			int parent=scanner.nextInt();
			int child=scanner.nextInt();
			addLeafNode(child,parent);
			break;
		case 1:
			int removeNode=scanner.nextInt();
			removeLeafNode(removeNode);
			break;
		case 2:
			int node=scanner.nextInt();
			int kth=scanner.nextInt();
			int answer=output(node,kth);
			System.out.println(answer);
			break;
			
		}
		
		}
		}
		
	}
	
	
	
	private static void createDepth()
	{
		for(int i=0;i<size;i++)
		{
			if(isLeaf[i])
				depth[i]=calcNodeDepth(i);
			
		}
		
	}



	private static int calcNodeDepth(int i)
	{
		int parent=parentNode[i];
		
		if(parent==0)
			return 1;
		if(depth[parent]!=0)
		{
			depth[i]=depth[parent]+1;
			if(depth[i]%jumpSize==0)
			{
				prevJumpParent[i]=i;
			}
			else
			{
				prevJumpParent[i]=prevJumpParent[parentNode[i]];
			}
			return depth[i];
		}
		else
		{
			int depthCalc= calcNodeDepth(parent)+1;
			depth[i]=depthCalc;
			if(depth[i]%jumpSize==0)
			{
				prevJumpParent[i]=i;
			}
			else
			{
				prevJumpParent[i]=prevJumpParent[parentNode[i]];
			}
			return depthCalc;
		}
		
	}



	private static void addLeafNode(int child, int parent)
	{
		parentNode[child]=parent;
		depth[child]=depth[parent]+1;
		if(depth[child]%jumpSize==0)
		{
			prevJumpParent[child]=child;
		}
		else
		{
			prevJumpParent[child]=prevJumpParent[parent];
		}
		
	}
	
	private static void removeLeafNode(int removeNode)
	{
		parentNode[removeNode]=-1;
		
	}



	private static int output(int node, int k)
	{
		if(parentNode[node]==-1)
			return 0;
		
		int distFromJump=depth[node]%jumpSize;
		if(distFromJump<k && depth[node]>jumpSize)
		{
			if(distFromJump==0)
			{
				if(k>jumpSize)
					return output(parentNode[node],k-1);
			}
			else
			{	
			return output(prevJumpParent[node],k-distFromJump);
			}
		}
		
		int parent=node;
		for(int i=0;i<k;i++)
		{
			parent=parentNode[parent];
			if(parent==0)
				return 0;
		}
		

		return parent;
	}



	



	private static class FastScanner
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
