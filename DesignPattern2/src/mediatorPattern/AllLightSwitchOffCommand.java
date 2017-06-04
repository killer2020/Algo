package mediatorPattern;

public class AllLightSwitchOffCommand extends Command
{

	Mediator med;
	
	
	public AllLightSwitchOffCommand(Mediator med)
	{
		this.med = med;
	}


	@Override
	public void execute()
	{
       med.switchOffAll();		
	}

	
	
}
