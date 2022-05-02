package ServiceCalculatoare.classes;
import java.util.ArrayList;
import java.util.List;

public class Store {
    ArrayList<Item> storeItems;

    public Store() {
        this.storeItems = new ArrayList<Item>();
    }

    public void setStoreItems(ArrayList<Item> storeItems) {
        this.storeItems = storeItems;
    }

    public ArrayList<Item> getStoreItems() {
        return storeItems;
    }

    public void addStoreItem(Item item){
        storeItems.add(item);
    }

}
