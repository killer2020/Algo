package MomentoPattern;

public class Product
{

	private String name;
	private double price;

	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public void revert(ProductMomento productMomento)
	{
		name=productMomento.getName();
		price=productMomento.getPrice();
	}

	public ProductMomento save()
	{
		return new ProductMomento(name, price);
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
	@Override
	public String toString()
	{
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
