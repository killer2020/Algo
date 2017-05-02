package adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient
{

	public List<Employee> getEmployeeList()
	{
		
		List<Employee> employees=new ArrayList<>();
		
		
		Employee employeeFromDB=new EmployeeDB("1234","John","Wick","abc@def.com");
		
		
		employees.add(employeeFromDB);
		
		
		EmployeeLdap employeeFromLdap=new EmployeeLdap("12345","JohnLdap","WickLdap","abcLdap@def.com");
		
		
		employees.add(new EmployeeAdapterLdap(employeeFromLdap));
		
		return employees;
	}

}
