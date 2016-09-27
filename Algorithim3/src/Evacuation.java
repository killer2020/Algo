import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Evacuation {
    private static FastScanner in;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();

        
        Graph graph = new Graph();
        Graph residualGraph= new Graph();
        readGraph(graph,residualGraph);
        
        System.out.println(maxFlow(graph,residualGraph));
    }

    private static int maxFlow(Graph graph,Graph reverseGraph) {
        int flow = 0;
        /* your code goes here */
        return flow;
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
            residualGraph.addEdge(from,to, 0,capacity);
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
