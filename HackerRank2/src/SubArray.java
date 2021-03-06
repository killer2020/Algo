import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SubArray
{

	private static class Node implements Comparable<Node>
	{
		
		long data;
		boolean isReduntant=false;
		
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
		
		
		int queries=scanner.nextInt();
		
		for(int i=0;i<queries;i++)
		{
			
			int size=scanner.nextInt();
			long mod=scanner.nextLong();
			
			long max=0;
			
			
			
		    long[] arr=new long[size];
			
		    Node[] prefixSum=new Node[size];
		    
		    
			for(int j=0;j<size;j++)
			{
				
			   arr[j]=scanner.nextLong()%mod;	
				
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
			
			
			long maxInSegment=sortedData.get(arr.length-1).data;
			
			if(maxInSegment>max)
				max=maxInSegment;
			
			
			for(int index=1;index<sortedData.size();index++)
			{
				
				long toSubtract=prefixSum[index].data;
				
				long maxAvailaible=getMax(sortedData);
				
				maxInSegment=subtractWithMod(maxAvailaible,toSubtract,mod);
				
				prefixSum[index].isReduntant=true;
				
				if(maxInSegment>max)
					max=maxInSegment;
			}
			
			
			System.out.println(max);
		}
		
		
		
		
	}


	
	
	
	
	
	

	private static long subtractWithMod(long maxAvailaible, long toSubtract, long mod)
	{
		if(maxAvailaible>=toSubtract)
			return maxAvailaible-toSubtract;
		
		
		
		return mod-(toSubtract-maxAvailaible);
	}









	private static long getMax(ArrayList<Node> sortedData)
	{
		for(int i=sortedData.size()-1;i>0;i--)
		{
			if(!sortedData.get(i).isReduntant)
				return sortedData.get(i).data;
		}
		
		return 0;
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