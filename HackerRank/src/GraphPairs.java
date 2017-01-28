import java.io.*;
import java.util.*;


 class GraphNode
{
	int Node;
	ArrayList<Integer> neighbours=new ArrayList<Integer>();
	boolean visited=false;
	
	public GraphNode(int node,ArrayList<Integer> neighbours)
	{
		this.Node=node;
		this.neighbours=neighbours;
	}
}

public class GraphPairs {
	
	static ArrayList<ArrayList<Integer>> neighbours;
	static boolean[] visited;
    static int nodesInConnectedComponent=0;
	
	public static void main(String[] args) throws Exception{
       
	   FastScanner scanner = new FastScanner();
	   
	   int numOfNodes = scanner.nextInt();
        int edges = scanner.nextInt();
      

       

   
       neighbours=new  ArrayList<ArrayList<Integer>>();
        
        for(int j=0;j<numOfNodes;j++)
        {
        	neighbours.add(new ArrayList<Integer>());
        }

        for(int i = 0; i <edges ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
          
            neighbours.get(a).add(b);
            neighbours.get(b).add(a);
        }
       
       visited=new boolean[numOfNodes];
        
       long answer=0;
       int remainingNodes=numOfNodes;
       for(int k=0;k<numOfNodes;k++)
       {
    	   nodesInConnectedComponent=0;
    	   if(visited[k]==false)
    	   {bfs(k);
    	  // System.out.println(nodesInConnectedComponent);
    	   answer=answer+(nodesInConnectedComponent*(remainingNodes-nodesInConnectedComponent));
    	   remainingNodes=remainingNodes-nodesInConnectedComponent;
    	   }
       }
       
       System.out.println(answer);

    }
   
   
   private static void bfs(int k)
	{
		if(visited[k]==true)
			return;
		nodesInConnectedComponent++;
	   visited[k]=true;
	   for(int neighbour:neighbours.get(k))
	   {
		   bfs(neighbour);
	   }
	   
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

 

