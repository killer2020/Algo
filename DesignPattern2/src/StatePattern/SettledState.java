package StatePattern;

public class SettledState extends State
{
	
	private Trade trade;
	
	public SettledState(Trade trade)
	{
		this.trade = trade;
	}



	@Override
	public void progress()
	{
		
		System.out.println("Trade already settled");
		
	}

}
