package ServiceCalculatoare.service;

import ServiceCalculatoare.classes.Item;
import ServiceCalculatoare.classes.Keyboard;
import ServiceCalculatoare.classes.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class PcShopServices {
    Store store = new Store();
    public void readNewItemAndAddToStore(){
        Integer newItemNumber = 1;
        while(newItemNumber != 0) {
            System.out.println("What item would you like to add to the store?");
            System.out.println("Stop = 0 | Item = 1 | PeripheralPcPart = 2 | PreBuiltPC = 3 | InternalPCPart = 4 | Laptop = 5 | " +
                    "PrebuildPCFullkit = 6 | Keyboard = 7 | GamingMonitor = 8 | Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 | RamMemory = 12 | Item = 1 | ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());
            switch (newItemNumber) {
                case 1:
                    store.addStoreItem(new Item(1, "a", "b"));
                    break;
                case 7:
                    store.addStoreItem(new Keyboard(2, "a", "b", "c", "d", true));
                    break;
            }
            ArrayList<Item> items = store.getStoreItems();
            Keyboard keyboard = (Keyboard) items.get(0);
            System.out.println(keyboard);
        }
    }


}
