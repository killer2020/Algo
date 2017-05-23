package CommandPattern;

public class ToggleCommand implements Command
{

	private Appliance appliance;
	
	
	
	public ToggleCommand(Appliance appliance)
	{
		this.appliance = appliance;
	}



	@Override
	public void execute()
	{
		appliance.toggle();
		
	}

}
