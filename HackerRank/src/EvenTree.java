import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EvenTree
{

	static class Node
	{
		Node parent;
		ArrayList<Node> neighbours=new ArrayList<Node>();
		
		int totalChilds=0;
		boolean isLeafNode=false;
	}
	
	static Node[] vArray;
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner=new FastScanner();
		
		int noOfVertices=scanner.nextInt();
		int noOfEdges=scanner.nextInt();
		
		
		 vArray=new Node[noOfVertices+1];
				
		
		for(int i=0;i<=noOfVertices;i++)
		{
			vArray[i]=new Node();
		}
		
		
		for(int i=0;i<noOfEdges;i++)
		{
			
			int v1=scanner.nextInt();
			int v2=scanner.nextInt();
			
		    vArray[v1].neighbours.add(vArray[v2]);
		    vArray[v2].neighbours.add(vArray[v1]);
			
		}		
		
		
		for(int i=1;i<noOfVertices;i++)
		{
			if(vArray[i].neighbours.size()==1)
				vArray[i].isLeafNode=true;
				
		}
		
		
		
		removeBackLink(vArray[1]);
		calculateChidren(vArray[1]);
		calculateEvenTrees(vArray[1]);
		
		System.out.println(noOfEvenTrees);
		
		
	}




   static int noOfEvenTrees=0;
	
	private static void calculateEvenTrees(Node node) {
		
		
		if(node.isLeafNode)
			return;
		else
		{
			for(Node child:node.neighbours)
			{
				
				if((child.totalChilds+1)%2==0)
					noOfEvenTrees++;
				calculateEvenTrees(child);
				
				
			}
		}
		
	}





	private static void removeBackLink(Node node) {
		
		for(Node child:node.neighbours)
		{
			child.neighbours.remove(node);
			removeBackLink(child);
		}
		
		
	}





	private static int calculateChidren(Node node) {
		
		int count=0;
		if(node.isLeafNode)
			return 0;
		else
		{
			count=count+node.neighbours.size();
			for(Node child:node.neighbours)
			{
				count=count+calculateChidren(child);
			}
			
		}
		node.totalChilds=count;
		return count;
		
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
