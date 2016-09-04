import java.io.*;
import java.util.*;




public class TrieMatching implements Runnable {
	
	 class Node{
	    	char data;
	    	ArrayList<Node> childs=new ArrayList<Node>();
	    	
	    	public Node(char data)
	    	{
	    		this.data=data;
	    	}

			public Node contains(char character)
			{
				for(Node child:childs)
				{
					if(child.data==character)
						return child;
				}
				return null;
			}
	    }

	    
	    private Node buildTrie(List<String> patterns) {

	        Node root=new Node('R');
	        
	        for(String pattern:patterns)
	        {
	        	updateTree(root,pattern);
	        }

	        return root;
	    }

	    private void updateTree(Node root, String pattern)
		{
			Node currentNode=root;
			
			for(int i=0;i<pattern.length();i++)
			{
				char character=pattern.charAt(i);
				
				Node found=currentNode.contains(character);
				
				if(found!=null)
	             {
		           currentNode=found;
	             }
	             else
	             {
	            	 Node newNode=new Node(character);
	            	 currentNode.childs.add(newNode);
	            	 currentNode=newNode;
	             }
				
			}
			
			currentNode.childs.add(new Node('$'));
			
		}
	
	
	
	    
	List <Integer> solve (String text, int n, List <String> patterns) {
		List <Integer> result = new ArrayList <Integer> ();

		Node trieRootNode=buildTrie(patterns);
		
		boolean patternMatchatIndex=false;
		int textLength=text.length();
		for(int i=0;i<textLength;i++)
		{
			patternMatchatIndex=checkForPattern(text,trieRootNode,result);
			if(patternMatchatIndex==true)
				result.add(i);
			text=text.substring(1,text.length());
		}
		

		return result;
	}

	private boolean checkForPattern(String text, Node trieRootNode, List<Integer> result)
	{
		Node currentNode=trieRootNode;
		
		for(int i=0;i<text.length();i++)
		{
			if(currentNode.contains('$')!=null)
				return true;
			
			char character=text.charAt(i);
			Node found=currentNode.contains(character);
			if(found!=null)
				currentNode=found;
			else
				return false;
				
		}
		
		if(currentNode.contains('$')!=null) //checking last node,as we have added $ at all leaves
			return true;
		return false;
	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatching ()).start ();
	}
}
