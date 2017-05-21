package ChainOfResponsibility;

public class Director extends Handler
{

	@Override
	public void handle(Request request)
	{
		if(request.getRequestType() == RequestType.CONFERENCE)
		{
			System.out.println("Directors can handle conferences");
		}
		
		else
		{
			sucessor.handle(request);
		}
	}

}
