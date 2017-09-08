import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RepKSums
{
	
	private static List<Long> sumList;
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner=new FastScanner();
		
		int numberOfTerms=scanner.nextInt();
		
		int k=scanner.nextInt();
		
		int noOfSumTerms=0;
		
       int arr[][]=new int[k][numberOfTerms];
       
       for(int i=0;i<numberOfTerms;i++)
       {
    	   arr[0][i]=1;
       }
       for(int i=0;i<k;i++)
       {
    	   arr[i][0]=1;
       }
       
       
       for(int i=1;i<k;i++)
       {
    	   
    	   for(int j=1;j<numberOfTerms;j++)
    		   arr[i][j]=arr[i-1][j]+arr[i][j-1];
    	   
       }
       
       
       for(int i=0;i<numberOfTerms;i++)
    	   noOfSumTerms=noOfSumTerms+arr[k-1][i];
       
       System.out.println("No. Of Terms:"+noOfSumTerms);
       
       
       sumList=new ArrayList<Long>();
       long sumOfN=0;
       
       for(int i=0;i<noOfSumTerms;i++)
       {
    	   
    	   long next=scanner.nextInt();
    	   sumList.add(next);
    	   
    	   sumOfN=sumOfN+next;
    	   
       }
       
       Collections.sort(sumList);

       sumOfN=(sumOfN*numberOfTerms)/(noOfSumTerms*k);
       
       System.out.println("Sum Of Terms:"+sumOfN);
       
       findAndDeleteKSums(numberOfTerms,k);
       
       
       System.out.println(elements);
	}
	
	private static List<Long> elements=new ArrayList<Long>();
	
	
	
	private static void findAndDeleteKSums(int n,int k)
	{
		long firstSum=sumList.get(0);
		sumList.remove(0);
		
		long firstElement=firstSum/k;
		elements.add(firstElement);
		
		while(!sumList.isEmpty())
		{long nextSum=sumList.get(0);
		 sumList.remove(0);
		
		 long nextElement=nextSum-(firstElement*(k-1));
		 elements.add(nextElement);
		 
		
		 createKSums(nextElement,k-1,0);
		}
		
	}
	
	private static void removeElement(long element)
	{
		
		sumList.remove(element);
		
	}

	
	private static void createKSums(long firstElement,int k,int start)
	{
		if(k==0)
		{	removeElement(firstElement);
		    return;
		}
		for(int i=start;i<(elements.size());i++)
		{
			long nextElement=firstElement+elements.get(i);
			createKSums(nextElement,k-1,i);
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
