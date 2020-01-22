/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;
import Beans.invItem;
import java.util.ArrayList;

public interface InvInterface <ASDF>{
    
    public void add(ASDF item);
    public ArrayList<ASDF> getAllItems();
    public invItem getItem(int item_id);
    public void update(ASDF item);
    public void delete(ASDF item);
}
