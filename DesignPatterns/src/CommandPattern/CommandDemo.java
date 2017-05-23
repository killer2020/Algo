package CommandPattern;

import java.util.ArrayList;

public class CommandDemo
{

	public static void main(String args[])
	{
		
		Appliance bedroomlight=new Light("Bedroom");
		Appliance kitchenLight=new Light("Kitchen");
		Appliance hallLight=new Light("Hall");
		
		ArrayList<Appliance> appliances=new ArrayList<Appliance>();
		appliances.add(bedroomlight);
		appliances.add(kitchenLight);
		appliances.add(hallLight);
		
		Command toggleAll=new ToggleAllCommand(appliances);
		
		Command toggleCommand=new ToggleCommand(bedroomlight);
		
		
		Switch lightSwitch=new Switch();
		
		//lightSwitch.execute(toggleCommand);
		
		lightSwitch.execute(toggleAll);
		lightSwitch.execute(toggleAll);
		lightSwitch.execute(toggleAll);
		
	}
	
	
}
