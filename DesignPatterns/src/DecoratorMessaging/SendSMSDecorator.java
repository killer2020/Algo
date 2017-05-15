package DecoratorMessaging;

public class SendSMSDecorator extends SendingDecorator
{

	public SendSMSDecorator(Message message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	public String send()
	{
		
		return message.send()+sendSMS();
		
	}



	private String sendSMS()
	{
		// TODO Auto-generated method stub
		return " + SMS sent "+getMessage();
	}



	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return message.getMessage();
	}
}
