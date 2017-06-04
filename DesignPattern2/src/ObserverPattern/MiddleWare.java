package ObserverPattern;

import java.util.ArrayDeque;
import java.util.Deque;

public class MiddleWare extends Subject
{

	Deque<String> messages=new ArrayDeque<String>();
	
	
	@Override
	public void setState(String state)
	{
		messages.add(state);
		notifyObservers();
		
	}

	@Override
	public String getState()
	{
		return messages.getLast();
	}

}
