import java.util.Scanner;

public class FibonacciLastDigit {
  private static long calc_fib(int n) {
   
   if(n<2)
	   return n;
   
   long arr[]=new long[n+1]; 
   arr[0]=0;
   arr[1]=1;
   
   
   for(int i=2;i<=n;i++)
   {
	   arr[i]=(arr[i-1]+arr[i-2])%10;
   }
   
    return arr[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
   // long start=System.currentTimeMillis();
    
    System.out.println(calc_fib(n));
    
   // long end=System.currentTimeMillis();
   // System.out.println("TIme:"+(end-start));
    
  }
}
