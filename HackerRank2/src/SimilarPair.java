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
	
	
	public static void main(String[] args) throws Exception
	{

		
		FastScanner scanner=new FastScanner();
		
		int n=scanner.nextInt();
		
		int k=scanner.nextInt();
		
		
		int[] arr=new int[n+1];
		
		Node[] nodes=new Node[n];
		
		for(int i=0;i<n;i++)
		{
			nodes[i]=new Node();
		}
		
		
		for(int i=0;i<n-1;i++)
		{
			int parent=scanner.nextInt()-1;
			int child=scanner.nextInt()-1;
			
			nodes[parent].addChild(child);
			nodes[child].addParent(parent);
			
			nodes[child].isRoot=false;
		}
		
		int rootNode=0;
		
		for(int i=0;i<n;i++)
		{
			if(nodes[i].isRoot)
				rootNode=i;
				
		}
		
		
		
		System.out.println(rootNode);
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
