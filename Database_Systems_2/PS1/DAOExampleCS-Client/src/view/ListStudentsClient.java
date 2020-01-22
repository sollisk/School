package view;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import beans.StudentsClient;
import client.ClientProtocol;


public class ListStudentsClient {	

	public static void main(String[] args) {
		
		Socket socket=null;
		try{
			socket = new Socket("127.0.0.1",4000);
			StudentsClient clientProtocol = new StudentsClient(socket);
			clientProtocol.StudentsClient();
		}catch(UnknownHostException ex){
			System.out.println("Cannot locate the host computer..");
			System.exit(1);
		}catch(IOException ex){
			System.out.println("Unable to communicate with server..");
			System.exit(1);
		}
		
		ArrayList<Student> names;
		Student name;
		int index;
		
		names=StudentsClient.getStudents();
		
		System.out.printf("%-15s %-15s %-15s \n", "First Name", "Last Name", "City");
		System.out.printf("%-15s %-15s %-15s \n\n", "----------", "---------", "----");		
		for(index=0;index<names.size();index++){
			name = names.get(index);
			System.out.printf("%-15s %-15s %-15s \n", name.getFirstName(), name.getLastName(), name.getCity());			
		}
	}

}
