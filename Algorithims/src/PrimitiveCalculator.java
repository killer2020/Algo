import java.util.*;

public class PrimitiveCalculator {
   
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        List<Integer> parent = new ArrayList<Integer>();
        List<Integer> operations=new ArrayList<Integer>();
        operations.add(0);
        operations.add(0);
        
        parent.add(0);
        parent.add(0);
        
        for(int i=2;i<=n;i++)
        {
        	int operationRequired=operations.get(i-1)+1;
        	parent.add(i-1);
        	int temp;
        	
        	
        	if(i%3==0)
        	{
        		temp=operations.get(i/3)+1;
        		if(temp<operationRequired)
        		{operationRequired=temp;
        		parent.remove(parent.size()-1);
        		parent.add(i/3);
        		}
        	}
        	
        	if(i%2==0)
        	{
        		temp=operations.get(i/2)+1;
        		if(temp<operationRequired)
        		{operationRequired=temp;
        		parent.remove(parent.size()-1);
        		parent.add(i/2);
        		}
        	}
        	
        	
        	operations.add(operationRequired);	
        	
        	
        }
        
        int value=n;
        sequence.add(value);
        
        while(value!=1)
        {
        	sequence.add(parent.get(value));
        	value=parent.get(value);
        }
       
        Collections.reverse(sequence);
        
        return sequence;
    }
    
    
   

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

