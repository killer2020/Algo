import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;




public class SumTree
{

	static int[] arr;
	 

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
		arr=new int[]{-1737, -1427, -493, -60, -28, 336, 887, 916, 1422, 1927};
		
		Node root=createSumTree(0,arr.length-1);
		
		System.out.println(root.sum);
		
		System.out.println(getSum(root,1,4));
		

		
		
	}
		
		
}