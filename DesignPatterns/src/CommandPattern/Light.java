package CommandPattern;

public class Light implements Appliance
{

	boolean isOn=false;
	String identifier;
	
	public Light(String identifier)
	{
		this.identifier=identifier;
	}
	
	@Override
	public void toggle()
	{
		if(isOn)
			off();
		else
			on();
		
	}

	@Override
	public void on()
	{
		System.out.println(identifier+" Light switched is on.");
		isOn=true;
		
	}

	@Override
	public void off()
	{
		System.out.println(identifier+" Light switched is off.");
		isOn=false;
		
	}

}
