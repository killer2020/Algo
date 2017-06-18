import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaximumSubArraySum
{

	private static class Node
	{
		
		long data;
		Node left=null;
		Node right=null;
		Node parent=null;
		
		public Node(long data)
		{
			this.data=data;
		}
		
		
	}
	
	
	static Node[] arr;
	static long[] originalData;

	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		
		int queries=scanner.nextInt();
		
		for(int i=0;i<queries;i++)
		{
			
			int size=scanner.nextInt();
			long mod=scanner.nextLong();
			
			long max=0;
			
			arr=new Node[size];
			
			ArrayList<Node> nodesList=new ArrayList<Node>();
			
			
			originalData[0]=scanner.nextLong()%mod;
			Node node=new Node(originalData[0]);
			nodesList.add(node);
			
			for(int j=0;j<size;j++)
			{
				
				originalData[j]=scanner.nextLong()%mod;
				
			}
			
			
			
			
			System.out.println(max);
		}
		
		
		
		
	}


   private static void addNode(Node node,Node rootNode)
   {
	   
	   if(node.data<rootNode.data)
	   {
		   if(rootNode.left==null)
		   {
			   rootNode.left=node;
			   node.parent=rootNode;
			   return;
		   }
		   else
		   {
			   addNode(node,rootNode.left);
		   }
		   
	   }
	   
	   else
	   {
		   if(rootNode.right==null)
		   {
			   rootNode.right=node;
			   node.parent=rootNode;
			   return;
		   }
		   else
		   {
			   addNode(node,rootNode.right);
		   }
	   }
	   
   }

   private static void removeNode(Node node,Node rootNode)
   {
	   
	   //if(node.equals(rootNode))
	   
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
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	}
}
}