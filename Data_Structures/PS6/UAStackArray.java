import java.io.BufferedReader;
import java.io.FileReader;

public class UAStackArray {

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
	
	public static int aSize;
	


	public UAStackArray(int size) {
		aSize=size;
		UAStackArray [] init = new UAStackArray[size];
	}
	/** Inserts a new UAStudent into the stack.
	 * O(1)
	 * @param s the new UAStudent that is being inserted.
	 */
	public void push(UAStudent s) {
		UAStudent i = UAStudent.getTop();
		
		
		if(i==null) {
			s.setTop(s);
			return;
		}
		s.setNext(i);
		s.setTop(s);
	}
	/** Removes the last UAStudent that was inserted into the stack.
	 * O(1)
	 * @return returns the UAStudent that was removed from the stack. 
	 */
	public UAStudent pop() {
		if(isStackEmpty()==true) {
			return null;
		}
		UAStudent i = UAStudent.getTop();
		UAStudent s = i.getNext();
		i.setTop(s);
		
		return i;
	}
	/** Method used to return the size of the stack.
	 * O(1)
	 * @return returns the total size of the stack.
	 */
	public int size() {
		return aSize;
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
	/** Resizes the array to 1.5X larger than the array was previously.
	 * O(n)
	 * Used when the array is full and it needs to have a new value put in.
	 */ 
	public static void resize() {
		UAStudent i= UAStudent.getTop();
		//This is as far as I got.
	}


	public static void main(String[] args) {

		UAStackArray st = new UAStackArray(100);


		
		try {
			BufferedReader br = new BufferedReader(new FileReader("records.txt"));
			String readIn;
			while ((readIn = br.readLine()) != null) {
				st.push(new UAStudent(readIn));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + st.size() );
		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		System.out.println(a);
		st.push( a );	
		st.push( new UAStudent("Mackey,Andrew,55555") );
		st.push( new UAStudent("Mackey,Andrew,99999") );

		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");	
		System.out.println(st.pop());

		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println("Size of Stack:  " + st.size() );
		System.out.println(st.pop());
		System.out.println("Size of Stack:  " + st.size() );
		
	}

	


}