import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortedSubSegments
{

	
	public static void main(String[] args) throws Exception
	{

		FastScanner scanner=new FastScanner();
		int size=scanner.nextInt();
		int queries=scanner.nextInt();
		int index=scanner.nextInt();
		
		
		int[] arr=new int[size];
		
		for(int i=0;i<size;i++)
		{
			arr[i]=scanner.nextInt();
			
		}
		
	
		
		for(int i=0;i<queries;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
		
		
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
