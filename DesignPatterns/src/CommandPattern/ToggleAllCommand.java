package CommandPattern;

import java.util.ArrayList;

public class ToggleAllCommand implements Command
{
	
	ArrayList<Appliance> appliances=new ArrayList<Appliance>();

	public ToggleAllCommand(ArrayList<Appliance> appliances)
	{
		this.appliances = appliances;
	}

	@Override
	public void execute()
	{
		
		for(Appliance appliance:appliances)
			appliance.toggle();
		
		
	}

}
