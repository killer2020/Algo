package DecoratorMessaging;

public class SimpleMessage implements Message
{

	String message;
	
	public SimpleMessage(String message)
	{
		this.message = message;
	}
	
	
	@Override
	public String send()
	{
		
		return "Email sent:"+message;
	}


	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return message;
	}



}
