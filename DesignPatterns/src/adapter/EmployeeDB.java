package adapter;

public class EmployeeDB implements Employee
{

	private String id;
	private String firstName;
	private String lastName;
	private String email;

	public EmployeeDB(String id, String firstName, String lastName, String email)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
				
	}

	@Override
	public String getId()
	{
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getFirstName()
	{
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName()
	{
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getEmail()
	{
		// TODO Auto-generated method stub
		return email;
	}
	
	@Override
	public String toString()
	{
		return "ID:"+id+","+"First Name:"+firstName+","+"Last Name:"+lastName+","+"Email:"+email;
		
	}

}
