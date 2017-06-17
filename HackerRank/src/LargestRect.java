import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class LargestRect {

	
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
		
		
		findMaxArea(rootNode,rootNode,0,count-1);
		 
	
		System.out.println(maxArea);
		
	}

	
	
	private static void findMaxArea(Node root,Node minNode,int start,int end)
	{
		
		int area=minNode.min*(end-start+1);
		if(area>maxArea)
			maxArea=area;
		
		if(start!=end)
		{
			Node newMinLeftNode=findMinIndex(root,start,minNode.minIndex-1);
			findMaxArea(root,newMinLeftNode,start,minNode.minIndex-1);
			
			Node newMinRightNode=findMinIndex(root,minNode.minIndex+1,end);
			findMaxArea(root,newMinRightNode,minNode.minIndex+1,end);
		}
		
		
	}



	private static Node findMinIndex(Node root, int start, int i)
	{
		// TODO Auto-generated method stub
		return null;
	}



	private static Node createSegmentTree(int count)
	{
		int half=count/2;
		
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