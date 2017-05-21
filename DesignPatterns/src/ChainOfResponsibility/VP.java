package ChainOfResponsibility;

public class VP extends Handler
{

	@Override
	public void handle(Request request)
	{
		if(request.getRequestType()==RequestType.PURCHASE)
		{
			if(request.getAmount()<1500)
			{
				System.out.println("VP approved request below 1500");
			}
			else
			{
				sucessor.handle(request);
			}
			
		}
		

	}

}
