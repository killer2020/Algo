import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SubArrayTest
{

	private static class Node implements Comparable<Node>
	{
		
		long data;
		
		public Node(long data)
		{
			this.data=data;
		}

		

		@Override
		public int compareTo(Node o) {
			if(o.data==this.data)
				return 0;
			return o.data>this.data?-1:1;
		}
		
		
	}
	
	
	
	private static ArrayList<Node> sortedData;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		
		//int queries=scanner.nextInt();
		
		while(true)
		{
			
			int size=(int)( Math.random()*1000)+1;
			long mod=(long) (Math.random()*100)+1;
			
			long max=0;
			
			
			
		    long[] arr=new long[size];
			
		    Node[] prefixSum=new Node[size];
		    
		    String str="";
			for(int j=0;j<size;j++)
			{
				
			   arr[j]=((long) (Math.random()*100)+1)%mod;
			   str=str+arr[j]+" ";
				
			}
			
			prefixSum[0]=new Node(arr[0]);
			
			for(int j=1;j<size;j++)
			{
				prefixSum[j]=new Node(arr[j]+prefixSum[j-1].data);
			}
			for(int j=0;j<size;j++)
			{
				prefixSum[j].data=prefixSum[j].data%mod;
			}
			
			
			
			sortedData=new ArrayList<Node>(Arrays.asList(prefixSum)); 
			
			
			Collections.sort(sortedData);
			
            long required=mod-1;
			
			long maxInSegment=findNumberlessThan(required,0,arr.length-1);
			
			if(maxInSegment>max)
				max=maxInSegment;
			
			
			long bruteResult=calcBrute(arr,mod);
			
			System.out.println(str);
			System.out.println("Mod:"+mod);
			
			System.out.println("Max:"+max);
			System.out.println("Brute:"+bruteResult);
			
			System.out.println();
			System.out.println();
			
			if(max!=bruteResult)
				return;
			
		}
		
		
		
		
	}


	
	
	
	
	
	

	private static long calcBrute(long[] arr,long mod) {
		
		
		long max=0;
		
		for(int i=0;i<arr.length;i++)
		{
			long sum=0;
			for(int j=0;j<=i;j++)
			{
				sum=sum+arr[j];
			}
			
			sum=sum%mod;
			
			if(sum>max)
				max=sum;
		}
		
		
		return max;
	}









	private static long findNumberlessThan(Long data,int start,int end)
	{
		int mid=(start+end)/2;
		
		if(sortedData.get(mid).data==data)
		{
			return sortedData.get(mid).data;
		}
		
		if(start>=end)
		{
			    if(start==0 && sortedData.get(mid).data>data)
			    	return 0;

			    if(sortedData.get(mid).data>data)
			    	return sortedData.get(mid-1).data;
			    
			    return sortedData.get(mid).data;
			
		}
		
		
		if(sortedData.get(mid).data>data)
			return findNumberlessThan(data,start,mid-1);
		else
			return findNumberlessThan(data,mid+1,end);
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