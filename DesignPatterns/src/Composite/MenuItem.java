package Composite;

public class MenuItem extends MenuComponent
{

	public MenuItem(String name, String url)
	{
		this.name=name;
		this.url=url;
	}

	

	@Override
	public String toString()
	{
		return print(this);
	}



	@Override
	public MenuComponent add(MenuComponent menuComponent)
	{
		throw new UnsupportedOperationException("Not Implemented");
	}



	@Override
	public MenuComponent remove(MenuComponent menuComponent)
	{
		throw new UnsupportedOperationException("Not Implemented");
	}

}
