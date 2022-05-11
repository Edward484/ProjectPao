package ServiceCalculatoare.service;

import ServiceCalculatoare.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class PcShopServices {
    Store store = new Store();
    Generator g = new Generator();


    public void generateNewComponentAndAddToStore() {
        Integer newItemNumber = 1;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to add to the store?");
            System.out.println("Stop = 0 | Keyboard = 7 | GamingMonitor = 8 | Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 | RamMemory = 12 | Item = 1 | ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());

            switch (newItemNumber) {
                case 7:
                    store.addStoreItem(new Keyboard(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateLayout(), g.generateBool()));
                    break;
                case 8:
                    store.addStoreItem(new GamingMonitor(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateRefreshRate(), g.generatEdiagonalList()));
                    break;
                case 9:
                    store.addStoreItem(new Mouse(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateNumberOfButtons(), g.generateDpi()));
                    break;
                case 10:
                    store.addStoreItem(new Motherboard(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateMemoryType(), g.generateFormat(), g.generateNumberOfSata(), g.generateChipsetName()));
                    break;
                case 11:
                    Integer numOfCores = g.generateNumberOfCores();
                    store.addStoreItem(new Processor(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateManufacturingProcess(), numOfCores, numOfCores * 2, g.generateFrequency()));
                    break;
                case 12:
                    store.addStoreItem(new RamMemory(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSize(), g.generateMemoryType(), g.generateFrequency()));
                    break;

            }
        }
    }

    public void showAllElementsInStore() {
        for (Item item : store.getStoreItems()) {
                System.out.println(item);
        }
    }

    public Map<String, ArrayList<Item>> getAllElementsByTypeInStore() {
        store.clearStoreItemsMapped();
        for (Item item : store.getStoreItems()) {
            store.addStoreItemToMap(item);
        }
        return store.getStoreItemsMapped();
    }

    public ArrayList<Item> getAllComponentsOfAType(String type) {
        try {
            Map<String, ArrayList<Item>> store = getAllElementsByTypeInStore();
            for (String key : store.keySet()) {
                if (Objects.equals(key, String.format("ServiceCalculatoare.model.%s", type))) {
                    return store.get(String.format("ServiceCalculatoare.model.%s", type));
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    public void showAllElementsInStoreByType(){
        Map<String, ArrayList<Item>> store = getAllElementsByTypeInStore();
        for (String key : store.keySet()) {
            System.out.println(key);
            for(Item item : store.get(key)){
                System.out.println(item);
            }
            System.out.println();
        }
    }

    public Item getRandomPcPart(String type){
        try{
            ArrayList<Item> t = getAllComponentsOfAType(type);
            Random r = new Random();
            int randomInt = r.nextInt(t.size());
            return t.get(randomInt);
        }
        catch (NullPointerException e){
            System.out.println(String.format("Nu a putut fi gasit acest item in lista %s", type));
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    public void createNewFinalProduct() {
        int newItemNumber = 1;

        while (newItemNumber != 0) {

            System.out.println("What final product would you like to add to the store?");
            System.out.println("Stop = 0 PreBuiltPC = 3 | Laptop = 5 | PrebuildPCFullkit = 6 | ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.parseInt(scanner.nextLine());

            switch (newItemNumber) {
                case 3:
                    store.addStoreItem(new PreBuiltPc(g.generateId(), g.generateModelName(), g.generateManufacturer()
                            ,(Processor) getRandomPcPart("Processor"), (Motherboard) getRandomPcPart("Motherboard"),
                            (RamMemory) getRandomPcPart("RamMemory")));
                    break;
                case 5:
                    Laptop l = new Laptop(g.generateId(), g.generateModelName(), g.generateManufacturer()
                            ,(Processor) getRandomPcPart("Processor"), (Motherboard) getRandomPcPart("Motherboard"),
                            (RamMemory) getRandomPcPart("RamMemory"), g.generateRefreshRate(),g.generatEdiagonalList());
                    store.addStoreItem(l);
                    store.addStoreLaptopsItem(l);
                    break;
                case 6:
                    store.addStoreItem(new PreBuilPcFullKit(g.generateId(), g.generateModelName(), g.generateManufacturer()
                            ,(Processor) getRandomPcPart("Processor"), (Motherboard) getRandomPcPart("Motherboard"),
                            (RamMemory) getRandomPcPart("RamMemory"), g.generateRefreshRate(),g.generatEdiagonalList(),
                            (Mouse) getRandomPcPart("Mouse"), (Keyboard) getRandomPcPart("Keyboard")));
                    break;
            }

        }
    }

    public List<Item> getWorstThreeItemsOfASpecifiedType(String type){
        try {
            ArrayList<Item> arrayList = getAllComponentsOfAType(type);
            Collections.sort(arrayList);
            return arrayList.subList(0,3);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return null;
    }

    public void showAllItemsWithTheSameManufacturer(String wantedManufacturer){
        try{
            ArrayList<Item> arrayList = store.getStoreItems();
            ComparatorItem comparatorItem = new ComparatorItem();
            List<Item> arrayListSameManufacturer = arrayList.stream()
                    .filter(item -> item.getManufacturer().equals(wantedManufacturer))
                    .collect(Collectors.toList());
            for(Item item : arrayListSameManufacturer){
                System.out.println(item);
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public List<Item> getBestThreeItemsOfASpecifiedType(String type){
        try {
            ArrayList<Item> arrayList = getAllComponentsOfAType(type);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            return arrayList.subList(0,3);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return null;
    }

    public void showAllLaptopsInStore() {
        for (Laptop laptop : store.getStoreLaptops()) {
            System.out.println(laptop);
        }
    }

}
