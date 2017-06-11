import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AbsoluteElementSums
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
        
        
        int divider=getDivider(0);
		
		int queries=scanner.nextInt();
		
		for(int i=0;i<queries;i++)
		{
			
			System.out.println(getDivider(scanner.nextInt()));
			
			
		}
		
		
		
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
