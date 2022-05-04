package ServiceCalculatoare.classes;
import java.util.*;

public class Store {
    ArrayList<Item> storeItems;
    Map<String,ArrayList<Item>> storeItemsMapped;

    public Store() {
        this.storeItems = new ArrayList<Item>();
        this.storeItemsMapped = new HashMap<String,ArrayList<Item>>();
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

    public void clearStoreItemsMapped(){
        storeItemsMapped.clear();
    }

    public void addStoreItemToMap(Item item){
        if(storeItemsMapped.containsKey(item.getClass().getName())){
            storeItemsMapped.get(item.getClass().getName()).add(item);
        }
        else{
            storeItemsMapped.put(item.getClass().getName(), new ArrayList<Item>(Arrays.asList(item)));
        }
    }

    public Map<String, ArrayList<Item>> getStoreItemsMapped() {
        return storeItemsMapped;
    }

    public void setStoreItemsMapped(Map<String, ArrayList<Item>> storeItemsMapped) {
        this.storeItemsMapped = storeItemsMapped;
    }
}
