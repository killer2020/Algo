import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
       
    	return 0;
    }

   
    
    private static ArrayList<Long> fibo(int n ) {
    	   
    	   
    	   
    	   
    	   ArrayList<Long> fibo=new ArrayList<Long>();
    	   fibo.add((long) 0);
    	   fibo.add((long) 1);
    	   
    	   int length=2;
    	   
    	   ArrayList<Long> mod=new ArrayList<Long>();
    	   mod.add((long) 0);
    	   mod.add((long) 1);
    	   
    	   while(true)
    	   {
    	   fibo.add(fibo.get(length-1)+fibo.get(length-2));
    	   length++;
    	   mod.add((fibo.get(length-1)%n));
    	   if(mod.get(length-1)==1 && mod.get(length-2)==0)
    		   break;
    	   
    	   System.out.println(mod.get(length-1));
    	   }
    	   
    	   mod.remove(length-1);
    	   mod.remove(length-2);
    	   
    	   return mod;
    	
    	  }
    
    public static void main(String[] args) {
     
    	Scanner scanner = new Scanner(System.in);
//        long n = scanner.nextLong();
//        long m = scanner.nextLong();
//        System.out.println(getFibonacciHuge(n, m));
        
        System.out.println(fibo(30524));
       
    }
}

