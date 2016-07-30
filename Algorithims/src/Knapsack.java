import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
      
        int n=w.length;
        
        int[][] arr=new int[W+1][n+1];
        
//        for(int i=0;i<=W;i++)
//        	arr[i][0]=0;
//        
//        for(int j=0;j<=n;j++)
//        	arr[0][j]=0;
//        
        
        for(int w1:w)
         result=result+w1;
        if(result<=W)
        	return result;
        
        result=0;
        for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=W;j++)
        	{

        		int max=arr[j][i-1];
        		
        			if(j-w[i-1]>=0 && arr[j-w[i-1]][i-1]+w[i-1]>max)
        			{
        				max=arr[j-w[i-1]][i-1]+w[i-1];
        				
        			}
        		
        		
        		arr[j][i]=max;
        	}
        	
        	
        }
        
        
     
        
        return arr[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

