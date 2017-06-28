import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSeq
{

	private static int[] data;
	private static int[] sequence;

	public static void main(String args[]) throws Exception
	{

		FastScanner scanner = new FastScanner();

		int count = scanner.nextInt();

		data=new int[count];
		sequence=new int[count];
		
		
		
		for (int i = 0; i < count; i++)
		{
              
			data[i]=scanner.nextInt();
			
			
		}

		int end=0;
		sequence[0]=data[0];
		
		for(int i=1;i<count;i++)
		{
			if(data[i]>sequence[end])
			{
			   sequence[end+1]=data[i];
			   end=end+1;
			}
			else
			{
			   int findNumberToReplace=binarySearch(data[i],0,end);
			   sequence[findNumberToReplace]=data[i];
			}
		}
		
		
		System.out.println(end+1);
	}

	
	private static int binarySearch(int number,int start,int end)
	{
		
		
		if(start==end || start>end)
		{
			if(sequence[start]==number)
				return start;
			if(sequence[start]>number)
				return start;
			if(sequence[start]<number)
				return start+1;
			
		}
		
		
		int mid=(start+end)/2;
		
		
		if(sequence[mid]==number)
			return mid;
		if(sequence[mid]<number)
			return binarySearch(number,mid+1, end);
		if(sequence[mid]>number)
			return binarySearch(number,start,mid-1);
		
		return 0;
	}

	
	
	private static class FastScanner
	{
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner()
		{
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens())
			{
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}
	}
}
