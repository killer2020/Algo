import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        
        int sum=0;
        int numberToAdd=1;
        
        while(sum!=n)
        {
        	
        	if(sum+numberToAdd<=n)
        	{
        		
        		summands.add(numberToAdd);
        		sum=sum+numberToAdd;
        		numberToAdd++;
        		
        	}
        	else
        	{
        		numberToAdd=summands.get(summands.size()-1)+(n-sum);
        		summands.remove(summands.size()-1);
        		summands.add(numberToAdd);
        		sum=n;
        		
        	}
        	
        	
        }
        
        
        
        
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

