import java.io.BufferedReader;
import java.io.FileReader;
/**********************
 * Name: Solomon Lisk
 *  Username: ua110 
 *  Problem Set: PS5 
 *  Due Date: 10/15/2018
 **********************/
public class UATest {
	public static void main(String[] args) {
//
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("records.txt"));
//			String readIn;
//			while ((readIn = br.readLine()) != null) {
//				String[] output = readIn.split(",");
//				String studentId = output[0];
//				String firstName = output[1];
//				String lastName = output[2];
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	//Test Cases
		 UAStudent n1 = new UAStudent(45678, "Lee", "Rebecca");
		 UAStudent n2 = new UAStudent(67890, "Cuervas", "Ben");
		 UAStudent n3 = new UAStudent(90047, "Smith", "Sally");
		 UAStudent n4 = new UAStudent(12345, "Mackey", "Andrew");
		 UAStudent n5 = new UAStudent(44332,"Jones","Sue");
		 UAStudent n6 = new UAStudent(87654,"Jae","Young");
		 n1.setHead(n1);
		 n4.setTail(n4);
		 n1.setNext(n2);
		 n2.setNext(n3);
		 n3.setNext(n4);
		 n4.setPrev(n3);
		 n3.setPrev(n2);
		 n2.setPrev(n1);
		 
		 UALinkedList.printList(n1);
		 UALinkedList.printListReversed(n4);
		 System.out.println(UALinkedList.find(12345));
		 System.out.println(UALinkedList.find(45678));
		 UALinkedList.insertNewItem(n5);
		 System.out.println(UALinkedList.find(12345));
		 UALinkedList.remove(90047);
		 System.out.println(UALinkedList.find(45678));
		 UALinkedList.insertNewItem(n6);
		 System.out.println(UALinkedList.find(12345));
		 UALinkedList.printList(n1);
		
		
	}

}

