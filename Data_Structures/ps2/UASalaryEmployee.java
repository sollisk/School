/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS2
Due Date: Sept 10, 2018
********************************/
public class UASalaryEmployee extends UAEmployee{

	private double monthlySalary;

	//Getters and Setters
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	public double calcWage() {
		return monthlySalary;
	}
	
	public String toString() {
		String output= ""+getFirstName()+","+getLastName()+","+getEmployeeId()+","+getDepartment()+","+calcWage();
		return output;
	}
	
	//Constructors
	/*public UASalaryEmployee(String employInfo) {
		
	}
	*/
	public UASalaryEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName, lastName, employeeId, department);
	}
	

	

}
