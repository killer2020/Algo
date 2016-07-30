import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        //write your code here
    	//arrange array in ascending order and cross multiply them
    	//matrix
    	// ab
    	// cd
    	// will have ac+bd>ad+bc  when a<b,c<d and so on...
        long result = 0;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        ArrayDeque<Integer> first=new ArrayDeque<Integer>();
        ArrayDeque<Integer> second=new ArrayDeque<Integer>();
       
        for(int i=0;i<b.length;i++)
        {	
        	first.push(a[i]);
        	second.push(b[i]);
        
        }
        
        for (int i = 0; i < a.length; i++) {
        {
        	
        	result=result+(long)first.pollFirst()*(long)second.pollLast();
        	
        }
        
        }
		return result;
    }
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}

