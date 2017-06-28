import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class MaximumSubArraySumTest
{

	static long[] arr;
	
	public static void main(String args[]) throws Exception
	{
		
        FastScanner scanner=new FastScanner();
		
		
		
		
		while(true)
		{
			
			int size= (int) (Math.random()*100)+1;
			long mod=(long) (Math.random()*100)+1;
			
			long max=0;
			
			arr=new long[size];
			
			long[] sumArr=new long[size];
			
			String str="";
			
			for(int j=0;j<size;j++)
			{
				arr[j]=(long) (Math.random()*100)+1;
				str=str+arr[j]+" ";
			}
			
			sumArr[0]=arr[0];
			if(sumArr[0]%mod>max)
				max=sumArr[0]%mod;
			
			for(int j=1;j<size;j++)
			{
				sumArr[j]=arr[j]+sumArr[j-1];
				if(sumArr[j]%mod>max)
					max=sumArr[j]%mod;
			}
			
			
			
			for(int j=0;j<size;j++)
			{
				
				for(int k=0;k<=j;k++)
				{
					sumArr[j]=sumArr[j]-arr[k];
					if(sumArr[j]%mod>max)
						max=sumArr[j]%mod;
					
				}
			}
			
			
			
			System.out.println();
			System.out.println("Size:"+size);
			System.out.println(str);
			System.out.println("Mod:"+mod);
			
			long bruteResult=calcBruteResult(mod,size);
			System.out.println("Largest:"+max);
			System.out.println("Brute:"+bruteResult);
			
			if(bruteResult!=max)
				return;
			
			
		}
		
		
		
	}



	private static long calcBruteResult(long mod,int size)
	{
        long max=0;
		
	    for(int i=0;i<size;i++)
	    {
	    	
	    	for(int j=i;j<size;j++)
	    	{
	    		long sum=0;
	    		
	    		for(int k=i;k<=j;k++)
	    		{
	    			sum=sum+arr[k];
	    		}
	    	
	    		sum=sum%mod;
	    		if(sum>max)
	    			max=sum;
	    	}
	    	
	    	
	    }
		
		return max;
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