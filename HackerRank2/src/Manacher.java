import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Manacher
{

	private static String testString="#";
	private static int[] allRadius;
	private static int center=0;
	private static int radius=0;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		int len=scanner.nextInt();
		String str=scanner.next();
		
		for(int j=0;j<len;j++)
		{
			if(j!=0)
		    {char first=str.charAt(0);
		    str=str.substring(1);
			str=str+first;
		    }
			testString="#";
			center=0;
			radius=0;
			
		for(int i=0;i<str.length();i++)
		{
			testString=testString+str.charAt(i);
			testString=testString+"#";
		}
		
        allRadius=new int[testString.length()];
		
		for(int i=1;i<testString.length();i++)
		{
			if(radius==1 || center+radius<i)
			{
				int left=i-1;
				int right=i+1;
				int localRadius=0;
				calcPalindromeAround(i,left,right,localRadius);
			}
			else
			{
				int mirrorIndex=(2*center)-i;
				int mirrorRadius=allRadius[mirrorIndex];
				int leftLimit=center-radius;
				if(mirrorIndex-allRadius[mirrorIndex]<leftLimit)
				{
					int rightLimit=center+radius;
					int localRadius=rightLimit-i;
					int left=i-localRadius-1;
					int right=i+localRadius+1;
					calcPalindromeAround(i, left, right, localRadius);
				}
				else
				{
					int left=i-mirrorRadius-1;
					int right=i+mirrorRadius+1;
					int localRadius=mirrorRadius;
					calcPalindromeAround(i, left, right, localRadius);
				}
				
			}
			
		
		}
		
		
//		System.out.println(testString);
//		System.out.println("Radius:"+radius);
//		System.out.println("Center:"+center);
		
		System.out.println(radius);
		}
	}
	
	
	private static void calcPalindromeAround(int i,int left,int right,int localRadius)
	{
		
		
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
		
		allRadius[i]=localRadius;
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
