package Decorator;

public class DecoratorSandwichDemo
{

	public static void main(String args[])
	{
		
		Sandwich sandwich=new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		
		System.out.println(sandwich.make());
		
		
		String str="abc";
		
		
		String s=str.concat(str);
		
		System.out.println(str);
		System.out.println(s);
		
	}
	
	
}
