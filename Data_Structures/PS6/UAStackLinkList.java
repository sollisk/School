import java.io.BufferedReader;
import java.io.FileReader;

/**********************
 * Name: Solomon Lisk 
 * Username: ua110 
 * Problem Set: PS6 
 * Due Date: 10/22/2018
 **********************/

public class UAStackLinkList {

	public static class UAStudent {
	
		private int studentId;
		private String firstName;
		private String lastName;
		private static UAStudent top;
		private UAStudent next;
		



		/** Constructor used in the case of a single line of input.
		 * 
		 * @param input The single line of input, that is passed into the splitter method to set the values of StudentId,firstName, and lastName.
		 */
		public UAStudent(String input) {
			splitter(input);
		}
		/** Takes the single string line of input and separates it into the corresponding values. 
		 * 
		 * @param input
		 */
		public void splitter(String input) {
			String[] output = input.split(",");
			setLastName(output[0]);
			setFirstName(output[1]);
			setStudentId(Integer.parseInt(output[2]));
			
			
		}
		
		//Getters/Setters
		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public static UAStudent getTop() {
			return top;
		}

		public void setTop(UAStudent top) {
			this.top = top;
		}

		public UAStudent getNext() {
			return next;
		}

		public void setNext(UAStudent next) {
			this.next = next;
		}

		public String toString() {
			return "Student: \t" + lastName + ", " + firstName+", "+studentId;
		}
		
	}
	/**Variable used to keep track of size of the stack.
	 * 
	 */
	public static int totSize;
	
	/** Inserts a new UAStudent into the stack.
	 * O(1)
	 * @param s the new UAStudent that is being inserted.
	 */
	public static void push(UAStudent s) {
		UAStudent i = UAStudent.getTop();
		if(i==null) {
			s.setTop(s);
			totSize++;
			return;
		}
		s.setNext(i);
		s.setTop(s);
		totSize++;
	}
	/** Removes the last UAStudent that was inserted into the stack.
	 * O(1)
	 * @return returns the UAStudent that was removed from the stack. 
	 */
	public static UAStudent pop() {
		if(isStackEmpty()==true) {
			return null;
		}
		UAStudent i = UAStudent.getTop();
		UAStudent s = i.getNext();
		i.setTop(s);
		totSize--;
		return i;
	}
	/** Method used to return the size of the stack.
	 * O(1)
	 * @return returns the total size of the stack.
	 */
	public static int size() {
		return totSize;
	}
	/** Method used to check if the stack is empty.
	 * O(1)
	 * @return Returns true if the stack is empty, and false if the stack is populated.
	 */
	public static boolean isStackEmpty() {
		if(UAStudent.getTop()==null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("records.txt"));
			String readIn;
			while ((readIn = br.readLine()) != null) {
				push(new UAStudent(readIn));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(isStackEmpty());
		System.out.println(size());
		System.out.println(pop());
		System.out.println(size());
		System.out.println(isStackEmpty());
		
		
	}

	


}