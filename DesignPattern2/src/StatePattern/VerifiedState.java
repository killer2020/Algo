package StatePattern;

public class VerifiedState extends State
{
	
	private Trade trade;
	
	public VerifiedState(Trade trade)
	{
		this.trade = trade;
	}



	@Override
	public void progress()
	{
		
		System.out.println("Trade moving to settled state");
		trade.setState(trade.getSettledState());
		
	}

}
