package CommandPattern;

public class EveryDayExample
{

	public static void main(String args[])
	{
		
		Thread thread1=new Thread(new Task(2,4));
		
		
		thread1.start();
		
		
		
		
		
	}
	
	
}


class Task implements Runnable
{

	int num1;
	int num2;
	
	Task(int num1,int num2)
	{
		
		this.num1=num1;
		this.num2=num2;
	}
	
	
	@Override
	public void run()
	{
		System.out.println(num1*num2);
		
	}
	
}
