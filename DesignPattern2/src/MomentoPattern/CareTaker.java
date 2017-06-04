package MomentoPattern;

import java.util.Stack;

public class CareTaker
{

	Stack<ProductMomento> stack=new Stack<ProductMomento>();
	
	public void save(Product product)
	{
		stack.push(product.save());
		
	}
	
	
	public void revert(Product product)
	{
		product.revert(stack.pop());
	}
}
