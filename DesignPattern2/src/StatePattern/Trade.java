package StatePattern;

public class Trade
{

	private State newState;
	private State pendingState;
	private State settledState;
	private State state;
	
	private State verifiedState;
	
	public Trade()
	{
		
		newState=new NewState(this);
		pendingState=new PendingState(this);
		verifiedState=new VerifiedState(this);
		settledState=new SettledState(this);
		
		state=newState;
	}
	
	
	
	public void progressTrade()
	{
		state.progress();
	}
	
	
	@Override
	public String toString()
	{
		return "Trade [state=" + state + "]";
	}



	public State getNewState()
	{
		return newState;
	}


	public State getPendingState()
	{
		return pendingState;
	}
	
	public State getSettledState()
	{
		return settledState;
	}
	public State getVerifiedState()
	{
		return verifiedState;
	}
	
	public void setState(State state)
	{
		this.state = state;
	}
	
}
