package Singleton;

public class DBSIngletonDemo
{

	public static void main(String[] args)
	{
		
		DBSingleton instance=DBSingleton.getInstance();
		
		System.out.println(instance);
		
		DBSingleton secondInstance=DBSingleton.getInstance();
		
		System.out.println(secondInstance);

	}

}
