/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS2
Due Date: Sept 10, 2018
********************************/
public class UAHourlyEmployee extends UAEmployee{
	private float wage;
	private int numHoursWorked;
	
	//Getters and Setters
	public float getWage() {
		return wage;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public int getNumHoursWorked() {
		return numHoursWorked;
	}
	public void setNumHoursWorked(int numHoursWorked) {
		this.numHoursWorked = numHoursWorked;
	}
	
	public double calcWage() {
		double totalWage= wage*numHoursWorked;
		return totalWage;
	}
	
	public String toString() {
		String output= ""+getFirstName()+","+getLastName()+","+getEmployeeId()+","+getDepartment()+","+calcWage();
		return output;
	}
	
	//Constructors
	public UAHourlyEmployee(String firstName, String lastName, int employeeId, String department) {
		super(firstName, lastName, employeeId, department);
	}

	

}
	

