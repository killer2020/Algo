
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoTwoHashMap
{
	
	static TreeNode rootNode;
	
	static class TreeNode
	{
		String data;
		HashMap<String,TreeNode> childs=new HashMap<String,TreeNode>();
		
		boolean isEndOfString=false;
		
		public TreeNode(String data)
		{
			this.data=data;
		}
		
		public TreeNode hasChild(String ch)
		{
			TreeNode child=childs.get(ch);
			
			return child;
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
			BigInteger answer = BigInteger.valueOf(2).pow(i);
			String str=String.valueOf(answer);
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
				currentNode.childs.put(ch, child);
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
