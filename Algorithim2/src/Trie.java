import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trie {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    
    class Node{
    	int node;
    	char data;
    	ArrayList<Node> childs=new ArrayList<Node>();
    	
    	public Node(int node,char data)
    	{
    		this.node=node;
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

	private int nodeNumber=1;
	ArrayList<String> output=new ArrayList<String>();
    
    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();

        Node root=new Node(0,'R');
        
        for(String pattern:patterns)
        {
        	updateTree(root,pattern,trie);
        }

        return trie;
    }

    private void updateTree(Node root, String pattern, List<Map<Character, Integer>> trie)
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
            	 Node newNode=new Node(nodeNumber,character);
            	 currentNode.childs.add(newNode);
            	 output.add(currentNode.node+"->"+nodeNumber+":"+character);
            	 currentNode=newNode;
            	 nodeNumber++;
             }
			
		}
		
	}

	static public void main(String[] args) throws IOException {
        new Trie().run();
    }

    public void print() {
        for (String row:output) {
                System.out.println(row);
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print();
    }
}
