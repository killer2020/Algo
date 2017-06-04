package ObserverPattern;

public class SystemTwo extends Observer
{

	Subject subject;
	
	public SystemTwo(Subject subject)
	{
		this.subject = subject;
		subject.attach(this);
	}


	public void sendMessage(String message)
	{
		subject.setState("Message send by SystemTwo:"+message);
	}
	
	@Override
	public void update()
	{
		System.out.println("Message recieved by SystemTwo:"+subject.getState());
		
	}

	
	
}
