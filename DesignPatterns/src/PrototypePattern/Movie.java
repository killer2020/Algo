package PrototypePattern;
				
public class Movie extends Item
{
	
	
	private String runtime;

	@Override
	public String toString()
	{
		return "Movie [getRuntime()=" + getRuntime() + ", getTitle()=" + getTitle() + ", getPrice()=" + getPrice()
				+ ", getUrl()=" + getUrl() + "]";
	}

	public String getRuntime()
	{
		return runtime;
	}

	public void setRuntime(String runtime)
	{
		this.runtime = runtime;
	}

}
