import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class CircuitDesign {
    private final InputReader reader;
    private final OutputWriter writer;
    HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>();
	HashMap<Integer,ArrayList<Integer>> reverseGraph=new HashMap<Integer,ArrayList<Integer>>();

    public CircuitDesign(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new CircuitDesign(reader, writer).run();
        writer.writer.flush();
    }

    class Clause {
        int firstVar;
        int secondVar;
    }

    class Node
    {
    	int vertex;
    	ArrayList<Node> children=new ArrayList<Node>();
    	
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
           
        	
        	ArrayList<Integer> postOrder=new ArrayList<Integer>();
        	
        	createPostOrder(postOrder);
        	
        	Collections.reverse(postOrder);
        	
        	for(int source:postOrder)
        	{
        		
        	}
        	
        	
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

		private void createPostOrder(ArrayList<Integer> postOrder)
		{
			HashMap<Integer,Boolean> hasVisited=new HashMap<Integer,Boolean>();
			for (Entry<Integer, ArrayList<Integer>> entry : reverseGraph.entrySet())
			{
				hasVisited.put(entry.getKey(),false);
			}
			
			for (Entry<Integer, ArrayList<Integer>> entry : reverseGraph.entrySet())
			{
			    int key=entry.getKey();
			    if(hasVisited.get(key)==false)
			    	{
			    	 bfs(key,hasVisited,postOrder);
			    	}
			}
		}

		private void bfs(int key, HashMap<Integer, Boolean> hasVisited, ArrayList<Integer> postOrder)
		{   
			if(hasVisited.get(key)==true)
				return;
			hasVisited.put(key,true);
			
			for(int child:reverseGraph.get(key))
			{
				bfs(child,hasVisited,postOrder);
			}
			
			postOrder.add(key);
		}

    }

    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();

        TwoSatisfiability twoSat = new TwoSatisfiability(n, m);
        
        for(int i=1;i<=n;i++)
        {
        	 graph.put(i, new ArrayList<Integer>());
             graph.put(-i, new ArrayList<Integer>());
             reverseGraph.put(i, new ArrayList<Integer>());
             reverseGraph.put(-i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; ++i) {
           
        	int v1=reader.nextInt();
        	int v2=reader.nextInt();
        	twoSat.clauses[i].firstVar = v1;
            twoSat.clauses[i].secondVar = v2;
        
            graph.get(-v1).add(v2);
            graph.get(-v2).add(v1);
            
            reverseGraph.get(v2).add(-v1);
            reverseGraph.get(v1).add(-v2);
            
            
        }
        
        
        

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
