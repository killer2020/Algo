package mediatorPattern;

public class AllLightsSwitchOnCommand extends Command
{
	
	Mediator med;
	

	public AllLightsSwitchOnCommand(Mediator med)
	{
		this.med = med;
	}


	@Override
	public void execute()
	{
		med.switchOnAll();

	}

}
