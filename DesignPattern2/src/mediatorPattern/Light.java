package mediatorPattern;

public class Light
{

	String lightName;
    boolean isOn=false;
	
	public Light(String lightName)
	{
		this.lightName = lightName;
	}
	

	public void switchOn()
	{
		
		System.out.println(lightName+":switched on");
		isOn=true;
	}
	
	
	public void switchOff()
	{
		System.out.println(lightName+":switched off");
		isOn=false;
	}
	
	public void toggle()
	{
		if(isOn)
			switchOff();
		else
			switchOn();
	}
	
	
	
}
