import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Manacher
{

	private static String testString="#";
	private static int center=0;
	private static int radius=0;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		String str=scanner.next();
		
		for(int i=0;i<str.length();i++)
		{
			testString=testString+str.charAt(i);
			testString=testString+"#";
		}
		

		
		for(int i=1;i<testString.length();i++)
		{
			if(center+radius<i)
			{
				calcPalindromeAround(i);
			}
			else
			{
				
				
			}
			
			
		}
		
		
	}
	
	
	private static void calcPalindromeAround(int i)
	{
		int localRadius=0;
		int left=i-1;
	    int right=i+1;
		
		
		while((left>=0 && right<testString.length()) && testString.charAt(left)==testString.charAt(right))
		{
			localRadius++;
			left--;
			right++;
		}
		
		if(localRadius>=radius)
		{
			radius=localRadius;
			center=i;
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
	    
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	}
}
