package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import beans.Student;

public class StudentDAO {
	public static ArrayList<Student> getStudents(){
		ArrayList<Student> names = new ArrayList<Student>();
		Student row;
		String record;
		
		try {
			FileReader file = new FileReader("students.txt");
			BufferedReader in = new BufferedReader(file);
			while((record = in.readLine()) !=null){
				String fields[] = record.split(",");
				row = new Student();
				row.setLastName(fields[0]);
				row.setFirstName(fields[1]);
				row.setAddress(fields[2]);
				row.setCity(fields[3]);
				names.add(row);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return names;
	}
}
