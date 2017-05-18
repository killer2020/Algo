package PrototypePattern;

public class PrototypeDemo
{

	public static void main(String args[])
	{
		
		Registry registry=new Registry();
		
		Movie movie=(Movie)registry.createItem("Movie");
		
		movie.setTitle("Protitype pattern");
		
		System.out.println(movie);
		
	}
	
	
}
