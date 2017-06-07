import java.util.Scanner;

public class Graph1
{
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(System.in);
    	
    	int count = scanner.nextInt();
    	
    	
    	int sizeOfComponent[]=new int[2*count+1];
    	int root[]=new int[2*count+1];
    	int max=1;
    	int min=50000;
    	
    	for(int j=0;j<(2*count+1);j++)
    	{	sizeOfComponent[j]=1;
    	    root[j]=j;
    	}
    	for(int i=0;i<count;i++)
    	{
    		
    			  int first=scanner.nextInt();
    			  int second=scanner.nextInt();
    			  
    			  //root[second]=first;
    			  
    			  int temp=root[first];
    			  
    			  int temp2=root[second];
    			  
    			  while(temp2!=root[temp2])
    			  {  
    				  root[temp2]=root[root[temp2]];
    				  temp2=root[temp2];
    			     
    			  }
    			  while(temp!=root[temp])
    			  {		  
    				  root[temp]=root[root[temp]];
    				  temp=root[temp];
    			  
    			  }
    			  
    			  if(temp!=temp2)
    			  {root[temp2]=temp;
    			  sizeOfComponent[temp]=sizeOfComponent[temp]+sizeOfComponent[temp2];
    			  }
    			
    		
    	}
    	
    	
    	for(int j=1;j<=2*count;j++)
    	{
    		if(root[j]==j && sizeOfComponent[j]!=1)
    		{
    			
    			if(sizeOfComponent[j]<min)
    				min=sizeOfComponent[j];
    			
    			if(sizeOfComponent[j]>max)
    				max=sizeOfComponent[j];
    		}
    	}
    	
    	System.out.println(min+" "+max);
    }
}
