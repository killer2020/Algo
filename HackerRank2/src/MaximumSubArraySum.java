import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MaximumSubArraySum
{

	private static class Node implements Comparable<Node>
	{
		
		long data;
		Node left=null;
		Node right=null;
		Node parent=null;
		
		public Node(long data)
		{
			this.data=data;
		}

		

		@Override
		public int compareTo(Node o) {
			if(o.data==this.data)
				return 0;
			return o.data>this.data?-1:1;
		}
		
		
	}
	
	
	

	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		
		int queries=scanner.nextInt();
		
		for(int i=0;i<queries;i++)
		{
			
			int size=scanner.nextInt();
			long mod=scanner.nextLong();
			
			long max=0;
			
			
			
		    long[] arr=new long[size];
			
		    Node[] prefixSum=new Node[size];
		    
		    
			for(int j=0;j<size;j++)
			{
				
			   arr[j]=scanner.nextLong()%mod;	
				
			}
			
			prefixSum[0]=new Node(arr[0]);
			
			for(int j=1;j<size;j++)
			{
				prefixSum[j]=new Node(arr[j]+prefixSum[j-1].data);
			}
			for(int j=0;j<size;j++)
			{
				prefixSum[j].data=prefixSum[j].data%mod;
			}
			
			
			
			ArrayList<Node> sortedData=new ArrayList<Node>(Arrays.asList(prefixSum)); 
			
			for(int j=0;j<size;j++)
			{
				System.out.println(sortedData.get(j).data);
			}
			
			Collections.sort(sortedData);
			
			
			for(int j=0;j<size;j++)
			{
				System.out.println(sortedData.get(j).data);
				
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
	   if(!rootNode.equals(node))
	   {
		   if(node.data<rootNode.data)
			   removeNode(node,rootNode.left);
		   else
			  removeNode(node,rootNode.right); 
		   
	   }
	   
	   
	   if(hasNoChildNode(node))
	   {
		   if(isNodeLeftChild(node, rootNode))
		      rootNode.left=null;
		   else
			   if(isNodeRightChild(node, rootNode))
				   rootNode.right=null;
		
		   return;
	   }

	   
	   if(hasOneChild(node))
	   {
		   adjustSingleChild(node,rootNode);
		   return;
	   }
	   
	   
	   if(hasBothChild(node))
	   {
		   
		   
		   if(node.left.right==null)
		   {
			   
			   if(isNodeLeftChild(node, rootNode))
			   {
				   
			   }
			   
		   }
		   
		   
	   }
	   
	   
	   
   }

	
	
	private static boolean hasBothChild(Node node) {
	
		return (node.left!=null && node.right!=null);
}


	private static void adjustSingleChild(Node node, Node rootNode) 
	{
	
		if(node.left!=null)
		{
			
			if(isNodeLeftChild(node,rootNode))
			{
				rootNode.left=node.left;
				node.left.parent=rootNode;
			}
			else
			if(isNodeRightChild(node, rootNode))
			{
				rootNode.right=node.left;
				node.left.parent=rootNode;
			}
			
		}
		else
		if(node.right!=null)
		{
			
			if(isNodeLeftChild(node, rootNode))
			{
				rootNode.left=node.right;
				node.right.parent=rootNode;
			}
			else
			if(isNodeRightChild(node, rootNode))
			{
				rootNode.right=node.right;
				node.right.parent=rootNode;
				
			}
			
		}
	
    }


	private static boolean isNodeLeftChild(Node node, Node rootNode) {
		
		if(rootNode.left.equals(node))
			return true;
		
		return false;
		
	}

	
    private static boolean isNodeRightChild(Node node, Node rootNode) {
    		
		if(rootNode.right.equals(node))
			return true;
		
		return false;
		
	}

	private static boolean hasOneChild(Node node) 
	{
              
		if((node.left!=null && node.right==null) || (node.right!=null && node.left==null))
			return true;
		
		
		return false;
		
    }


	private static boolean hasNoChildNode(Node node) 
	{
	 return (node.left==null && node.right==null);
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
