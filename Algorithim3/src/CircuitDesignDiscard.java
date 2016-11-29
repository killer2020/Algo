import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class CircuitDesignDiscard {
    private final InputReader reader;
    private final OutputWriter writer;
    static int order=0;
    public CircuitDesignDiscard(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new CircuitDesignDiscard(reader, writer).run();
        writer.writer.flush();
    }

    class Clause {
        int firstVar;
        int secondVar;
    }

    class TwoSatisfiability {
        int numVars;
        Clause[] clauses;

        TwoSatisfiability(int n, int m) {
            numVars = n;
            clauses = new Clause[m];
            for (int i = 0; i < m; ++i) {
                clauses[i] = new Clause();
            }
        }

        boolean isSatisfiable(int[] result) {
            // This solution tries all possible 2^n variable assignments.
            // It is too slow to pass the problem.
            // Implement a more efficient algorithm here.
            for (int mask = 0; mask < (1 << numVars); ++mask) {
                for (int i = 0; i < numVars; ++i) {
                    result[i] = (mask >> i) & 1;
                }

                boolean formulaIsSatisfied = true;

                for (Clause clause: clauses) {
                    boolean clauseIsSatisfied = false;
                    if ((result[Math.abs(clause.firstVar) - 1] == 1) == (clause.firstVar < 0)) {
                        clauseIsSatisfied = true;
                    }
                    if ((result[Math.abs(clause.secondVar) - 1] == 1) == (clause.secondVar < 0)) {
                        clauseIsSatisfied = true;
                    }
                    if (!clauseIsSatisfied) {
                        formulaIsSatisfied = false;
                        break;
                    }
                }

                if (formulaIsSatisfied) {
                    return true;
                }
            }
            return false;
        }
    }

    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();

        TwoSatisfiability twoSat = new TwoSatisfiability(n, m);
//        for (int i = 0; i < m; ++i) {
//            twoSat.clauses[i].firstVar = reader.nextInt();
//            twoSat.clauses[i].secondVar = reader.nextInt();
//        }

        
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[2*n+1];
        ArrayList<Integer>[] reverseAdj = (ArrayList<Integer>[])new ArrayList[2*n+1];
        for (int i = 0; i < (2*n+1); i++) {
            adj[i] = new ArrayList<Integer>();
            reverseAdj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            
            int var1 = reader.nextInt();
            int var2 = reader.nextInt();
            int x=var1, y=var2;
            
            addEdge(-var1,var2,adj,reverseAdj,n);
            addEdge(-var2,var1,adj,reverseAdj,n);
          
        }
       
        System.out.println(acyclic(adj,reverseAdj));
        
        
        
        int result[] = new int[n];
        if (twoSat.isSatisfiable(result)) {
            writer.printf("SATISFIABLE\n");
            for (int i = 1; i <= n; ++i) {
                if (result[i-1] == 1) {
                    writer.printf("%d", -i);
                } else {
                    writer.printf("%d", i);
                }
                if (i < n) {
                    writer.printf(" ");
                } else {
                    writer.printf("\n");
                }
            }
        } else {
            writer.printf("UNSATISFIABLE\n");
        }
    }

    private static int acyclic(ArrayList<Integer>[] adj,ArrayList<Integer>[] reverseAdj) {
        
        int connectedComponents=0;	
        int[] postOrder=new int[adj.length+1];
        boolean[] visited=new boolean[adj.length+1];
        ArrayList<Integer> notinGraph=new ArrayList<>();
        //to get sink node
        fillPostOrder(0,reverseAdj,postOrder,visited);
        
        for(int i=postOrder.length-2;i>=0;i--)
        {
        	if(notinGraph.contains(postOrder[i]))
        	{
        		continue;
        	}
        	connectedComponents++;
        	ArrayList<Integer> reachable=new ArrayList<Integer>();
        	boolean[] visitedSub=new boolean[adj.length];
        	
        	//this will get all nodes reachable from this node
        	bfsFill(adj,postOrder[i], visitedSub, reachable);
        	
        	for(Integer reach:reachable)
        	{
        		notinGraph.add(reach);
        		for(Integer neighbour:reverseAdj[reach])
        	{
        		adj[neighbour].remove((Object)reach);
        	}
        	}
        	}
        
        return connectedComponents;	
        }

        
        
      


    	private static void fillPostOrder(int root,ArrayList<Integer>[] adj, int[] postOrder, boolean[] visited) {
    		 
    		for(int i=1;i<adj.length;i++)
    		{
    			bfs(adj,i,visited,postOrder);
    			
    		}
        	
    	}

    	private static void bfsFill(ArrayList<Integer>[] adj, int i, boolean[] visited,ArrayList<Integer> reachable) {
    		if(visited[i]==true)
    			return;
    		visited[i]=true;
    		reachable.add(i);
    		for(Integer neighbour:adj[i])
    		{   
    			bfsFill(adj,neighbour,visited,reachable);
    		}
    		
    	}


    	private static void bfs(ArrayList<Integer>[] adj, int i, boolean[] visited,int[] postOrder) {
    		if(visited[i]==true)
    			return;
    		visited[i]=true;
    		for(Integer neighbour:adj[i])
    		{   
    			bfs(adj,neighbour,visited,postOrder);
    		}
    		postOrder[order]=i;
    		order=order+1;
    	}






    	

	private void addEdge(int var1, int var2, ArrayList<Integer>[] adj, ArrayList<Integer>[] reverseAdj,int n)
	{
    	 int x=var1, y=var2;
         if(var1<0)
         	x=-var1+n;
         if(var2<0)
         	y=-var2+n;
         
         adj[x].add(y);
         reverseAdj[y].add(x);
	}

	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }
}
