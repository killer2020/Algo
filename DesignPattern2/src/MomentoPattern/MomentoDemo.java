package MomentoPattern;

public class MomentoDemo
{

	public static void main(String args[])
	{
		
		Product bond=new Product("Bond",10.00);
		CareTaker caretaker=new CareTaker();
		
		caretaker.save(bond);
		
		bond.setPrice(15.00);
		
		caretaker.save(bond);
		
		bond.setPrice(20.00);
		
		
		System.out.println(bond);
		caretaker.revert(bond);
		System.out.println(bond);
		
		caretaker.revert(bond);
		System.out.println(bond);
		
		
	}
	
	
}
