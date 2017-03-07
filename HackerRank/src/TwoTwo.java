import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoTwo
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
		int numberOfStrings=scanner.nextInt();
		
		
		for(int i=0;i<numberOfStrings;i++)
		{
			
			String currentString=scanner.next();
			int currentStringResult=checkCountinString(currentString);
			System.out.println(currentStringResult);
		}
		
		
		
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
			//System.out.println(str);
			enterStringinTrie(str,rootNode);
		}
		
		ahoCorasickOptimization();
		
	}





	private static void ahoCorasickOptimization()
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