/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Beans.Order;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public interface OrderInterface <ASDF> {
    public void add(ASDF c);
    public ArrayList<ASDF> getAllOrders();
    public Order getOrder(int order_id);
    public void update(ASDF c);
    public void delete(ASDF c); 
}
