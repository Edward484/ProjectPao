package ServiceCalculatoare.model;

import java.util.Comparator;

public class ComparatorItem implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        boolean b = o1.manufacturer.equals(o2.manufacturer);
        if(b){
            return 1;
        }
        return -1;
    }
}
