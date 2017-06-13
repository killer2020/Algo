import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AbsoluteElementSums
{

	static Integer[] arr;
	 
	
	static class Node
	{
		
		int l1;
		int l2;
		int b1;
		int b2;
		long sum;
		Node left=null;
		Node right=null;
		boolean isLeaf=false;
		
		
		public Node(int l1, int l2, int b1, int b2, long sum,boolean isLeaf) {
			this.l1 = l1;
			this.l2 = l2;
			this.b1 = b1;
			this.b2 = b2;
			this.sum = sum;
			this.isLeaf=isLeaf;
		}
		
		public Node()
		{
			
		}
		
		
	}
	
	
	public static Node createSumTree(int start,int end)
	{
		
		if(start==end)
			return new Node(start,start,start,start,arr[start],true);
		
		int mid=(start+end)/2;
		
		Node left=createSumTree(start,mid);
		Node right=createSumTree(mid+1,end);
		
		return mergeNodes(left,right);
		
	}
	
	
	private static Node mergeNodes(Node left, Node right) {
		
		Node node=new Node();
		
		node.l1=left.l1;
		node.l2=left.b2;
		node.b1=right.l1;
		node.b2=right.b2;
		
		node.left=left;
		node.right=right;
		
		node.sum=left.sum+right.sum;
		
		return node;
	}


	private static long getSum(Node root,int start,int end)
	{
		if(root.isLeaf || (root.l1==start && root.b2==end))
			return root.sum;
		
		
		if(start<=root.l2 && end<=root.l2)
			return getSum(root.left,start,end);
		
		if(start>=root.b1 && end>=root.b1)
			return getSum(root.right,start,end);
		
		
		long left=getSum(root.left,start,root.l2);
		long right=getSum(root.right,root.b1,end);
		
		return left+right;
		
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		long initialSum=0;
		
		int count=scanner.nextInt();
		
		List<Integer> elements=new ArrayList<Integer>();
		
		for(int i=0;i<count;i++)
		{
			int next=scanner.nextInt();
			elements.add(next);
			
			initialSum=initialSum+Math.abs(next);
		}
		
        Collections.sort(elements);
        
		
         arr= elements.toArray(new Integer[elements.size()]);
        
         Node root=createSumTree(0,arr.length-1);
        
        int divider=getDivider(0);
		
		int queries=scanner.nextInt();
		
		int add=0;
		
		for(int i=0;i<queries;i++)
		{
			long sum=initialSum;
			int next=scanner.nextInt();
			add=add+next;
		    
			if(add<0)
			{
				int index=getDivider(-add);
				
				if(index==arr.length)
					index--;
				if(divider==arr.length)
				    divider--;
				
				long left=divider*Math.abs(add);
				sum=sum+left;
				
				int start=divider+1;
				int end=index-1;
				
				if(start<=end)
				{
					long treeSum=getSum(root, start, end);
					sum=sum-treeSum;
					sum=sum+Math.abs(treeSum+(add*(end-start+1)));
				}
				
				
					sum=sum-Math.abs(arr[divider]);
					long addition=Math.abs(arr[divider]+add);
					sum=sum+addition;
					
					if(index!=divider)
					{sum=sum-Math.abs(arr[index]);
					addition=Math.abs(arr[index]+add);
					sum=sum+addition;
					}
				
				
				long right=(arr.length-index-1)*Math.abs(add);
				
				sum=sum-right;
				
			}
			else
			if(add>0)
			{
			 int index=getDivider(-add);
			 
			 if(index==arr.length)
					index--;
				if(divider==arr.length)
				    divider--;
			 
			 
			 long left=index*Math.abs(add);
			 sum=sum-left;
				
			 int start=index+1;
			 int end=divider-1;
			 
			 if(start<=end)
			 {
				 long treeSum=getSum(root, start, end);
				 sum=sum-Math.abs(treeSum);
				 sum=sum+(treeSum+(add*(end-start+1)));
			 }
			 
			
                
					sum=sum-Math.abs(arr[divider]);
					long addition=Math.abs(arr[divider]+add);
					sum=sum+addition;
					
					if(index!=divider)
					{sum=sum-Math.abs(arr[index]);
					addition=Math.abs(arr[index]+add);
					sum=sum+addition;
					}
					
			 
			 
			 long right=(arr.length-divider-1)*Math.abs(add);
			 sum=sum+right;
			}
			
				
			System.out.println(sum);
		}
		
		
		
	}
	
	



	private static int getDivider(int element)
	{
		
		int i=binarySearch(element,0,arr.length-1);
		return i;
	}





	private static int binarySearch(int element,int start,int end)
	{
		
		
		if(start==end || start>end)
		{
			if(arr[start]==element)
				return start;
			if(arr[start]>element)
				return start;
			if(arr[start]<element)
				return start+1;
			
		}
		
		
		int mid=(start+end)/2;
		
		
		if(arr[mid]==element)
			return mid;
		if(arr[mid]<element)
			return binarySearch(element,mid+1, end);
		if(arr[mid]>element)
			return binarySearch(element,start,mid-1);
		
		return 0;
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