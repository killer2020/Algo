import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSeqTest
{

	private static int[] max;
	private static int[] data;
	private static int answer=0;
	private static boolean[] calculated;
	private static int[] maxIndex;
	private static int[] sequence;

	public static void main(String args[]) throws Exception
	{

		FastScanner scanner = new FastScanner();

		
		while(true)
		{int count = (int) (Math.random()*100)+1;

		data=new int[count];
		
		max=new int[count];
		
		maxIndex=new int[count];
		
		sequence=new int[count];
		
		calculated=new boolean[count];
		
		String str="";
		
		for (int i = 0; i < count; i++)
		{
              
			data[i]=(int) (Math.random()*100)+1;
			str=str+data[i]+" ";
			
		}

		
		
		
		
		System.out.println(str);
		
		answer=0;
		calc(0,count);
		
		System.out.println("Old:"+answer);
		
		
		
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
		
		
		System.out.println("New:"+(end+1));
		
		
		if((end+1)!=answer)
			return;
		
		}
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

	
	
	private static int calc(int index,int count)
	{
		max[index]=1;
		
		for(int i=index+1;i<count;i++)
		{
			
			
				if(calculated[i])
				{
					if(data[index]<data[i])
					if(1+max[i]>max[index])
						max[index]=1+max[i];
				}
				else
				{
					int tempCalc=calc(i,count);
					max[i]=tempCalc;
					calculated[i]=true;
					if(data[index]<data[i])
					if(1+tempCalc>max[index])
						max[index]=1+tempCalc;
				}
			
			
		}
		
		if(max[index]>answer)
			answer=max[index];
		
		return max[index];
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
