
/**********************
 * Name: Solomon Lisk 
 * Username: ua110 
 * Problem Set: PS5 
 * Due Date: 10/15/2018
 **********************/
public class UALinkedList {

	public static UAStudent find(int studentId) {
		UAStudent i = UAStudent.getHead();
		if(i.getStudentId()==studentId) {
			return i;
		}
		while (i.getNext() != null) {
			i=i.getNext();
			if (studentId == i.getStudentId()) {
				return i;
			}
			
		}
		return null;
	}

	public void insert(UAStudent s) {

	}

	public static void insertNewItem(UAStudent s) {
		UAStudent i = UAStudent.getTail();
		i.setNext(s);
		i.setPrev(i);
		i.setTail(s);
	}

	public static void remove(int studentId) {
		UAStudent i = UAStudent.getHead();
		
		while(i.getNext()!=null) {
			if(i.getStudentId()==studentId) {
				i=i.getPrev();
				i.setNext(i.getNext().getNext());
				i=i.getNext();
				i.setPrev(i.getPrev().getPrev());
			}
			i=i.getNext();
		}

	}

	public void removeFromIndex(int i) {

	}

	public static void printList(UAStudent i) {
		if (i != null) {
			System.out.println(i);
			i = i.getNext();
			printList(i);
		} 
	}

	public static void printListReversed(UAStudent i) {
		if (i != null) {
			System.out.println(i);
			i = i.getPrev();
			printListReversed(i);
		}

	}

}
