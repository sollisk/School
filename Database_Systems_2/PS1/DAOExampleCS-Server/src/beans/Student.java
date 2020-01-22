package beans;

import com.google.gson.Gson;

public class Student {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	
	Gson gson = new Gson();
	
	public String getFirstName() {
		return firstName;
		
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		gson.toJson(firstName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		gson.toJson(lastName);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;	
		gson.toJson(address);
	}
	public String getCity() {
		return city;
		
	}
	public void setCity(String city) {
		this.city = city;
		gson.toJson(city);
	}
}
