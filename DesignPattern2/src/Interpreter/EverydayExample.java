package Interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EverydayExample
{
	
	
	public static void main(String args[])
	{
		
		String input="lions and tigers and Bears";
		
		
		Pattern p= Pattern.compile("(lion|cat|tiger|bear)");
		
		Matcher m =p.matcher(input);
		
		while(m.find())
		{
			System.out.println("Found:"+m.group());
		}
		
	}
	

}
