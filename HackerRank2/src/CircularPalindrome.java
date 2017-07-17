import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CircularPalindrome
{

	private static String testString="#";
	private static int[] allRadius;
	private static int center=0;
	private static int radius=0;
	private static char[] charArr;
	
	private static int start;
	private static int end;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		int len=scanner.nextInt();
		String str=scanner.next();
		
		
			testString="#";
			center=0;
			radius=0;
			
		start=0;
		end=0;
		for(int i=0;i<str.length();i++)
		{
			testString=testString+str.charAt(i);
			testString=testString+"#";
		}
		end=testString.length();
		for(int i=0;i<str.length()-1;i++)
		{
			testString=testString+str.charAt(i);
			testString=testString+"#";
		}
		
		charArr=testString.toCharArray();
		
		allRadius=new int[charArr.length];
		for(int j=0;j<len;j++)
        {
		
		for(int i=start+1;i<end;i++)
		{
			
			if(allRadius[i]>0 && i-allRadius[i]<start)
			{
				allRadius[i]=i-start;
				if(allRadius[i]>radius)
				{
					radius=allRadius[i];
					center=i;
				}
			}
			else if(allRadius[i]>0)
			{
				int left=i-allRadius[i]-1;
				int right=i+allRadius[i]+1;
				int localRadius=allRadius[i];
				calcPalindromeAround(i,left,right,localRadius);
			}
			else
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
		testString="#";
		center=(j+1)*2;
		radius=0;
		
	    start=start+2;
	    end=end+2;
        }	
		
	}
	
	
	private static void calcPalindromeAround(int i,int left,int right,int localRadius)
	{
		
		
		while((left>=start && right<end) && charArr[left]==charArr[right])
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