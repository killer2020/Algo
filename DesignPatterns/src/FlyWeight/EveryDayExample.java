package FlyWeight;



public class EveryDayExample
{

	public static void main(String[] args)
	{
		
		
		Integer first=Integer.valueOf(5);
		
		Integer second=Integer.valueOf(5);
		
		
		Integer third=Integer.valueOf(10);
				
		sop(System.identityHashCode(first));
		
		sop(System.identityHashCode(second));
		
		sop(System.identityHashCode(third));
	

	}

	
	
	 static void sop(Object o)
	{
		System.out.println(o);
	}
}
