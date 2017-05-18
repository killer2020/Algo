package PrototypePattern;

import java.util.HashMap;
import java.util.Map;

public class Registry
{

	private Map<String,Item> items=new HashMap<String,Item>();
	
	
	
	public Registry()
	{
		loadItems();
	}

	
	
	public Item createItem(String type)
	{
		
		Item item=null;
		
		
		try{
			
			item=(Item)items.get(type).clone();
		}catch(CloneNotSupportedException e)		
		{
		  e.printStackTrace();	
		}
		
		return item;
				
	}
   

	private void loadItems()
	{
		Movie movie=new Movie();
		movie.setTitle("Basic Movie");
		movie.setPrice(1.22);
		movie.setRuntime("3 hrs");
		
		Book book=new Book();
		book.setNumberOfPages(335);
		book.setPrice(12);
		book.setTitle("Basic Book");
		
		
		items.put("Movie",movie);
		items.put("Book", book);
		
		
		
	}
	
	
}
