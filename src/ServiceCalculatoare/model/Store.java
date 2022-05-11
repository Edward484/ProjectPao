package ServiceCalculatoare.model;
import java.util.*;

public class Store {
    ArrayList<Item> storeItems;
    ArrayList<Laptop> storeLaptops;
    Map<String,ArrayList<Item>> storeItemsMapped;

    public Store() {
        this.storeItems = new ArrayList<Item>();
        this.storeLaptops = new ArrayList<Laptop>(){
            public boolean add(Laptop item){
                int index = Collections.binarySearch(this, item);
                if (index < 0) index = ~index;
                super.add(index, item);
                return true;
            }
        };
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

    public ArrayList<Laptop> getStoreLaptops() {
        return storeLaptops;
    }

    public void addStoreLaptopsItem(Laptop laptop){
        storeLaptops.add(laptop);
    }

    public void setStoreLaptops(ArrayList<Laptop> storeLaptops) {
        this.storeLaptops = storeLaptops;
    }

    public Map<String, ArrayList<Item>> getStoreItemsMapped() {
        return storeItemsMapped;
    }

    public void setStoreItemsMapped(Map<String, ArrayList<Item>> storeItemsMapped) {
        this.storeItemsMapped = storeItemsMapped;
    }
}
