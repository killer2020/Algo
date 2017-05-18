package Singleton;

public class EverydayExample
{

	public static void main(String args[])
	{
		
		Runtime singletonRunTime=Runtime.getRuntime();
		
		singletonRunTime.gc();
		
		System.out.println(singletonRunTime);
		
		
		Runtime anotherInstance=Runtime.getRuntime();
		
		
		System.out.println(anotherInstance);
		
		if(singletonRunTime==anotherInstance)
		{
			System.out.println("same instance");
		}
	}
	
	
}
