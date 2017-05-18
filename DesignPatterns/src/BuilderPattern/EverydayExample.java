package BuilderPattern;

public class EverydayExample
{

	public static void main(String args[])
	{
		
		StringBuilder builder=new StringBuilder();
		
		builder.append("THis is an example");
		
		builder.append(" of the builder pattern.");
		
		
		builder.append(41);
	
		
		System.out.println(builder.toString());
		
	}
	
	
}
