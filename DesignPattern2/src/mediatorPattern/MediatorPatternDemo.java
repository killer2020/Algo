package mediatorPattern;

public class MediatorPatternDemo
{

	public static void main(String args[])
	{
		
		Light bedRoomLight=new Light("bedroom");
		Light hallLight=new Light("hall");
		
		
		Mediator med=new Mediator();
		med.registerLight(bedRoomLight);
		med.registerLight(hallLight);
		
		
		AllLightsSwitchOnCommand on=new AllLightsSwitchOnCommand(med);
		AllLightSwitchOffCommand off=new AllLightSwitchOffCommand(med);
		
		on.execute();
		off.execute();
		
		
		
	}
	
	
	
	
}
