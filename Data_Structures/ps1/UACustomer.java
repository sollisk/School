/**********************
Name: Solomon Lisk
Username: ua110
Problem Set: PS1
Due Date: Aug 27,2018
**********************/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class UACustomer{
	//Constructor 
    public UACustomer() {
	}
    
    public UACustomer(String custName, String email, int custNum) {
		this.custName = custName;
		this.email = email;
		this.custNum= custNum;
	}
    
    //Getters and Setters
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustNum() {
		return custNum;
	}
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
	private String custName;
    private String email;
    private int custNum;
    private UACustomer[] customers;
    
    
    
    public static void main (String args[]){

    }

    

    
 }
