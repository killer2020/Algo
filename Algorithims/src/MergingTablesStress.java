import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;



public class MergingTablesStress {
    private final InputReader reader;
    private final OutputWriter writer;

    public MergingTablesStress(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new MergingTablesStress(reader, writer).run();
        writer.writer.flush();
    }

    class Table {
        Table parent;
        int rank;
        int numberOfRows;

        Table(int numberOfRows) {
            this.numberOfRows = numberOfRows;
            rank = 0;
            parent = this;
        }
        Table getParent() {
            if(parent==this)
            return parent;
            else 
            {
            	parent=parent.getParent();
            	return parent;
            }
        }
    }

    int maximumNumberOfRows = 0;

    void merge(Table destination, Table source) {
        Table realDestination = destination.getParent();
        Table realSource = source.getParent();
        if (realDestination == realSource) {
            return;
        }
     
       int finalRows;
       if(realDestination.rank<realSource.rank)
       {
    	   realSource.numberOfRows=realDestination.numberOfRows+realSource.numberOfRows;
    	   realDestination.parent=realSource;
    	   finalRows=realSource.numberOfRows;
       }
       else
       {
    	   realDestination.numberOfRows=realDestination.numberOfRows+realSource.numberOfRows;
           realSource.parent=realDestination; 
           finalRows=realDestination.numberOfRows;
       }
       
       if(finalRows>maximumNumberOfRows)
    	   maximumNumberOfRows=finalRows;
       
       
        
    }

    public void run() {
        int n = 100000;
        int m = 100000;
        Table[] tables = new Table[n];
        for (int i = 0; i < n; i++) {
            int numberOfRows =10;
            tables[i] = new Table(numberOfRows);
            maximumNumberOfRows = Math.max(maximumNumberOfRows, numberOfRows);
        }
        for (int i = 0; i < m; i++) {
            int destination = (i+1)%100000;
            int source =(i+2)%100000;
            merge(tables[destination], tables[source]);
            writer.printf("%d\n", maximumNumberOfRows);
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
