import java.util.*;

public class LCM_Stress {
  private static long lcm(int a, int b) {
    
	  long product= (long)a*(long)b;
    
    return product/gcd(a,b);
  }
  
  private static int gcd(int a, int b) {
	    
		int big=a,less=b;  
		  
		if(b>a)
		{big=b;
		 less=a;
		}
		  
		while(less!=0)  
		{
			int temp=less;
			less=big%less;
			big=temp;
		}

	    return big;
	  }
  

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

  
 long start=System.currentTimeMillis();
    
    System.out.println(lcm(a, b));
  
  long end=System.currentTimeMillis();
  System.out.println("TIme:"+(end-start));
    
    
    
  }
}
