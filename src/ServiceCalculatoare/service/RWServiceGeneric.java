package ServiceCalculatoare.service;

import ServiceCalculatoare.model.Item;
import ServiceCalculatoare.model.RamMemory;
import ServiceCalculatoare.model.Store;

import java.util.ArrayList;

public class RWServiceGeneric<T> {
    protected String filePath = "";
    protected String fileTestPathWrite =  "";

    RWServiceGeneric(String name) {
        this.filePath = "resources/data/" + name + ".csv";
        this.fileTestPathWrite = "resources/dataTest/"+name + ".csv";
    }

    public void read(Store store){}
    public void write(ArrayList<Item> ramMemories) {}
    protected void addToStore(T item,Store store){
        store.addStoreItem((Item) item);
    }
}
