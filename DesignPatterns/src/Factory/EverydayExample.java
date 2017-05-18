package Factory;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EverydayExample
{

	public static void main(String args[])
	{
		Calendar cal=Calendar.getInstance();
		
		
		System.out.println(cal);
		
		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		
	}
	
}
