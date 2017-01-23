import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class TreeNode
{
	char data;
	ArrayList<TreeNode> childs=new ArrayList<TreeNode>();
	
	boolean isLeaf=false;
	
	public TreeNode(char data)
	{
		this.data=data;
	}

	TreeNode containsChar(char s)
	{
		for(TreeNode child:childs)
		{
			if(child.data==s)
				return child;
		}
		return null;
	}
}
public class NoPrefix
{

	
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner = new FastScanner();
		
		TreeNode root=new TreeNode('$');
		
		int count=scanner.nextInt();
		
		TreeNode currentRoot=root;
		
		for(int i=0;i<count;i++)
		{
			String str=scanner.next();
			boolean isUnique=false;
			
			for(int j=0;j<str.length();j++)
			{
				char c=str.charAt(j);
				TreeNode contains=currentRoot.containsChar(c);
				if(contains!=null)
				{	
				    if(contains.isLeaf)
					{
						System.out.println("BAD SET");
						System.out.println(str);
						return;
					}
				    currentRoot=contains;
				}
				else
				{
					TreeNode newNode=new TreeNode(c);
					newNode.isLeaf=isLeaf(j,str.length());
					currentRoot.childs.add(newNode);
					currentRoot=newNode;
					isUnique=true;
				}
					
				
			}
			
			if(!isUnique)
			{
				System.out.println("BAD SET");
				System.out.println(str);
				return;
			}
		
			currentRoot=root;
		}
		
		System.out.println("GOOD SET");
		
	}
	
	private static boolean isLeaf(int j, int length)
	{
		if(j==length-1)
			return true;
		return false;
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
