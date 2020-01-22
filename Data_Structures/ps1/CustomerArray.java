import java.io.BufferedReader;
import java.io.FileReader;

public class CustomerArray {
		private UACustomer customers[];
    	private int size;
    	
    	public void initArray(int arraySize) {
    		UACustomer customer [] = new UACustomer[arraySize];
    	}
    	
    	public boolean loadArray(String fileName) {
    		
    		try {
    			BufferedReader br = new BufferedReader(new FileReader("fileName"));
    			while(br.readLine()!=null) {
    				String readIn=br.readLine();
    				String [] output = readIn.split(",");
    				String name = output[0];
    				String email=output[1];
    				String number=output[2];
    			}
    			return true;
    		}
    		catch(Exception e){
    			e.printStackTrace();
    			return false;
    		}
    	}
    	
    	public int addCustomer(UACustomer customer) {
    		
    		
    		return 0;
    	}
    	
    	//Getters&Setters
    	public UACustomer[] getCustomers() {
			return customers;
		}
		public void setCustomers(UACustomer[] customers) {
			this.customers = customers;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
    }
    