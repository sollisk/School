package beans;

import java.net.Socket;


import com.google.gson.Gson;

public class StudentsClient {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	
	
	Socket socket=null;
	
	public StudentsClient(Socket socket){
		this.socket=socket;
	}	
	
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
	outServer.close();
	inServer.close();
	socket.close();
	
}
