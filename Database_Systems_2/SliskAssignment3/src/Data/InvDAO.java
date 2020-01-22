/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;

import Beans.invItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class InvDAO implements InvInterface<invItem>{
    /**
     *
     * @param item
     */
    public void add(invItem item) {
        Connection db; 
        try{
            db = dbConnect.getDB();
            String sql = "INSERT INTO INVENTORY VALUES(DEFAULT, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setString(1, item.name);
            pstmt.setString(2, item.description);
            pstmt.setInt(3, item.qty_onhand);
            pstmt.setInt(4, item.reorder_amt);
            pstmt.setFloat(5, item.reorder_price);
            //on inserts just use execute()
            pstmt.execute();
            
            db.close();

        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    /**
     *
     * @return
     */
    
    public ArrayList<invItem> getAllItems(){
        
        ArrayList<invItem> allitems = new ArrayList<>();
        Connection db;
        try{
            db = dbConnect.getDB();
            String sql = "SELECT * FROM INVENTORY";
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                invItem ii = new invItem();
                ii.id = rs.getInt("inv_id");
                ii.name = rs.getString("inv_NAME");
                ii.description = rs.getString("inv_description");
                ii.reorder_price = rs.getFloat("inv_reorder_price");
                ii.qty_onhand = rs.getInt("inv_qty_onhand");
                ii.reorder_amt = rs.getInt("inv_reorder_amt");
                allitems.add(ii);
            }
            db.close();
            return allitems;
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
            return null;
        }

    }
    
    public invItem getItem(int id){
        
        Connection db;
        ResultSet rs;
        invItem ii = new invItem();
        try{
            db = dbConnect.getDB();
                       
            String sql = "SELECT * FROM INVENTORY WHERE INV_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                ii.id = rs.getInt("inv_id");
                ii.name = rs.getString("inv_NAME");
                ii.description = rs.getString("inv_description");
                ii.reorder_price = rs.getFloat("inv_reorder_price");
                ii.qty_onhand = rs.getInt("inv_qty_onhand");
                ii.reorder_amt = rs.getInt("inv_reorder_amt");
            }
            
            db.close();
            
            return ii;

        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
        
        return null;
    }
    
    
    public void delete(invItem item){
        Connection db; 
        try{
            db = dbConnect.getDB();
            
            String sql = "DELETE FROM INVENTORY WHERE INV_ID = ?";
            PreparedStatement pstmt = db.prepareStatement(sql);
            pstmt.setInt(1, item.id);
            pstmt.execute();
            
            db.close();

        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }   
                   
}
    public void update(invItem item) {
                
            }
}
