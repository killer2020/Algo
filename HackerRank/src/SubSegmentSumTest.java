import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class SubSegmentSumTest {

	
	static int[] arr;
	static int maxArea=0;
	static int count;
	
	public static void main(String[] args) throws Exception 
	{
		FastScanner scanner=new FastScanner();

		while(true)
		{
			ArrayList<Integer> data=new ArrayList<Integer>();
			maxArea=0;
			count=(int) (Math.random()*100000)+1;
		
		arr=new int[count];
		
		for(int i=0;i<count;i++)
		{
			 int next=(int) (Math.random()*1000000)+1;
			 arr[i]=next;
			 data.add(next);
		}
		
		Node rootNode=createSegmentTree(count);
		
		//System.out.println(rootNode);
		
		
		updateMaxArea(rootNode,0,count-1);
		
		System.out.println(maxArea);
		
		int bruteResult=bruteResult(data);
		System.out.println("Result:"+maxArea+"  Brute:"+bruteResult);
		if(maxArea!=bruteResult)
			return;
		
		}
	}

private static int bruteResult(ArrayList<Integer> data) {
		
		int area=0;
		
		for(int i=0;i<data.size();i++)
		{
			int maxArea=data.get(i);
			int minElement=data.get(i);
			for(int j=i+1;j<data.size();j++)
			{
				if(data.get(j)<minElement)
				{
					minElement=data.get(j);
				}
				
				if(minElement*(j-i+1)>maxArea)
					maxArea=minElement*(j-i+1);
			}
		
			if(maxArea>area)
				area=maxArea;
		}
		
		return area;
	}

   private static void updateMaxArea(Node rootNode,int start,int end) 
    {
	   if(start==end)
	   {
		   if(arr[start]>maxArea)
			   maxArea=arr[start];
		   return;
	   }
		
	   
	   Node minNode=findMinNodeInRange(rootNode,start,end);
	   
	   if(minNode.min*(end-start+1)>maxArea)
		   maxArea=minNode.min*(end-start+1);
	   
	   if(minNode.minIndex==start)
	   {
		 updateMaxArea(rootNode,start+1,end);
		 updateMaxArea(rootNode,minNode.minIndex,minNode.minIndex);
		 return;
	   }
	   
	   if(minNode.minIndex==end)
	   {
		     updateMaxArea(rootNode,start,end-1);
			 updateMaxArea(rootNode,minNode.minIndex,minNode.minIndex);
			 return;
	   }
	   
	     updateMaxArea(rootNode,start,minNode.minIndex-1);
		 updateMaxArea(rootNode,minNode.minIndex+1,end);
		 return; 
	   
	   
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
   
   private static Node findMinNodeInRange(Node rootNode,int start,int end)
   {
	   if(rootNode.rangeUp==start && rootNode.rangeDown==end)
		   return rootNode;
	   
	   if(rootNode.rangeUp>end || rootNode.rangeDown<start)
		   return null;

	   if(rootNode.isleaf)
		   return rootNode;
	   
	   
	   return getMinNode(rootNode.left,rootNode.right,start,end);
	   
	   
   }
   
	
	

	private static Node getMinNode(Node left, Node right, int start, int end) {
	
		if(left==null)
			return findMinNodeInRange(right,start,end);
		if(right==null)
			return findMinNodeInRange(left,start,end);
		
	    Node leftMin=findMinNodeInRange(left,start,end);
	    Node rightMin=findMinNodeInRange(right,start,end);
	    
	    if(leftMin==null)
	    	return rightMin;
	    if(rightMin==null)
	    	return leftMin;
	    
	    if(leftMin.min<rightMin.min)
	    	return leftMin;
	    else
	    	return rightMin;
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