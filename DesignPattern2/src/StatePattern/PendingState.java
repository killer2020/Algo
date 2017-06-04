package StatePattern;

public class PendingState extends State
{
	
	private Trade trade;
	
	public PendingState(Trade trade)
	{
		this.trade = trade;
	}



	@Override
	public void progress()
	{
		
		System.out.println("Trade moving to Verified state");
		trade.setState(trade.getVerifiedState());
		
	}

}
