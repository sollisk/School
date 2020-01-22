/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;

/**
 *
 * @author User
 */
import Beans.Items;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.*;

/**
 *
 * @author user
 */
public class ItemsDAO implements ItemsInterface<Items>{

    public void add(Items item){

        Connection db; 
        try{
            db = dbConnect.getDB();
            String sql = "INSERT INTO BAKERY_ITEMS VALUES(DEFAULT, ?, ?, ?)";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setString(1, item.item_name);
            pstmt.setString(2, item.item_description);
            pstmt.setFloat(3, item.item_price);
            //on inserts just use execute()
            pstmt.execute();
            
            db.close();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Add Error");
            ex.printStackTrace();
        }
      
    }
    
    public ArrayList<Items> getAllItems(){

        ArrayList<Items> allitems = new ArrayList<>();
        Connection db;
        try{
            db = dbConnect.getDB();
            String sql = "SELECT * FROM BAKERY_ITEMS";
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Items bi = new Items();
                bi.item_id = rs.getInt("BAKERY_ITEM_ID");
                bi.item_name = rs.getString("BAKERY_ITEM_NAME");
                bi.item_description = rs.getString("BAKERY_ITEM_DESCRIPTION");
                bi.item_price = rs.getFloat("BAKERY_ITEM_PRICE");
                allitems.add(bi);
            }
            db.close();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "GetAllItem Error" );
            ex.printStackTrace();
            return null;
        }
        return allitems;
    }
    
    public Items getItem(int item_id){
        
        Connection db;
        ResultSet rs;
        Items bi = new Items();
        try{
            db = dbConnect.getDB();
                       
            String sql = "SELECT * FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, item_id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                bi.item_id = rs.getInt("bakery_item_id");
                bi.item_description = rs.getString("bakery_item_description");
                bi.item_name = rs.getString("bakery_item_name");
                bi.item_price = rs.getFloat("bakery_item_price");
            }
            
            db.close();
            
            return bi;

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "getItem error");
            ex.printStackTrace();
        }
        
        return null;
    }
    
    
    public void delete(Items item){

        Connection db; 
        try{
            db = dbConnect.getDB();
            
            String sql = "DELETE FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, item.item_id);
            pstmt.execute();
            
            db.close();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Delete Error");
            ex.printStackTrace();
        }
    }
    public void update(Items item) {
        
    }
    
}
