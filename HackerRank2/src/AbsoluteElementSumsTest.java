import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class AbsoluteElementSumsTest
{


	static Integer[] arr;
	static long[] back;
	static long[] forward;
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		long initialSum=0;
		
		int count=scanner.nextInt();
		
		List<Integer> elements=new ArrayList<Integer>();
		
		for(int i=0;i<count;i++)
		{
			int next=scanner.nextInt();
			elements.add(next);
			
			initialSum=initialSum+Math.abs(next);
		}
		
        Collections.sort(elements);
        
		
         arr= elements.toArray(new Integer[elements.size()]);
         arr2=elements.toArray(new Integer[elements.size()]);
        
 
         back=new long[arr.length];
         forward=new long[arr.length];
         
         back[0]=arr[0];
         for(int i=1;i<arr.length;i++)
         {
        	 back[i]=back[i-1]+arr[i];
        	 
         }
         
         forward[arr.length-1]=arr[arr.length-1];
         
         for(int i=arr.length-2;i>=0;i--)
         {
        	 
        	 forward[i]=forward[i+1]+arr[i];
        	 
         }
		
		//int queries=scanner.nextInt();
		
		int add=0;
		
		while(true)
		{
			long sum=0;
			int next=(int) (Math.random()*100)-(int) (Math.random()*100);
			add=add+next;
		    
			if(add<0)
			{
				
				Integer index=getDivider(-add);
				
				
				if(index==arr.length)
					index--;

				
				if(index>0)
				{
					long backSum=back[index-1];
					backSum=Math.abs(backSum+(index*add));
					sum=sum+backSum;
				}
				
				
					sum=sum+Math.abs(arr[index]+add);
				
					if(index!=arr.length-1)
					{
				      sum=sum+Math.abs(forward[index+1]+(add*(arr.length-index-1)));		
					}
				
				
			}
			else
			if(add>0)
			{
               Integer index=getDivider(-add);
				
				
			 if(index==arr.length)
					index--;

			 
			 
				if(index>0)
				{
					long backSum=back[index-1];
					backSum=Math.abs(backSum+(index*add));
					sum=sum+backSum;
				}
				
				
					sum=sum+Math.abs(arr[index]+add);
				
					if(index!=arr.length-1)
					{
				      sum=sum+Math.abs(forward[index+1]+(add*(arr.length-index-1)));		
					}
			
			}
			else if(add==0)
				sum=initialSum;
			
			//System.out.println("add"+add);	
			System.out.println("Sum:"+sum);
			long bruteResult=bruteresult(next);
			System.out.println("Brute:"+bruteResult);
			
			if(sum!=bruteResult)
			 return;
		}
		
		
		
	}
	
	


    static Integer[] arr2;
	
	private static long bruteresult(int next) {
		
		long sum=0;
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i]=arr2[i]+next;
			sum=sum+Math.abs(arr2[i]);
		}
		
		return sum;
	}





	private static int getDivider(int element)
	{
		
		int i=binarySearch(element,0,arr.length-1);
		return i;
	}





	private static int binarySearch(int element,int start,int end)
	{
		
		
		if(start==end || start>end)
		{
			if(arr[start]==element)
				return start;
			if(arr[start]>element)
				return start;
			if(arr[start]<element)
				return start+1;
			
		}
		
		
		int mid=(start+end)/2;
		
		
		if(arr[mid]==element)
			return mid;
		if(arr[mid]<element)
			return binarySearch(element,mid+1, end);
		if(arr[mid]>element)
			return binarySearch(element,start,mid-1);
		
		return 0;
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