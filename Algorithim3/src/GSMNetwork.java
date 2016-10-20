import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class GSMNetwork {
    private final InputReader reader;
    private final OutputWriter writer;

    public GSMNetwork(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new GSMNetwork(reader, writer).run();
        writer.writer.flush();
    }

    class Edge {
        int from;
        int to;
    }

    class ConvertGSMNetworkProblemToSat {
        int numVertices;
        Edge[] edges;
        int variables;
        ArrayList<String> clauses=new ArrayList<String>();
        ConvertGSMNetworkProblemToSat (int n, int m) {
            numVertices = n;
            edges = new Edge[m];
            variables=numVertices*3;
            for (int i = 0; i < m; ++i) {
                edges[i] = new Edge();
            }
            
           
           
        }

        void printEquisatisfiableSatFormula() {
          
        	
        	 
            for(int i=0;i<numVertices;i++)
            {
            	int xi1=i*3+1;
            	int xi2=xi1+1;
            	int xi3=xi2+1;
            	
            	clauses.add(""+xi1+" "+xi2+" "+xi3+" 0");
                clauses.add(""+(-xi1)+" "+(-xi2)+" 0");	
                clauses.add(""+(-xi2)+" "+(-xi3)+" 0");	
                clauses.add(""+(-xi3)+" "+(-xi1)+" 0");	
            }
            
            for(Edge edge:edges)
            {
            	int from=edge.from;
            	int to=edge.to;
            	
            	
            	int x1=(from-1)*3+1;
            	int x2=x1+1;
            	int x3=x2+1;
            	int y1=(to-1)*3+1;
            	int y2=y1+1;
            	int y3=y2+1;
            	
            	clauses.add(""+(-x1)+" "+(-y1)+" 0");
            	clauses.add(""+(-x2)+" "+(-y2)+" 0");
            	clauses.add(""+(-x3)+" "+(-y3)+" 0");
            	
            }
        	
        	
        	
            writer.printf(clauses.size()+" "+variables+"\n");
            for(String clause:clauses)
            	writer.printf(clause+"\n");
        }
    }

    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();

       
        
        ConvertGSMNetworkProblemToSat  converter = new ConvertGSMNetworkProblemToSat (n, m);
        for (int i = 0; i < m; ++i) {
            converter.edges[i].from = reader.nextInt();
            converter.edges[i].to = reader.nextInt();
        }

        converter.printEquisatisfiableSatFormula();
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
