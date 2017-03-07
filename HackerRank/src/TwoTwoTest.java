
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class TwoTwoTest
{
	
	static TreeNode rootNode;
	
	static class TreeNode
	{
		String data;
		ArrayList<TreeNode> childs=new ArrayList<TreeNode>();
		TreeNode failedLink;
		
		TreeNode parent;
		
		int noOfEnds=0;
		
		public TreeNode(String data)
		{
			this.data=data;
		}
		
		public TreeNode hasChild(String ch)
		{
			for(TreeNode child:childs)
			{
				if(child.data.equals(ch))
					return child;
			}
			return null;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		createPowersOfTwoTrie();
		
		FastScanner scanner=new FastScanner();
		int numberOfStrings=100;
		
		
		
		while(true)
		{
			String currentString="";
			
			for(int i=0;i<5;i++)
			{	
			long randm=(long)(Math.random()*1000);
			BigInteger str1 = BigInteger.valueOf(randm);
			currentString=currentString+String.valueOf(randm);
			}
			
			
			
			System.out.println("Number:"+currentString);
			int currentStringResult=checkCountinString(currentString);
			
			
			int bruteResult=checkBrute(currentString);
			System.out.println("Algo:"+currentStringResult);
			System.out.println("Brute:"+bruteResult);
			if(currentStringResult!=bruteResult)
				{
				 System.out.println("****Error****");
				return;
				
				}
		}
		
		
		
		
	}


	static ArrayList<String> data =new ArrayList<String>();
	private static int checkBrute(String str)
	{
		int count=0;
		String current;
		for(int i=0;i<str.length();i++)
		{
			current=str.substring(i);
			for(int j=1;j<current.length()+1;j++)
			{
				String s=current.substring(0,j);
				if(data.contains(s))
				{count++;
				 System.out.println("Data:"+s);
				}
			}
			
		}
		return count;
	}





private static int checkCountinString(String currentString) {
		
		int count=0;
		
		
			String str=currentString;
			TreeNode currentNode=rootNode;
			for(int j=0;j<str.length();j++)
			{   
				String ch=str.substring(j, j+1);
				TreeNode child=currentNode.hasChild(ch);
				TreeNode currentNodeFailedNode=currentNode.failedLink;
				
				if(child!=null)
				{	
					currentNode=child;
				    
				}
				else
				{
					while(true)
					{
						if(currentNodeFailedNode.hasChild(ch)!=null)
							{currentNode=currentNodeFailedNode.hasChild(ch);
							 break;
							}
						
						if(currentNodeFailedNode==rootNode)
						{
							currentNode=rootNode;
							break;
						}
						currentNodeFailedNode=currentNodeFailedNode.failedLink;
					}
					
					
				}
				
				count=count+currentNode.noOfEnds;
			}
		
		
		return count;
	}






	private static void createPowersOfTwoTrie() {
	
		rootNode=new TreeNode("$");
		rootNode.parent=rootNode;
		for(int i=0;i<=800;i++)
		{
			BigInteger answer = BigInteger.valueOf(2).pow(i);
			String str=String.valueOf(answer);
			enterStringinTrie(str,rootNode);
			data.add(str);
		}
		
		optimizeTrie();
		
	}





	private static void optimizeTrie()
	{
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		rootNode.failedLink=rootNode;
		
		for(TreeNode rootChild:rootNode.childs)
		{
			rootChild.failedLink=rootNode;
			queue.addAll(rootChild.childs);
		}
		
		while(!queue.isEmpty())
		{
			TreeNode currentNode=queue.poll();

			TreeNode parentNode=currentNode.parent;
			TreeNode parentNodeFailedNode=parentNode.failedLink;
			
			while(true)
			{
				
				if(parentNodeFailedNode.hasChild(currentNode.data)!=null)
				{
					currentNode.failedLink=parentNodeFailedNode.hasChild(currentNode.data);
					break;
				}
				
				if(parentNodeFailedNode==rootNode)
				{
					currentNode.failedLink=rootNode;
					break;
				}
				
				parentNode=parentNodeFailedNode;
				parentNodeFailedNode=parentNode.failedLink;
			}
				
		
			
			currentNode.noOfEnds=currentNode.noOfEnds+currentNode.failedLink.noOfEnds;
			queue.addAll(currentNode.childs);
			
		}
		
	
	}








	private static void enterStringinTrie(String str, TreeNode rootNode) {
		
		
		TreeNode currentNode=rootNode;
		for(int i=0;i<str.length();i++)
		{
			String ch=str.substring(i,i+1);
			TreeNode child=currentNode.hasChild(ch);
			if(child!=null)
			{	
				currentNode=child;
			
			}
			else
			{
				child=new TreeNode(ch);
				currentNode.childs.add(child);
				child.parent=currentNode;
				currentNode=child;
			}
			
		}
		currentNode.noOfEnds++;
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
