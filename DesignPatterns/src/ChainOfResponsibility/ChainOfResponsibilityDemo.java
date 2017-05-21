package ChainOfResponsibility;

public class ChainOfResponsibilityDemo
{

	public static void main(String args[])
	{	
	
	Director kaka=new Director();
	
	VP mama=new VP();
	
	CEO jackma=new CEO();
	
	
	kaka.setSucessor(mama);
	mama.setSucessor(jackma);
	
	
	kaka.handle(new Request(RequestType.CONFERENCE,1000));
	kaka.handle(new Request(RequestType.PURCHASE,1000));
	kaka.handle(new Request(RequestType.PURCHASE,2500));
	
	
	
	}
}
