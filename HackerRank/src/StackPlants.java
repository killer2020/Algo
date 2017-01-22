import java.util.ArrayList;
import java.util.Scanner;


public class StackPlants {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
    	
    	int count = scanner.nextInt();
    	int numbers[]=new int[count];
    	int day[]=new int[count];
    	int infinite=count+100;
    	
    	for(int i=0;i<count;i++)
    	{
    		int number=scanner.nextInt();
    		numbers[i]=number;
    		day[i]=infinite;
    	}
    
    	int answer=0;
    	
    	// System.out.println(infinite);
      for(int j=1;j<count;j++)
      {
    	  int maxDay=dayThisWillDie(j,numbers,day);
    	 
    	  day[j]=maxDay;
    //	  System.out.println(maxDay);
    	  if(maxDay>answer && maxDay!=infinite)
    		  answer=maxDay;
      }
    	
    	System.out.println(answer);
    	
    	
    }

	private static int dayThisWillDie(int nodeNumber,int[] numbers, int[] day)
	{
		if(numbers[nodeNumber]>numbers[nodeNumber-1])
			return 1;
		else
		{
			int prob=day[nodeNumber-1];
			int checkNumber=nodeNumber-1;
			int start=nodeNumber-1;
			
			while(checkNumber>0)
			{
				checkNumber=getCheckNumber(prob,day,start);
			    if(numbers[nodeNumber]>numbers[checkNumber])
			    	return prob+1;
			    else
			    {	prob=day[checkNumber];
			        start=checkNumber;
			    }
			
			}
		}
		
		
		return day[nodeNumber];
	}

	private static int getCheckNumber(int prob, int[] day, int i)
	{
		for(int j=i-1;j>=0;j--)
		{
			if(day[j]>prob)
				return j;
				
		}
			
		return 0;
	}
}