package Interpreter;

import java.util.StringTokenizer;

public class TerminalExpression extends Expression
{

	private String data;
	
	public TerminalExpression(String data)
	{
		
		this.data=data;
	}
	
	@Override
	public boolean interpret(String str)
	{
		StringTokenizer st=new StringTokenizer(str);
		
		while(st.hasMoreTokens())
		{
			String test=st.nextToken();
			if(test.equals(data))
				return true;
		}
		return false;
	}

}
