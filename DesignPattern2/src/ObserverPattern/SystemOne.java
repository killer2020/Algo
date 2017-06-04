package ObserverPattern;

public class SystemOne extends Observer
{

	Subject subject;
	
	public SystemOne(Subject subject)
	{
		this.subject = subject;
		subject.attach(this);
	}


	public void sendMessage(String message)
	{
		subject.setState("Message send by SystemOne:"+message);
	}
	
	@Override
	public void update()
	{
		System.out.println("Message recieved by SystemOne:"+subject.getState());
		
	}

	
	
}
