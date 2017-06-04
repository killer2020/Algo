package StatePattern;

public class NewState extends State
{
	
	private Trade trade;
	
	public NewState(Trade trade)
	{
		this.trade = trade;
	}



	@Override
	public void progress()
	{
		
		System.out.println("Trade moving to pending state");
		trade.setState(trade.getPendingState());
		
	}

}
