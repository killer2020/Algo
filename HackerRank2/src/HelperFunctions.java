import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelperFunctions {
	
	private static Node treeRoot=null;
	
	private static Node maxDataNode=null;
	
	private static class Node implements Comparable<Node>
	{
		
		long data;
		Node left=null;
		Node right=null;
		Node parent=null;
		boolean isRoot=false;
		
		
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



		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + (left!=null?left:"null") + ", right=" + (right!=null?right:"null") + ", isRoot="
					+ isRoot + "]";
		}
		
		
	}
	
	private static void addNode(Node node,Node rootNode)
	{
		if(treeRoot==null)
		{
			treeRoot=node;
			node.isRoot=true;
			maxDataNode=node;
			return;
		}
		
		
		if(node.data<=rootNode.data)
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
				return;
			}
			
		}
		else
		{
			if(rootNode.right==null)
			{
				rootNode.right=node;
				node.parent=rootNode;
				if(rootNode==maxDataNode)
				{
					maxDataNode=node;
				}
				return;
			}
			else
			{
				addNode(node,rootNode.right);
				return;
			}
			
		}
		
		
		
	}
	
	
	private static void removeNode(Node node)
	{
		if(hasOneChild(node))
		{
			removeOneChildNode(node);
			return;
		}
		
		if(isLeaf(node))
		{
			removeLeaf(node);
			return;
		}
		
	}
	
	
	private static void removeLeaf(Node node) {
		if(node.isRoot)
		{	treeRoot=null;
		    return;
		}
		
		if(isNodeRightChild(node))
		{
			node.parent.right=null;
		}
		else
		{
			node.parent.left=null;
		}
		
	}


	private static boolean isLeaf(Node node) {
		
		if(node.right==null && node.left==null)
			return true;
		
		return false;
	}


	private static boolean hasOneChild(Node node) {
		// TODO Auto-generated method stub
		if((node.left!=null && node.right==null) || (node.right!=null && node.left==null) )
			return true;
		
		return false;
	}


	private static void removeOneChildNode(Node node) {
		
		if(node.isRoot)
	   	{
		 if(node.left!=null && node.right==null)
		    {
		   	
		   		node.left.parent=null;
		   		node.left.isRoot=true;
		   		treeRoot=node.left;
		   		return;
		   	}
		 else
		 if(node.right!=null && node.left==null)
		 {
			 node.right.parent=null;
			 node.right.isRoot=true;
			 treeRoot=node.right;
			 return;
		 }
		 
		}
	else 
	{		
		if(node.left!=null && node.right==null)
	    {
	   	    if(isNodeRightChild(node))
	   	    {
	   	    	node.left.parent=node.parent;
	   	    	node.parent.right=node.left;
	   	    	return;
	   	    	
	   	    }
	   	    else
	   	    {
	   	    	node.left.parent=node.parent;
	   	    	node.parent.left=node.left;
	   	    	return;
	   	    }
	   		
	   	}
	    else
	    if(node.right!=null && node.left==null)
	    {
		
	    	 if(isNodeRightChild(node))
		   	    {
		   	    	node.right.parent=node.parent;
		   	    	node.parent.right=node.right;
		   	    	
		   	    }
		   	    else
		   	    {
		   	    	node.right.parent=node.parent;
		   	    	node.parent.left=node.right;
		   	    }
	    }
	}	
		
	}


	private static long getRequiredDatafromTree(long data,Node rootNode)
	{
		
		if(rootNode.data==data)
			return data;
		
		if(rootNode.data>data)
		{
			if(rootNode.left==null)
				return getNextLess(rootNode);
			else
				return getRequiredDatafromTree(data, rootNode.left);
		}
		
		if(rootNode.data<data)
		{
			if(rootNode.right==null)
				return rootNode.data;
			else
				return getRequiredDatafromTree(data, rootNode.right);
			
		}
		
		return 0;
	}
	
	
	
	
	
	



	private static long getNextLess(Node rootNode) {
		
		Node parent=rootNode.parent;

		if(rootNode==treeRoot)
		   return maxDataNode.data;
		
		if(isNodeRightChild(rootNode))
		{
			return rootNode.parent.data;
		}
		
		else
		{
			return getNextLess(parent);
		}
	}


	private static boolean isNodeRightChild(Node node) {
		
		
	    if(node.parent.right!=null)
		if(node.parent.right.equals(node))
			return true;
		return false;
	}


	public static void main(String args[])
	{
		
		ArrayList<Long> arr;
		
		while(true)
		{
			int size=(int) (Math.random()*10)+1;
			arr=new ArrayList<Long>();
			treeRoot=null;
			for(int i=0;i<size;i++)
			{
				long next=(long) (Math.random()*10)+1;
				addNode(new Node(next), treeRoot);
				arr.add(next);
			}
			
			long find=(long) (Math.random()*10)+1;
			
			//System.out.println(arr);
			long fromTree=getRequiredDatafromTree(find, treeRoot);
		    long fromArray=getRequiredDatafromArray(find,arr);
			
		    System.out.println(arr);
		    System.out.println(find);
			System.out.println("Tree:"+fromTree);
			System.out.println("Array:"+fromArray);
			System.out.println();
			if(fromArray!=fromTree)
				return;
		}
		
		
	}


	private static long getRequiredDatafromArray(long find, ArrayList<Long> arr) {
		
		Collections.sort(arr);
		
		if(arr.get(0)>find)
			return arr.get(arr.size()-1);
		
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i)==find)
				return find;
			if(arr.get(i)>find)
				return arr.get(i-1);
		}
		
		return arr.get(arr.size()-1);
	}
	
}
