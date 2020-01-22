import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/***********************************************************************************
 * Student Name: Solomon Lisk Date: 10/20/19 Class: Algorithms Filename:
 * UAHashMap.java Description: Implementation of a hash map (by A. Mackey)
 ***********************************************************************************/

public class UAHashMap {

	protected static final int INITIAL_SIZE = 27;
	protected UAEmployee[] hashTable;
	protected int hashMapSize;
	protected int collisionCount = 0;
	protected int fillSize=0;
	
	/*
	 * Constructors
	 */

	public UAHashMap(int size) {
		hashTable = new UAEmployee[size];
		hashMapSize = size;
	}

	public UAHashMap() {
		this(INITIAL_SIZE);
	}
	

	/*
	 * Methods to implement in each class: insert() and search()
	 */
	public int hashCode(int id) {
		return (id % 5)%hashMapSize;
	}

	public void readFile(String fileName) {

	}

	public void insert(UAEmployee k) {
	}

	public UAEmployee search(int id) {
		return null;
	}

	public int size() {
		return this.fillSize;
	}
	public static int countLines(String fileName) {
		int lines = 0;
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((bufferedReader.readLine()) != null) {
				lines++;
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return lines;
	}

	// This should return the number of times a collision occurred.

	public int getCollisionCount() {
		return this.collisionCount;
	}
	/*
	 * Runtime code
	 */

	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Please enter arguments");
			System.exit(0);
		}
		UAHashMap h = new UAHashMap(countLines(args[0])*4);
		UAHashMapLinear l = new UAHashMapLinear(countLines(args[0])*4);
		UAHashMapQuadraticProbing q = new UAHashMapQuadraticProbing(countLines(args[0])*4);
		UAHashMapDoubleHashing d = new UAHashMapDoubleHashing(countLines(args[0])*4);
		
		String userInput = args[1].toUpperCase();
		if(userInput.equals("LINEAR")) {
			l.readFile(args[0]);
			System.out.println(l.getCollisionCount());
		} else if (userInput.equals("QUADRATIC")) {
			q.readFile(args[0]);
			System.out.println(q.getCollisionCount());
		} else if(userInput.equals("DOUBLE")) {
			d.readFile(args[0]);
			System.out.println(d.getCollisionCount());
		} else {
			System.out.println("Please enter valid arguments");
		}
		
	}

	/*
	 * Class that will be used to store in the hash map implementation.
	 */

	public static class UAEmployee {

		public UAEmployee(int id, String lastName, String firstName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public int id;
		public String firstName;
		public String lastName;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
		public int hashCode(int id) {
			return id % 5;
		}
		public String toString() {
			return String.format("Hash Code: %15d      Name: %30s %n", this.hashCode(id),
					this.lastName + ", " + this.firstName);
		}

	}

	/*
	 * Specific implementations of hash maps
	 */
	public static class UAHashMapLinear extends UAHashMap {
		
		public UAHashMapLinear(int size) {
			hashTable = new UAEmployee[size];
			hashMapSize = size;
		}

		public UAHashMapLinear() {
			this(INITIAL_SIZE);
		}
		
		public boolean hasSpace() {
			if(fillSize==hashMapSize) {
				return false;
			} else
			return true;
		}
		public void insert(UAEmployee k) {
			int id = k.getId();
			int hash = hashCode(id);
			int size = this.hashMapSize;

			while (hashTable[hash] != null&&hasSpace()) {
				++hash;
				hash = hash%hashMapSize;
				collisionCount++;
			}
			hashTable[hash] = k;
			fillSize++;
		}

		public UAEmployee search(int id) {
			int hash = hashCode(id);

			while (hashTable[hash] != null) {
				if (hashTable[hash].getId() == id) {
					return hashTable[hash];
				}
				++hash;
				hash = hash%hashMapSize;
			}
			return null;
		}
		public void readFile(String fileName) {
			String line;
			
			try {
				FileReader fileReader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					String[] output = line.split(",");
					int id = Integer.parseInt(output[0]);
					String lastName = output[1];
					String firstName = output[2];
					UAEmployee e = new UAEmployee(id,lastName,firstName);
					insert(e);
				}
				fileReader.close();
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
			}
		}

	}

	public static class UAHashMapQuadraticProbing extends UAHashMap {
		public UAHashMapQuadraticProbing(int size) {
			hashTable = new UAEmployee[size];
			hashMapSize = size;
		}

		public UAHashMapQuadraticProbing() {
			this(INITIAL_SIZE);
		}
		public void insert(UAEmployee k) {
			int id = k.getId(), hash = hashCode(id),x=1;
			int i =hash;
	        
			do
	        {
	            if (hashTable[i] == null)
	            {
	                hashTable[i] = k;
	                fillSize++;
	                return;
	            }
	            collisionCount++;
	           
	            i = (i + x * x++) % hashMapSize;            
	        } while (i != hash);  
			
		}
		
		public UAEmployee search(int id) {
			int hash = hashCode(id),x=1;
			
			while(hashTable[hash] != null) {
				if(hashTable[hash].getId() ==id) {
					return hashTable[hash];
				}
				hash = (hash+x*x++)%hashMapSize;
			}
			return null;
		}
		public void readFile(String fileName) {
			String line;
			
			try {
				FileReader fileReader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					String[] output = line.split(",");
					int id = Integer.parseInt(output[0]);
					String lastName = output[1];
					String firstName = output[2];
					UAEmployee e = new UAEmployee(id,lastName,firstName);
					insert(e);
				}
				fileReader.close();
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
			}
		}
	}

	public static class UAHashMapDoubleHashing extends UAHashMap {
		public UAHashMapDoubleHashing(int size) {
			hashTable = new UAEmployee[size];
			hashMapSize = size;
		}
		public UAHashMapDoubleHashing() {
			this(INITIAL_SIZE);
		}
		public int hash2(int hashCode) {
			return (hashCode%17)%hashMapSize;
		}

		public void insert(UAEmployee k) {
			int id = k.getId();
			int hash = hashCode(id);
			int hash2 = hash2(id);
			int i=0;
			
			while(hashTable[hash]!=null) {
				hash = hash+hash2+i;
				hash %=hashMapSize;
				collisionCount++;
				i++;
			}
			hashTable[hash] = k;
			fillSize++;
		}
		
		public UAEmployee search(int id) {
			int hash = hashCode(id);

			while (hashTable[hash] != null) {
				if (hashTable[hash].getId() == id) {
					return hashTable[hash];
				}
				hash = hash+hash2(id);
				hash = hash%hashMapSize;
			}
			return null;
		}
		public void readFile(String fileName) {
			String line;
			
			try {
				FileReader fileReader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while ((line = bufferedReader.readLine()) != null) {
					String[] output = line.split(",");
					int id = Integer.parseInt(output[0]);
					String lastName = output[1];
					String firstName = output[2];
					UAEmployee e = new UAEmployee(id,lastName,firstName);
					insert(e);
				}
				fileReader.close();
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
			}
		}
	}
}
