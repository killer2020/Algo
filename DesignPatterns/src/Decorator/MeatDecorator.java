package Decorator;

public class MeatDecorator extends SandwichDecorator
{

	public MeatDecorator(Sandwich customSandwich)
	{
		super(customSandwich);
	}

	@Override
	public String make()
	{
		// TODO Auto-generated method stub
		return customSandwich.make()+ addMeat();
	}

	private String addMeat()
	{
		// TODO Auto-generated method stub
		return " +turkey";
	}

	
	
}
