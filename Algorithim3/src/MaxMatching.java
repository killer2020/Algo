import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MaxMatching {
    private PrintWriter out;

    private static FastScanner in;
    static Graph graph = new Graph();
    static Graph residualGraph= new Graph();
    static ArrayList<Integer> path;
    static int leftNodesNum=0;
    static int[] match;
    private static void maxFlow(Graph graph,Graph residualGraph) {
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
			if(from>=1 && from<=leftNodesNum)
				match[from-1]=to-leftNodesNum;
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

        int numLeft = in.nextInt();
        leftNodesNum=numLeft;
        int numRight = in.nextInt();
        
        for(int i=0;i<(numLeft+numRight+2);i++)
        {
        	graph.nodes.add(new Node(i));
        	residualGraph.nodes.add(new Node(i));
        }
        
        
        for (int i = 1; i <=numLeft; ++i) {
            int from = 0, to = i, capacity = 1;
            graph.addEdge(from, to, capacity,0);
            residualGraph.addEdge(from,to, capacity,capacity);
        }
        
        for (int i = numLeft+1; i <=numLeft+numRight; ++i) {
            int from = i, to = graph.nodes.size()-1, capacity = 1;
            graph.addEdge(from, to, capacity,0);
            residualGraph.addEdge(from,to, capacity,capacity);
        }
        
        
        for (int i = 0; i < numLeft; ++i)
            for (int j = 0; j < numRight; ++j)
            {  if(in.nextInt() == 1)
               {
            	 graph.addEdge(i+1, numLeft+1+j, 1,0);
                 residualGraph.addEdge(i+1, numLeft+1+j, 1,1);
               }
            }
        match=new int[leftNodesNum];
        Arrays.fill(match, -1);
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
    
    
    
    public static void main(String[] args) throws IOException {
        new MaxMatching().solve();
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        readGraph(graph,residualGraph);
        
        maxFlow(graph,residualGraph);
        
        
        //int[] matching = findMatching(graph);
        writeResponse(match);
        out.close();
    }

 
    private void writeResponse(int[] matching) {
        for (int i = 0; i < matching.length; ++i) {
            if (i > 0) {
                out.print(" ");
            }
            if (matching[i] == -1) {
                out.print("-1");
            } else {
                out.print(matching[i]);
            }
        }
        out.println();
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
