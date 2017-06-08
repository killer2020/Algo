import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SubSegmentSum {

	
	static int[] arr;
	static int maxArea=0;
	
	public static void main(String[] args) throws Exception 
	{
		FastScanner scanner=new FastScanner();

		int count=scanner.nextInt();
		
		arr=new int[count];
		
		for(int i=0;i<count;i++)
		{
			 int next=scanner.nextInt();
			 arr[i]=next;
		}
		
		Node rootNode=createSegmentTree(count);
		
		System.out.println(rootNode);
		
		
		while(true)
		{
			int a1=scanner.nextInt();
			int a2=scanner.nextInt();
			System.out.println(findMinInRange(rootNode,a1,a2));
		}
		
	}



   private static int findMinInRange(Node rootNode,int start,int end)
   {
	   if(rootNode.rangeUp==start && rootNode.rangeDown==end)
		   return rootNode.min;
	   
	   if(rootNode.rangeUp>end || rootNode.rangeDown<start)
		   return 10000000;

	   if(rootNode.isleaf)
		   return rootNode.min;
	   
	   else
		   return Math.min(findMinInRange(rootNode.left, start,end),findMinInRange(rootNode.right, start, end));
	   
   }
	
	

	private static Node createSegmentTree(int count)
	{
		
		Node rootNode=merge(0,count-1);
		
		return rootNode;
	}


	private static Node merge( int start,int end)
	{
		
		if(start==end)
		{
			
			Node node=new Node();
			node.min=arr[start];
			node.minIndex=start;
			node.rangeUp=start;
			node.rangeDown=end;
			node.isleaf=true;
			
			return node;
		}
		else
		{
			
			int mid=(start+end)/2;
			Node node1=merge(start,mid);
			Node node2=merge(mid+1,end);
			
			
			return mergeTwoNodes(node1,node2);
		}
		
	}


	private static Node mergeTwoNodes(Node node1, Node node2)
	{
		Node node=new Node();
		if(node1.min<node2.min)
		{	node.min=node1.min;
		    node.minIndex=node1.minIndex;
		}
		else
		{
			node.min=node2.min;
			node.minIndex=node2.minIndex;
		}
		
		node.rangeUp=node1.rangeUp;
		node.rangeDown=node2.rangeDown;
		
		node.left=node1;
		node.right=node2;
		
		return node;
	}

	
	private static class Node
	{
		
		int min;
		int minIndex;
		int rangeUp;
		int rangeDown;
		boolean isleaf=false;
		Node left;
		Node right;
		
		@Override
		public String toString()
		{
			return "Node [min=" + min + ", minIndex=" + minIndex + ", rangeUp=" + rangeUp + ", rangeDown=" + rangeDown
					+ ", isleaf=" + isleaf + "]";
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