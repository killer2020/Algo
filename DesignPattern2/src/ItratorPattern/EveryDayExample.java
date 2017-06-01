package ItratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EveryDayExample
{
   
	
	public static void main(String args[])
	{
		
		
		List<String> names=new ArrayList<String>();
		
		names.add("Bryan");
		names.add("Adam");
		names.add("gaga");
		
//		Iterator<String> namesItr=names.iterator();
//		
//		
//		while(namesItr.hasNext())
//		{
//			
//			String name=namesItr.next();
//			
//			System.out.println(name);
//			
//			namesItr.remove();
//			
//		}
		
		
		for(String str:names)
		{
			System.out.println(str);
		}
	   
		
		
		System.out.println("Size:"+names.size());

		
	}
	
	
}
