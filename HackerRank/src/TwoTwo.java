
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
	
	static String[] powersOfTwo=new String[801];
	
	static class TreeNode
	{
		String data;
		ArrayList<TreeNode> childs=new ArrayList<TreeNode>();
		
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
		
		FastScanner scanner=new FastScanner();
		int numberOfStrings=scanner.nextInt();
		int count=0;
		
		
		for(int i=0;i<=800;i++)
		{
			powersOfTwo[i]=new DecimalFormat("#").format(Math.pow(2, i));
			System.out.println(powersOfTwo[i]);
		}
		
		createPowersOfTwoTrie();
		
		for(int i=0;i<numberOfStrings;i++)
		{
			
			String currentString=scanner.next();
			
		}
		
		
		
		
		
		System.out.println(count);
	}





	private static void createPowersOfTwoTrie() {
		
		
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
