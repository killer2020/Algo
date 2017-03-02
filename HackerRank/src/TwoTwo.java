
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoTwo
{
	
	static TreeNode rootNode;
	
	static class TreeNode
	{
		String data;
		ArrayList<TreeNode> childs=new ArrayList<TreeNode>();
		
		boolean isEndOfString=false;
		
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
		
		for(int i=0;i<currentString.length();i++)
		{
			String str=currentString.substring(i);
			TreeNode currentNode=rootNode;
			for(int j=0;j<str.length();j++)
			{   
				String ch=str.substring(j, j+1);
				TreeNode child=currentNode.hasChild(ch);
				if(child!=null)
				{	
					currentNode=child;
				    if(child.isEndOfString)
				    {count++;
				    }
				}
				else
				{
					break;
				}
			}
		}
		
		return count;
	}





	private static void createPowersOfTwoTrie() {
	
		rootNode=new TreeNode("$");
		for(int i=0;i<=800;i++)
		{
			String str=new DecimalFormat("#").format(Math.pow(2, i));
			enterStringinTrie(str,rootNode);
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
				currentNode=child;
			}
			
		}
		currentNode.isEndOfString=true;
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
