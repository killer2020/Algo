package DecoratorMessaging;

public class MessageSendingDemo
{

	public static void main(String[] args)
	{
		Message message=new SendSMSDecorator(new FolderSendingDecorator(new SimpleMessage("Alert 2")));

		
		System.out.println(message.send());
		
		
		
		Message message2=new FolderSendingDecorator(new SendSMSDecorator(new SimpleMessage("Alert 3")));
		
		System.out.println(message2.send());
	}

}
