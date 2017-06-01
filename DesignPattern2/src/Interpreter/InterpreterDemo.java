package Interpreter;

public class InterpreterDemo
{

	
	
	
	public static void main(String args[])
	{
		
		String context="Lions cheetahs and Tiger ";
		
		
		Expression expression=buildInterpreterTree();
		
		System.out.println(context+":"+expression.interpret(context));
		
	}

	private static Expression buildInterpreterTree()
	{
		Expression expression1=new TerminalExpression("Lions");
		Expression expression2=new TerminalExpression("Tiger");
		
		Expression andExpression=new AndExpression(expression1, expression2);
		Expression orExpression=new OrExpression(expression1, expression2);
		
		return andExpression;
	}
	
	
	
}
