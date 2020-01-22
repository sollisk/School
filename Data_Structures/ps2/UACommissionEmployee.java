/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS2
Due Date: Sept 10, 2018
********************************/
public class UACommissionEmployee extends UAEmployee {
	private float commissionRate;
	private float grossSales;
	
	//Getters and Setters
	public float getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}
	public float getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(float grossSales) {
		this.grossSales = grossSales;
	}
	
	public double calcWage() {
		double wage= grossSales*commissionRate;
		return wage;
	}
	
	public String toString() {
		String output= ""+getFirstName()+","+getLastName()+","+getEmployeeId()+","+getDepartment()+","+calcWage();
		return output;
	}
	
	//Constructor
	public UACommissionEmployee(String firstName,String lastName,int employeeId, String department) {
		super(firstName, lastName, employeeId, department);
	}


}
