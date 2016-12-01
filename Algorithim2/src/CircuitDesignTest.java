import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class CircuitDesignTest {
    private final InputReader reader;
    private final OutputWriter writer;
    HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>();
	HashMap<Integer,ArrayList<Integer>> reverseGraph=new HashMap<Integer,ArrayList<Integer>>();

    public CircuitDesignTest(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new CircuitDesignTest(reader, writer).run();
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
        	
        	HashMap<Integer,Boolean> hasVisited=new HashMap<Integer,Boolean>();
			resetHasVisited(hasVisited,graph);
        	
        	
        	
        	for(int source:postOrder)
        	{
        		ArrayList<Integer> stronglyConnectedMembers=new ArrayList<Integer>();
        		
        		ArrayList<Integer> complement=new ArrayList<Integer>();
        		
        		if(hasVisited.get(source)==false)
        		 { 
        			
        			bfsReachable(source,hasVisited,stronglyConnectedMembers);
                    
        			
        			for(int member:stronglyConnectedMembers)
        			{
        				if(complement.contains(-member))
        					return false;
        				complement.add(member);
        				
        				int absoluteMember=Math.abs(member);
        				
        				if(result[absoluteMember-1]==0)
        					result[absoluteMember-1]=member;
        			}
        		 
        		 
        		 }
        		
        	}
        	
        	return true;
        }
        boolean isSatisfiableOriginal(int[] result) {
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
        

		private void bfsReachable(int source, HashMap<Integer, Boolean> hasVisited, ArrayList<Integer> stronglyConnectedMembers)
		{
			if(hasVisited.get(source)==true)
				return;
			stronglyConnectedMembers.add(source);
			hasVisited.put(source,true);
			ArrayList<Integer> children=graph.get(source);
			for(int child:children)
			{
				bfsReachable(child,hasVisited,stronglyConnectedMembers);
			}
			
		}

		private void resetHasVisited(HashMap<Integer, Boolean> hasVisited, HashMap<Integer, ArrayList<Integer>> graph)
		{
			for (Entry<Integer, ArrayList<Integer>> entry : reverseGraph.entrySet())
			{
				hasVisited.put(entry.getKey(),false);
			}
			
		}

		private void createPostOrder(ArrayList<Integer> postOrder)
		{
			HashMap<Integer,Boolean> hasVisited=new HashMap<Integer,Boolean>();
			
			resetHasVisited(hasVisited,reverseGraph);
			
			
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
       
    	int n=5;
    	int m=10;
    	while(true)
    {	n=n+5;
        m=m+5; 
       

        System.out.println(n+" "+m);
        
        TwoSatisfiability twoSat = new TwoSatisfiability(n, m);
        
      graph=new HashMap<Integer,ArrayList<Integer>>();
      reverseGraph=new HashMap<Integer,ArrayList<Integer>>();
        
        for(int i=1;i<=n;i++)
        {
        	 graph.put(i, new ArrayList<Integer>());
             graph.put(-i, new ArrayList<Integer>());
             reverseGraph.put(i, new ArrayList<Integer>());
             reverseGraph.put(-i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; ++i) {
           
        	int v1=(((int)(Math.random()*100))%n)+1;
        	int v2=(((int)(Math.random()*100))%n)+1;
        	
        	int sign1=((int)(Math.random()*100))%2;
        	if(sign1==1)
        		v1=-v1;
        	
        	
        	int sign2=((int)(Math.random()*100))%2;
        	if(sign2==1)
        		v2=-v2;
        	
        	System.out.println(v1+" "+v2);
        	
        	twoSat.clauses[i].firstVar = v1;
            twoSat.clauses[i].secondVar = v2;
        
            graph.get(-v1).add(v2);
            graph.get(-v2).add(v1);
            
            reverseGraph.get(v2).add(-v1);
            reverseGraph.get(v1).add(-v2);
            
            
        }
        
        
        

        int result[] = new int[n];
        
        boolean original=twoSat.isSatisfiableOriginal(result);
        
        
        int result2[] = new int[n];
        boolean test=twoSat.isSatisfiable(result2);
       
        if(original==test)
        {	System.out.println("Ok");
            System.out.println(original +" "+test);
        }
        else
        {	System.out.println("Error");
        	System.out.println(original +" "+test);
        	return;
        }
        
        System.out.println("************************************");
    }
    
   }

    private static class InputReader {
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

    private static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }
}
