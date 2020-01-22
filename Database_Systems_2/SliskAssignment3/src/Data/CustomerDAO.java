/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;
import Beans.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CustomerDAO implements CustomerInterface<Customer> {

    public void add(Customer cust) {

        Connection db; 
        try{
            db = dbConnect.getDB();

            String sql = "INSERT INTO CUSTOMERS VALUES(DEFAULT,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setString(1, cust.cust_fname);
            pstmt.setString(2, cust.cust_lname);
            pstmt.setString(3, cust.cust_address);
            pstmt.setString(4, cust.cust_city);
            pstmt.setString(5, cust.cust_state);
            pstmt.setString(6, cust.cust_zip);
            pstmt.setString(7, cust.cust_phone);
            pstmt.setString(8, cust.cust_email);
            pstmt.setString(9, cust.cust_username);
            pstmt.setString(10, cust.cust_password);
            pstmt.setString(11, cust.cust_class);
            
            pstmt.execute();
            
            db.close();

        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> all = new ArrayList<>();
        Connection db;
        try{
            db = dbConnect.getDB();
            String sql = "SELECT * FROM CUSTOMERS";
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 
            

            while(rs.next()){
                Customer cust = new Customer();
                cust.cust_id = rs.getInt("CUST_id");
                cust.cust_fname = rs.getString("cust_fname");
                cust.cust_lname = rs.getString("cust_lname");
                cust.cust_address = rs.getString("cust_address");
                cust.cust_state = rs.getString("Cust_state");
                cust.cust_zip = rs.getString("cust_zip");
                cust.cust_phone = rs.getString("cust_phone");
                cust.cust_email = rs.getString("cust_email");
                cust.cust_username = rs.getString("cust_username");
                cust.cust_password = rs.getString("cust_password");
                
                all.add(cust);
            }
            
            db.close();
            return all;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"); 
            ex.printStackTrace();
            return null;
        }
    }

    public Customer getCustomer(int cust_id) {
        
        Connection db;
        ResultSet rs;
        Customer cust = new Customer();
        try{
            db = dbConnect.getDB();
                       
            String sql = "SELECT * FROM CUSTOMERS WHERE CUST_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, cust_id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                cust.cust_id = rs.getInt("CUST_id");
                cust.cust_fname = rs.getString("cust_fname");
                cust.cust_lname = rs.getString("cust_lname");
                cust.cust_address = rs.getString("cust_address");
                cust.cust_state = rs.getString("Cust_state");
                cust.cust_zip = rs.getString("cust_zip");
                cust.cust_phone = rs.getString("cust_phone");
                cust.cust_email = rs.getString("cust_email");
                cust.cust_username = rs.getString("cust_username");
                cust.cust_password = rs.getString("cust_password");
                
            }
            
            db.close();
            
            return cust;

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }
        
        return null;
    
    }

    public void update(Customer cust) {
        
    }

    public void delete(Customer cust) {
        Connection db; 
        try{
            db = dbConnect.getDB();
           

            String sql = "DELETE FROM CUSTOMERS WHERE CUST_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, cust.cust_id);


            pstmt.execute();
            
            db.close();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }
    }

    
}