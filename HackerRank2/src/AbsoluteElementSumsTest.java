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
	
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		
		int initialSum=0;
		
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
        
        int divider=getDivider(0);
		
		//int queries=scanner.nextInt();
		
		int add=0;
		
		while(true)
		{
			int sum=initialSum;
			int next=(int) (Math.random()*10)-(int)(Math.random()*10);
			System.out.println(next);
			
			add=add+next;
		    
			if(add<0)
			{
				int index=getDivider(-add);
				
				if(index==arr.length)
					index--;
				if(divider==arr.length)
				    divider--;
				
				int left=divider*Math.abs(add);
				sum=sum+left;
				
				for(int j=divider;j<=index;j++)
				{
                   
					sum=sum-Math.abs(arr[j]);
					int addition=Math.abs(arr[j]+add);
					sum=sum+addition;
					
				}
				
				int right=(arr.length-index-1)*Math.abs(add);
				
				sum=sum-right;
				
			}
			else
			if(add>0)
			{
			 int index=getDivider(-add);
			 
			 if(index==arr.length)
					index--;
				if(divider==arr.length)
				    divider--;
			 
			 
			 int left=index*Math.abs(add);
			 sum=sum-left;
				
			 for(int j=index;j<=divider;j++)
				{
                
					sum=sum-Math.abs(arr[j]);
					int addition=Math.abs(arr[j]+add);
					sum=sum+addition;
					
				}	
			 
			 
			 int right=(arr.length-divider-1)*Math.abs(add);
			 sum=sum+right;
			}
			
				
			System.out.println("Sum:"+sum);
			int bruteResult=bruteresult(next);
			System.out.println("Brute:"+bruteResult);
			
			if(sum!=bruteResult)
			 return;
		}
		
		
		
	}
	
	


    static Integer[] arr2;
	
	private static int bruteresult(int next) {
		
		int sum=0;
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