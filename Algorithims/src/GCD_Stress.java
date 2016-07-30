import java.util.*;

public class GCD_Stress {
  private static int gcdFast(int a, int b) {
    
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

  
  private static int gcdSlow(int a, int b) {
	    int current_gcd = 1;
	    for(int d = 2; d <= a && d <= b; ++d) {
	      if (a % d == 0 && b % d == 0) {
	        if (d > current_gcd) {
	          current_gcd = d;
	        }
	      }
	    }

	    return current_gcd;
	  }
  
  
  public static void main(String args[]) {
   

   while(true)
   { 
	    int a = (int) (Math.random()*100000000)+1;
	    int b = (int) (Math.random()*100000000)+1;	   
        int gcdSlow=gcdSlow(a, b);
        int gcdFast=gcdFast(a, b);
    
        
        System.out.println("a:"+a+",b:"+b);
        
        if(gcdSlow==gcdFast)
        { 	System.out.println("OK");
        }
        else
        {
        	
        	System.out.println("Error: gcdSlow:"+gcdSlow+",gcdFast:"+gcdFast);
        	break;
        }
        
   
   }
  }
}
