import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class SimilarPair
{
	
    private static class Node
    {
    	
    	int parent;
    	List<Integer> childs=new ArrayList<Integer>();
    	
    	boolean isRoot=true;
    	
    	public void addChild(int nodeNum)
    	{
    		childs.add(nodeNum);
    	}
    	

    	public void addParent(int parent)
    	{
    		this.parent=parent;
    	}
    }
	
	
    
    private static Node[] nodes;
    
    private static int[] sum;
    
    private static long similarPairs=0;
    
	public static void main(String[] args) throws Exception
	{

		
		FastScanner scanner=new FastScanner();
		
		int n=scanner.nextInt();
		
		int k=scanner.nextInt();
		
		
		sum=new int[n+1];
		
		nodes=new Node[n+1];
		
		for(int i=0;i<n+1;i++)
		{
			nodes[i]=new Node();
		}
		
		
		for(int i=0;i<n-1;i++)
		{
			int parent=scanner.nextInt();
			int child=scanner.nextInt();
			
			nodes[parent].addChild(child);
			nodes[child].addParent(parent);
			
			nodes[child].isRoot=false;
		}
		
		int rootNode=0;
		
		for(int i=1;i<(n+1);i++)
		{
			if(nodes[i].isRoot)
				rootNode=i;
				
		}
		
		dfs(rootNode,k);
		
		
		
		System.out.println(similarPairs);
	}
	
	
	public static void dfs(int nodeNum,int k)
	{
		
		checkSimilarPair(nodeNum,k);
		
		add(nodeNum);
		
		for(int child:nodes[nodeNum].childs)
		{
			
			dfs(child,k);
			
			
		}
		subtract(nodeNum);
	}
	
	
	
	private static void checkSimilarPair(int nodeNum, int k)
	{
		int start=nodeNum-k;
		if(start<0)
			start=0;
		
		start=start-1;
		
		int end=nodeNum+k;
		if(end>sum.length-1)
			end=sum.length-1;
		
		
		
		int sum1=0;
		for(; start > 0; start -= start&-start)
	         sum1 += sum[start];
		
		
		int sum2=0;
		for(; end > 0; end -= end&-end)
        sum2 += sum[end];
		
		
		int answer=sum2-sum1;
		similarPairs=similarPairs+answer;
	}


	private static void subtract(int nodeNum)
	{
		for(;nodeNum<sum.length;nodeNum+= nodeNum&(-nodeNum))
			sum[nodeNum]+=(-1);
		
	}


	private static void add(int nodeNum)
	{
		for(;nodeNum<sum.length;nodeNum+= nodeNum&(-nodeNum))
			sum[nodeNum]+=1;
		
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
