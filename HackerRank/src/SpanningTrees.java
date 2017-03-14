import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class SpanningTrees
{

	static class Graph
	{
		
	   HashMap<Integer,ArrayList<Integer>> edges=new HashMap<Integer,ArrayList<Integer>>();
	   	
	   int totalNumberOfEdges=0;
	
	   
	   public Graph(int numberOfVertex)
	   {
		   for(int i=1;i<=numberOfVertex;i++)
		   {   
			   edges.put(i, new ArrayList<Integer>());
		   
		   }
	   }
	   
	   
	   public Graph(Graph graph)
	   {
		   
		   for(Entry<Integer,ArrayList<Integer>> entry:graph.edges.entrySet())
		   {
			  ArrayList<Integer> temp=new ArrayList<Integer>();
			  temp.addAll(entry.getValue());
			  edges.put(entry.getKey(),temp); 
		   }
		   this.totalNumberOfEdges=graph.numberofEdges();
	   }
	   
	   public int numberofEdges()
	   {
		   return totalNumberOfEdges;
		   
	   }
	   
	   public int numberofVertex()
	   {
		   return edges.size();
		   
	   }
	   public void addEdge(int a,int b)
	   {
		  
		   edges.get(a).add(b);
		   edges.get(b).add(a);
		   totalNumberOfEdges++;
  	   }
	   
	   public void removeEdge(int a,int b)
	   {
		   boolean deleted1=edges.get(a).remove((Object)b);
		   boolean deleted2=edges.get(b).remove((Object)a);
		   
		   if(deleted1 && deleted2)
		   totalNumberOfEdges--;

		 
		   
	   }
	   
	   public boolean removeOrphanVertex(int a,int b)
	   {
		   boolean removed=false;
		   
		   if(edges.get(a).isEmpty())
		   {   edges.remove(a);
		       removed=true;
		   }
		   if(edges.get(b).isEmpty())
		   {   edges.remove(b);
		       removed =true;
		   }
		   
		   return removed;
	   }
	   
	   public void mergeEdge(int a ,int b)
	   {
		   removeEdge(a,b);
		   ArrayList<Integer> neighboursB=new ArrayList<Integer>();
		   neighboursB.addAll(edges.get(b));
		   for(int neighbourB:neighboursB)
		   {
			   removeEdge(neighbourB,b);
			   
			   if(a!=neighbourB)
			   addEdge(neighbourB,a);
			   	   
		   }
		   
		   edges.remove(b);
	   }
	   
	   public int[] getRandomEdge()
	   {
		   for(Entry<Integer,ArrayList<Integer>> entry:edges.entrySet())
		   {
			   if(entry.getValue().size()>0)
			   {
				   int a[]=new int[2];
				   a[0]=entry.getKey();
				   a[1]=entry.getValue().get(0);
				   return a;
			   }
			   
		   }
		   return null;
	   }
		
	}
	
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		int noOfVertex=scanner.nextInt();
		int noOfEdges=scanner.nextInt();
		
	    Graph graph=new Graph(noOfVertex);
		
		for(int i=0;i<noOfEdges;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			//int weight=scanner.nextInt();
		    graph.addEdge(a, b);
	     }
	
		
		 int numberOfSparseTrees=calcNoOfSparseTrees(graph);
		 
		 
		 System.out.println(numberOfSparseTrees);
	
     }



	private static int calcNoOfSparseTrees(Graph graph)
	{
		if(graph.numberofEdges()==graph.numberofVertex()-1)
			return 1;
		Graph graphA=new Graph(graph);
		Graph graphB=new Graph(graph);
		int randomEdge[]=graph.getRandomEdge();
		
		graphA.removeEdge(randomEdge[0],randomEdge[1]);
		boolean removed=graphA.removeOrphanVertex(randomEdge[0],randomEdge[1]);
		
		graphB.mergeEdge(randomEdge[0],randomEdge[1]);
		

		if(removed)
		return calcNoOfSparseTrees(graphB);
		else		
		return calcNoOfSparseTrees(graphA)+calcNoOfSparseTrees(graphB);
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
