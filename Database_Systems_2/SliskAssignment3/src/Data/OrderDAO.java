/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
 */
package Data;


import Beans.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OrderDAO implements OrderInterface<Order> {

    public void add(Order ord) {
        Connection db;
        try {
            db = dbConnect.getDB();

            String sql = "INSERT INTO ORDERS VALUES(DEFAULT,DEFAULT,DEFAULT,?)";
            PreparedStatement pstmt = db.prepareStatement(sql);

            pstmt.setInt(1,ord.cust_id);
            pstmt.execute();

            db.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ ord.cust_id);
            ex.printStackTrace();
        }
    }

    public void addDetails(Order ord) {

        Connection db;
        try {
            db = dbConnect.getDB();
            
            String sql = "INSERT INTO ORDER_DETAILS VALUES(DEFAULT,?,?,?)";
            PreparedStatement pstmt = db.prepareStatement(sql);
            int order_id=0;
            order_id = getOrderID();
            pstmt.setInt(1,order_id);
            pstmt.setString(2, ord.bakery_id);
            pstmt.setString(3, ord.orderQuantity);
            pstmt.execute();

            db.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }
    }
    //Create ORDER_DETAILS Insert into order_details (Order_ID, Bakery_Item, etc) PER ITEM
    //For Each Bakery Item ordered X QTY ordered check RAW MATERIALS
    //Select * FROM RECIPE, ITEMS, JOIN ... Where BAKERY_ITEMS_ID =?
    //Recipe gives QTY per raw material needed to produce 1 bakery item, do while loop while(QtyNeeded =< QTY_ON_HAND)
    //Update inventory for(Item i : items){update items set QTY_ON_HAND=QTY_ON_HAND - ...}   

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> all = new ArrayList<>();
        Connection db;
        try {
            db = dbConnect.getDB();
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Order ord = new Order();
                ord.order_id = rs.getInt("order_id");
                ord.orderDate = rs.getString("order_date");
                ord.orderTime = rs.getString("order_time");

                all.add(ord);
            }

            db.close();
            return all;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();

            return null;
        }
    }
        public ArrayList<Order> getAllOrderDetails() {
        ArrayList<Order> all = new ArrayList<>();
        Connection db;
        try {
            db = dbConnect.getDB();
            String sql = "SELECT * FROM ORDER_DETAILS";
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Order ord = new Order();
                ord.order_details_id= rs.getInt("order_details_id");
                ord.order_id=rs.getInt("order_id");
                ord.bakery_id = rs.getString("bakery_item_id");
                ord.orderQuantity = rs.getString("quantity");

                all.add(ord);
            }

            db.close();
            return all;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();

            return null;
        }
    }

    public Order getOrder(int order_id) {

        Connection db;
        ResultSet rs;
        Order ord = new Order();
        try {
            db = dbConnect.getDB();

            String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, order_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                ord.order_id = rs.getInt("order_id");
                ord.orderDate = rs.getString("order_date");
                ord.orderTime = rs.getString("order_time");

            }

            db.close();

            return ord;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }

        return null;

    }
        public int getOrderID() {

        Connection db;
        ResultSet rs;
        Order ord = new Order();
        int order_id=0;
        try {
            db = dbConnect.getDB();

            String sql = "SELECT max(ORDER_ID) FROM ORDERS";
            PreparedStatement pstmt = db.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                order_id = rs.getInt(1);
                
            }

            db.close();

            return order_id;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }

        return 0;

    }
    

    public Order getOrderItems(int order_details_id) {
        Connection db;
        ResultSet rs;
        Order ord = new Order();
        try {
            db = dbConnect.getDB();

            String sql = "SELECT * FROM ORDER_DETAILS WHERE ORDER_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, order_details_id);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ord.order_details_id = rs.getInt("order_details_id");
                    ord.order_id = rs.getInt("order_id");
                    ord.bakery_id = rs.getString("bakery_item_id");
                    ord.orderQuantity = rs.getString("quantity");

                }
            }
            db.close();

            return ord;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }

        return null;

    }

    public void update(Order ord) {

    }

    public void delete(Order ord) {
        Connection db;
        try {
            db = dbConnect.getDB();

            String sql = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, ord.order_id);

            pstmt.execute();

            db.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

}
