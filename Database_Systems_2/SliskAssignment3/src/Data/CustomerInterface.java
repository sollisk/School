/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;
import Beans.Customer;
import java.util.ArrayList;

public interface CustomerInterface <ASDF> {
    public void add(ASDF c);
    public ArrayList<ASDF> getAllCustomers();
    public Customer getCustomer(int cust_id);
    public void update(ASDF c);
    public void delete(ASDF c); 
}
