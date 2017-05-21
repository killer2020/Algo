package ChainOfResponsibility;

public class CEO extends Handler
{

	@Override
	public void handle(Request request)
	{
		System.out.println("CEO approved");

	}

}
