import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Evacuation {
    private static FastScanner in;
    static Graph graph = new Graph();
    static Graph residualGraph= new Graph();
    static ArrayList<Integer> path;
    
    public static void main(String[] args) throws IOException {
        in = new FastScanner();

        readGraph(graph,residualGraph);
        
        System.out.println(maxFlow(graph,residualGraph));

         //System.out.println(path);
    }

    private static int maxFlow(Graph graph,Graph residualGraph) {
        int flow = 0;
        boolean pathFound=false;
        int minFlow=0;
        Node root=residualGraph.nodes.get(0);
        int target=residualGraph.nodes.size()-1;
        
        pathFound=findPath(root,target,false);
        
        while(pathFound)
        {
        	 minFlow=findMinFlow(residualGraph);
             
             addFlow(minFlow,graph,residualGraph);
        	
             resetVisitedFlag();
        	 pathFound=findPath(root,target,false);
        }
        
       
        
        
       // System.out.println("MinFlow:"+minFlow);
       // System.out.println(pathFound);
        
        Node startFlow=graph.nodes.get(0);
       
        for(Map.Entry<Integer,Edge> edge:startFlow.edges.entrySet())
           flow=flow+edge.getValue().flow;
        
        return flow;
    }

    private static void resetVisitedFlag()
	{
		for(Node node:residualGraph.nodes)
			node.visited=false;
		
	}

	private static void addFlow(int minFlow, Graph graph, Graph residualGraph)
	{
		for(int i=0;i<path.size()-1;i++)
		{
			int from=path.get(i);
			int to=path.get(i+1);
			graph.newFlow(from, to, minFlow);
			residualGraph.newFlow(from, to, -minFlow);
			residualGraph.newFlow(to,from, minFlow);
		}
		
	}
    
    
    
	private static int findMinFlow(Graph residualGraph)
	{
		path=new ArrayList<Integer>();
		
		
    	int target=residualGraph.nodes.size()-1;
    	Node targetNode=residualGraph.nodes.get(target);
    	int parent=targetNode.parentNode;
    	
    	
    	int flow=residualGraph.getFlow(parent,target);
    	
    	path.add(target);
    	while(parent!=0)
    	{
    		target=parent;
    		parent=residualGraph.nodes.get(parent).parentNode;
    		
    		int newFlow=residualGraph.getFlow(parent,target);
    		if(newFlow<flow)
    			flow=newFlow;
    		
    		path.add(target);
    	}
    	
    	path.add(0);
    	Collections.reverse(path);
		return flow;
		
	}

	private static boolean findPath(Node root,int target,boolean found)
	{
       
    	
    	if(found)
    		return true;
    	
    	root.visited=true;
    	for(Map.Entry<Integer,Edge> edge:root.edges.entrySet())
    	{
    		if(edge.getValue().flow<=0 || residualGraph.nodes.get(edge.getKey()).visited)
    			continue;
    		residualGraph.nodes.get(edge.getKey()).parentNode=root.nodeNumber;
    		if(edge.getKey()==target)
    			return true;
    		else
    		{	
    			found=findPath(residualGraph.nodes.get(edge.getKey()),target,found);
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
    	
        HashMap<Integer,Edge> edges=new HashMap<Integer,Edge>();
        
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
    		
    		if(nodes.get(from).edges.get(to)!=null)
    			nodes.get(from).edges.get(to).flow=nodes.get(from).edges.get(to).flow+flow;
    		else
    			nodes.get(from).edges.put(to, new Edge(to,capacity,flow));
    	}

		public int getFlow(int parent, int target)
		{
			Node from=nodes.get(parent);
			
			Edge edge=from.edges.get(target);
			
			if(edge!=null)
				return edge.flow;
			
			return 0;
		}
		
		
		public void newFlow(int from,int to,int flow)
		{
			
			Node fromNode=nodes.get(from);
			
			Edge edge=fromNode.edges.get(to);
			if(edge!=null)
			{
				flow=flow+edge.flow;
				edge.flow=flow;
			    return;
			}
			
			
			Edge newEdge=new Edge(from,to,flow);
			fromNode.edges.put(to, newEdge);
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
