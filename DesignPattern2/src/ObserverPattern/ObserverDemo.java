package ObserverPattern;

public class ObserverDemo
{
	public static void main(String args[])
	{
	Subject subject=new MiddleWare();
	
	SystemOne sysOne=new SystemOne(subject);
	
	SystemTwo sysTwo=new SystemTwo(subject);
	
	sysOne.sendMessage("prices fetched");
	
	sysTwo.sendMessage("prices recieved");
	
	
	}
}
