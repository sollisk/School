/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS2
Due Date: Sept 10, 2018
********************************/
public class UABaseWithCommissionEmployee extends UACommissionEmployee{
	private double baseSalary;
	
	//Getters and Setters
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double calcWage() {
		double wage= baseSalary + (getCommissionRate()*getGrossSales());
		return wage;
	}
	
	public String toString() {
		String output= ""+getFirstName()+","+getLastName()+","+getEmployeeId()+","+getDepartment()+","+calcWage();
		return output;
	}

	
	//Constructor
	public UABaseWithCommissionEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName, lastName, employeeId, department);
	}
	
	

}
