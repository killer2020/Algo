import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RepKSums
{
	
	
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner=new FastScanner();
		
		int n=scanner.nextInt();
		
		int k=scanner.nextInt();
		
		int noOfTerms=0;
		
       int arr[][]=new int[k][n];
       
       for(int i=0;i<n;i++)
       {
    	   arr[0][i]=1;
       }
       for(int i=0;i<k;i++)
       {
    	   arr[i][0]=1;
       }
       
       
       for(int i=1;i<k;i++)
       {
    	   
    	   for(int j=1;j<n;j++)
    		   arr[i][j]=arr[i-1][j]+arr[i][j-1];
    	   
       }
       
       
       for(int i=0;i<n;i++)
    	   noOfTerms=noOfTerms+arr[k-1][i];
       
       System.out.println("No. Of Terms:"+noOfTerms);
       
       
       List<Long> sumList=new ArrayList<Long>();
       long sumOfN=0;
       
       for(int i=0;i<noOfTerms;i++)
       {
    	   
    	   long next=scanner.nextInt();
    	   sumList.add(next);
    	   
    	   sumOfN=sumOfN+next;
    	   
       }

       sumOfN=(sumOfN*n)/(noOfTerms*k);
       
       System.out.println("Sum Of Terms:"+sumOfN);
       
       
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
