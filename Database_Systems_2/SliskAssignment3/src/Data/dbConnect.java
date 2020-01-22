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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class dbConnect {
    public static Connection getDB(){
        String user = "ua118";
        String pass = "UApass7221";
        String url = "jdbc:db2://data.cis.uafs.edu:55000/CS2043"; 
        
        Connection conn;
        
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
         try {
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            conn = null;
        }
        
        return conn;
    }
    
}