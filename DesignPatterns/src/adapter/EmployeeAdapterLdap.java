package adapter;

public class EmployeeAdapterLdap implements Employee
{

	private EmployeeLdap instance;
	
	public EmployeeAdapterLdap(EmployeeLdap instance)
	{
		this.instance=instance;
	}

	@Override
	public String getId()
	{
		// TODO Auto-generated method stub
		return instance.getCn();
	}

	@Override
	public String getFirstName()
	{
		// TODO Auto-generated method stub
		return instance.getGivenName();
	}

	@Override
	public String getLastName()
	{
		// TODO Auto-generated method stub
		return instance.getSurname();
	}

	@Override
	public String getEmail()
	{
		// TODO Auto-generated method stub
		return instance.getMail();
	}

	
	
}
