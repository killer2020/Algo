import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
       
        Arrays.sort(numbers);
         
        result=(long)numbers[numbers.length-1]*(long)numbers[numbers.length-2];
      
        return result;
    }

    static long getMaxPairwiseProductOld(int[] numbers) {
    	long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
    
    
//    public static void main(String[] args) {
//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        System.out.println(getMaxPairwiseProduct(numbers));
//    }
    
    
    public static void main(String args[])
    {
    	while(true)
    	{
    		int n=((int) (Math.random()*10))+2;
    		System.out.println(n);
    		
    		int[] numbers=new int[n];
    		for(int i=0;i<n;i++)
    		{
    			numbers[i]=(int) (Math.random()*100000);
    		}
    		
    		String array="";
    		for(int i=0;i<n;i++)
    		{
    			 array=array+"  "+numbers[i];
    		}
    	   
    	   System.out.println(array);
    	   
    		long slow=getMaxPairwiseProductOld(numbers);
    		long fast=getMaxPairwiseProduct(numbers);
    		
    		if(slow!=fast)
    		{
    			System.out.println("Worng answer "+slow+"  "+fast);
    			break;
    		}
    		else
    		{
    			System.out.println("Ok");
    		}
    		
    	
    	}
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}