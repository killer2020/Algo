import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortAdvanced {

  	public static class TreeNode
	{
		int data;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		int childCountRight;
		int childCountLeft;

		public TreeNode(int data,TreeNode parent,TreeNode left,TreeNode right)
		{
			this.data=data;
			this.parent=parent;
			this.left=left;
			this.right=right;
			this.childCountRight=0;
			this.childCountLeft=0;
		} 
	}	
	  public static void main(String[] args) {
	        
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        
	        for(int i=0;i<t;i++){
	            int n = in.nextInt();
	            int[] ar = new int[n];
	            for(int j=0;j<n;j++){
	                ar[j]=in.nextInt();
	                //System.err.println(ar[j]);
	            }
	            long c = insertSort(ar);      
	            System.out.println(c);
	        }
	}
	    
	    
	    public static long insertSort(int[] ar)
	    {
	        long count = 0; 
	    	
	        TreeNode root=new TreeNode(ar[0],null,null,null);
	        
	        		
	        for(int i=1;i<ar.length;i++)
	        {
	        	int number=ar[i];
	        	int nodesToRight=insertNodeinTree(root,number);
	        	count=count+nodesToRight;
	        	root=adjustTree(root);
	        }
	        		
	        return count;
	        
	    }



		private static TreeNode adjustTree(TreeNode root)
		{
			if(root.childCountLeft-root.childCountRight>2)
			{
				TreeNode leftRight=root.left.right;
				TreeNode left=root.left;
				
				
				left.right=root;
				root.parent=left;
				
				if(leftRight!=null)
				{
					root.left=leftRight;
					leftRight.parent=root;
				}
				else
					root.left=null;
				
				root=left;
				
				root.childCountRight=root.right.childCountRight+1;
				if(leftRight!=null)
					root.right.childCountLeft=root.right.left.childCountLeft+root.right.left.childCountRight+1;
				
			}
			else
			if(root.childCountRight-root.childCountLeft>2)
			{
				
			}
			
			return root;
		}


		private static int insertNodeinTree(TreeNode root, int number) {
			
			int nodesToRight=0;
			
			TreeNode currentNode=root;
		    TreeNode parent=root;
			String leftRight="left";
		    
			while(currentNode!=null)
			{
				
				parent=currentNode;
				if(currentNode.data>number)
					{
					 nodesToRight=nodesToRight+currentNode.childCountRight+1;
					 currentNode.childCountLeft++;
					 currentNode=currentNode.left;
					 leftRight="left";
					}
				else if(currentNode.data<=number)
					{currentNode.childCountRight++;
					 currentNode=currentNode.right;
				     leftRight="right";
					}
				
			}
		
			
			TreeNode newNode=new TreeNode(number,parent,null,null);
			
			if(leftRight.equals("left"))
				parent.left=newNode;
			else if(leftRight.equals("right"))
				parent.right=newNode;

			return nodesToRight;
		}
	    
}