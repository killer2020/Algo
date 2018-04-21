import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonChild {

	
	static int[][] maxLen;
	static String str1;
	static String str2;
	
	public static void main(String args[]) throws Exception
	{
		
		  
		
		FastScanner scanner=new FastScanner();
		str1 = scanner.next();
	    str2 = scanner.next();
		
		maxLen = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<str1.length()+1;i++)
			for(int j=0;j<str2.length()+1;j++)
				maxLen[i][j]=-1;
		
		int max = getMaxStr(0 , 0 );
		
		System.out.println(max);
	}
	
	
	
	private static int getMaxStr(int index1, int index2) {

		if(maxLen[index1][index2]!=-1)
			return maxLen[index1][index2];

		
		if(index1>=str1.length() || index2>=str2.length())
		{	maxLen[index1][index2]=0;
			return 0;
		}
		
		if(str1.charAt(index1) == str2.charAt(index2))
		{	
			
			return (1 + getMaxStr(index1+1,index2+1));
		}
		
		else
		{   
			int max1=0;
			
			if(maxLen[index1][index2+1]== -1)
			{	max1=getMaxStr(index1, index2+1);
			maxLen[index1][index2+1]=max1;
			}
			else
			{
				max1=maxLen[index1][index2+1];
			}
			int max2=0;
				
			if(maxLen[index1+1][index2] == -1)
			 {max2=getMaxStr(index1+1,index2);
			  maxLen[index1+1][index2]=max2;
			 }
			else
			{
				max2=maxLen[index1+1][index2];
			}
			
			return max1>max2? max1: max2;
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
