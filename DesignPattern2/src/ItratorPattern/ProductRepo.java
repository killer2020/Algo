package ItratorPattern;

import java.util.Iterator;

public class ProductRepo implements Iterable<String>
{

	
	
	
	@Override
	public Iterator<String> iterator()
	{
		Iterator<String> it=new Iterator<String>()
				{

					@Override
					public boolean hasNext()
					{
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public String next()
					{
						// TODO Auto-generated method stub
						return null;
					}
			
				};
				
		return it;		
	}

}
