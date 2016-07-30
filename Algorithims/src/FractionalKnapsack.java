import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        
       TreeMap<Double,Integer> avgValue= new TreeMap<Double,Integer>(Collections.reverseOrder());       

       for(int i=0;i<values.length;i++)
       {
    	  
    	   double average=(double)values[i]/(double)weights[i];
    	   if(avgValue.containsKey(average))
    	   {
    		   avgValue.put(average, weights[i]+avgValue.remove(average));
    		   
    	   }
    	   else
    	   avgValue.put(average,weights[i]);
    	   
       }
    	   
       int filled=0;
       while(filled<capacity && avgValue.firstEntry()!=null)
       {
    	   
    	   double key=avgValue.firstKey();
    	   int weight=avgValue.get(key);
    	   
    	   if(filled+weight<=capacity)
    	   {   filled=filled+weight;
    	       value=value+weight*key;
    	   }
    	   else
    	   { 
    		   value=value+key*(capacity-filled);
    		   filled=capacity;
    	    
    	   }
    	   
    	   
    	   avgValue.remove(key);
    	   
       }
       
          
       
    	 return value;
    }

    
   
    
    
    
    
    public static void main(String args[]) {
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) 
        {
           values[i] = scanner.nextInt();
           weights[i] = scanner.nextInt();
         }
    
   
        System.out.println(getOptimalValue(capacity, values, weights));
        
        
        
    }
} 
