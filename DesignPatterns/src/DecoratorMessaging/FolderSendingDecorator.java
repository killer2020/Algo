package DecoratorMessaging;

public class FolderSendingDecorator extends SendingDecorator
{

	public FolderSendingDecorator(Message message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	public String send()
	{
		return message.send()+sendToFolder();
	}


	private String sendToFolder()
	{
		return " + Sent to folder "+getMessage();
	}


	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return message.getMessage();
	}
	
}
