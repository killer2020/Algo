package DecoratorMessaging;

public abstract class SendingDecorator implements Message
{

	Message message;
	
	String msg;

	public SendingDecorator(Message message)
	{
		this.message = message;
	}
	
	
	public String send()
	{
		return message.send();
	}
	
}
