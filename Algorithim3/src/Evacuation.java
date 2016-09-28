import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Evacuation {
    private static FastScanner in;
    static Graph graph = new Graph();
    static Graph residualGraph= new Graph();
    
    public static void main(String[] args) throws IOException {
        in = new FastScanner();

        

        readGraph(graph,residualGraph);
        
        
        
        System.out.println(maxFlow(graph,residualGraph));
        System.out.println(residualGraph.nodes.get(residualGraph.nodes.size()-1).parentNode+1);
    }

    private static int maxFlow(Graph graph,Graph residualGraph) {
        int flow = 0;
        boolean pathFound;
        
        Node root=residualGraph.nodes.get(0);
        int target=residualGraph.nodes.size()-1;
        pathFound=findPath(root,target,false);
        
        System.out.println(pathFound);
        
        return flow;
    }

    private static boolean findPath(Node root,int target,boolean found)
	{
       
    	
    	if(found)
    		return true;
    	
    	root.visited=true;
    	for(Edge edge:root.edges)
    	{
    		if(edge.flow<=0 || residualGraph.nodes.get(edge.to).visited)
    			continue;
    		residualGraph.nodes.get(edge.to).parentNode=root.nodeNumber;
    		if(edge.to==target)
    			return true;
    		else
    		{	
    			found=findPath(residualGraph.nodes.get(edge.to),target,found);
    		}
    		
    	}
    	
    	
		return found;
	}
    
    
    

	static void readGraph(Graph graph, Graph residualGraph) throws IOException {
        int vertex_count = in.nextInt();
        int edge_count = in.nextInt();

        for(int i=0;i<vertex_count;i++)
        {
        	graph.nodes.add(new Node(i));
        	residualGraph.nodes.add(new Node(i));
        }
        
        
        for (int i = 0; i < edge_count; ++i) {
            int from = in.nextInt() - 1, to = in.nextInt() - 1, capacity = in.nextInt();
            graph.addEdge(from, to, capacity,0);
            residualGraph.addEdge(from,to, capacity,capacity);
        }
    }

    static class Edge {

        int to;
    	int capacity, flow;

        public Edge(int to, int capacity,int flow) {
            this.to = to;
            this.capacity = capacity;
            this.flow = flow;
        }
        
        
        public void addFlow(int flow)
        {
        	this.flow=flow;
        }
    }

    
    static class Node
    {
    	int nodeNumber;
    	int parentNode;
    	int minFlow;
    	boolean visited=false;
        ArrayList<Edge> edges=new ArrayList<Edge>();    	
    	
        public Node(int nodeNumber)
        {
        	this.nodeNumber=nodeNumber;
        }
    }
    
    static class Graph
    {
    	ArrayList<Node> nodes=new ArrayList<Node>();
    	
    	public void addEdge(int from,int to,int capacity,int flow)
    	{
    		nodes.get(from).edges.add(new Edge(to,capacity,flow));
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
