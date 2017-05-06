package Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent
{
	
	
	String name;
	String url;
	List<MenuComponent> menuComponents=new ArrayList<MenuComponent>();
	
	
	
	public String getName()
	{
		return name;
	}



	public String getUrl()
	{
		return url;
	}



	public List<MenuComponent> getMenuComponents()
	{
		return menuComponents;
	}


    public abstract MenuComponent add(MenuComponent menuComponent);
    
    public abstract MenuComponent remove(MenuComponent menuComponent);
    
	public abstract String toString();
	
	
	String print(MenuComponent menuComponent)
	{
		StringBuilder builder=new StringBuilder(name);
		builder.append(": ");
		builder.append(url);
		builder.append("\n");
		
		return builder.toString();
	}
	

}
