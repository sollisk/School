/* Solomon Lisk
@user UA118
@Date 2/5/2018
@assign Problem Set 2
*/
package Data;
import java.util.ArrayList;
import Beans.Items;
/**
 *
 * @author User
 */
public interface ItemsInterface<ASDF> {

    /**
     *
     * @param item
     */
    public void add(ASDF item);
    public ArrayList<ASDF> getAllItems();
    public Items getItem(int item_id);
    public void update(ASDF item);
    public void delete(ASDF item);
}
