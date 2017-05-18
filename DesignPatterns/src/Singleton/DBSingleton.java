package Singleton;

public class DBSingleton
{

	
	private static DBSingleton instance=null;   //loading
	
	
	private DBSingleton()
	{
		
	}
	
	public static DBSingleton getInstance()
	{
		
		if(instance==null)
		{
		
			synchronized (DBSingleton.class)   //thread safe
			{
				if(instance==null)
				instance=new DBSingleton();
			}
			
			    //lazy loading
		
			
		}	
		return instance;
	}
	
}
