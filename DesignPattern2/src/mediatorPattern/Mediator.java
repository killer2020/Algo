package mediatorPattern;

import java.util.ArrayList;

public class Mediator
{

	ArrayList<Light> lights=new ArrayList<Light>();
	
	
	public void registerLight(Light light)
	{
		
		lights.add(light);
	}
	
	
	public void switchOnAll()
	{
		
		for(Light light:lights)
        		light.switchOn();
	}
	
	
	public void switchOffAll()
	{
		for(Light light:lights)
			light.switchOff();
		
	}
	
}
