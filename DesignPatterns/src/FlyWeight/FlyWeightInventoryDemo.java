package FlyWeight;

public class FlyWeightInventoryDemo
{

	public static void main(String[] args)
	{
		InventorySystem ims=new InventorySystem();

		ims.takeOrder("bose", 123);
		ims.takeOrder("apple", 221);
		ims.takeOrder("bose", 321);
		ims.takeOrder("bose", 445);
		ims.takeOrder("samsung", 21);
		ims.takeOrder("samsung", 54);
		ims.takeOrder("apple", 16);
		ims.takeOrder("bose", 200);
		ims.takeOrder("bose", 300);
		
		ims.process();
		
		System.out.println(ims.report());
	}

}
