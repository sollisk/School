

/**********************
 * Name: Solomon Lisk
 *  Username: ua110 
 *  Problem Set: PS5 
 *  Due Date: 10/15/2018
 **********************/
public class UAStudent {
	private int studentId;
	private String firstName;
	private String lastName;
	private UAStudent next;
	private UAStudent prev;
	private int accessCount;
	private static UAStudent head;
	private static UAStudent tail;

	public UAStudent() {

	}

	public UAStudent(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	// Getters&Setters
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

	public UAStudent getNext() {
		return next;
	}

	public void setNext(UAStudent next) {
		this.next = next;
	}

	public UAStudent getPrev() {
		return prev;
	}

	public void setPrev(UAStudent prev) {
		this.prev = prev;
	}

	public int getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}

	public static UAStudent getHead() {
		return head;
	}

	public void setHead(UAStudent head) {
		this.head = head;
	}

	public static UAStudent getTail() {
		return tail;
	}

	public void setTail(UAStudent tail) {
		this.tail = tail;
	}

	public String toString() {
		return String.format("@%8s %15s,%5s", studentId, firstName, lastName);
	}

}
