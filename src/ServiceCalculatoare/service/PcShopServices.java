package ServiceCalculatoare.service;

import ServiceCalculatoare.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class PcShopServices {
    Store store = new Store();
    Generator g = new Generator();
    LogService logService = new LogService();


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
                    logService.createNewLog("Created new keyboard");
                    break;
                case 8:
                    store.addStoreItem(new GamingMonitor(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateRefreshRate(), g.generateDiagonalList()));
                    logService.createNewLog("Created new GamingMonitor");
                    break;
                case 9:
                    store.addStoreItem(new Mouse(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateNumberOfButtons(), g.generateDpi()));
                    logService.createNewLog("Created new Mouse");
                    break;
                case 10:
                    store.addStoreItem(new Motherboard(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateMemoryType(), g.generateFormat(), g.generateNumberOfSata(), g.generateChipsetName()));
                    logService.createNewLog("Created new Motherboard");
                    break;
                case 11:
                    Integer numOfCores = g.generateNumberOfCores();
                    store.addStoreItem(new Processor(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateManufacturingProcess(), numOfCores, numOfCores * 2, g.generateFrequency()));
                    logService.createNewLog("Created new Processor");
                    break;
                case 12:
                    store.addStoreItem(new RamMemory(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSize(), g.generateMemoryType(), g.generateFrequency()));
                    logService.createNewLog("Created new RamMemory");
                    break;

            }
        }
    }

    public void showAllElementsInStore() {
        for (Item item : store.getStoreItems()) {
                System.out.println(item);
        }

        logService.createNewLog("Displayed all items");
    }

    public Map<String, ArrayList<Item>> getAllElementsByTypeInStore() {
        store.clearStoreItemsMapped();
        for (Item item : store.getStoreItems()) {
            store.addStoreItemToMap(item);
        }
        logService.createNewLog("Requested all items");
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
        logService.createNewLog("Requested all items of type" + type);
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

        logService.createNewLog("Requested a random pc part");
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
                    logService.createNewLog("Created new PreBuiltPc");
                    break;
                case 5:
                    Laptop l = new Laptop(g.generateId(), g.generateModelName(), g.generateManufacturer()
                            ,(Processor) getRandomPcPart("Processor"), (Motherboard) getRandomPcPart("Motherboard"),
                            (RamMemory) getRandomPcPart("RamMemory"), g.generateRefreshRate(),g.generateDiagonalList());
                    logService.createNewLog("Created new Laptop");
                    store.addStoreItem(l);
                    store.addStoreLaptopsItem(l);
                    break;
                case 6:
                    store.addStoreItem(new PreBuilPcFullKit(g.generateId(), g.generateModelName(), g.generateManufacturer()
                            ,(Processor) getRandomPcPart("Processor"), (Motherboard) getRandomPcPart("Motherboard"),
                            (RamMemory) getRandomPcPart("RamMemory"), g.generateRefreshRate(),g.generateDiagonalList(),
                            (Mouse) getRandomPcPart("Mouse"), (Keyboard) getRandomPcPart("Keyboard")));
                    logService.createNewLog("Created new PreBuilPcFullKit");
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

        logService.createNewLog("Requested worst three items of type" + type);

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

            logService.createNewLog("Requested to show all items with the same manufacturer");

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
            logService.createNewLog("Requested best three items of type" + type);
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
        logService.createNewLog("Requested to show all laptops in store");

    }



    public void readFromCSV() {
        RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
        rwServiceKeyboard.read(store);
        RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
        rwServiceMouse.read(store);
        RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
        rwServiceProcessor.read(store);
        RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
        rwServiceMotherboard.read(store);
        RWServiceRamMemory rwServiceRamMemory = RWServiceRamMemory.getInstance();
        rwServiceRamMemory.read(store);
        logService.createNewLog("Read from CSV");

    }

    public void writeToCSV() {
        RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
        rwServiceKeyboard.write(getAllComponentsOfAType("Keyboard"));
        RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
        rwServiceMotherboard.write(getAllComponentsOfAType("Motherboard"));
        RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
        rwServiceMouse.write(getAllComponentsOfAType("Mouse"));
        RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
        rwServiceProcessor.write(getAllComponentsOfAType("Processor"));
        RWServiceRamMemory rwServiceRamMemory = RWServiceRamMemory.getInstance();
        rwServiceRamMemory.write(getAllComponentsOfAType("RamMemory"));
        logService.createNewLog("Write to CSV");
    }

    public void generateNewComponentAndAddToStoreAndDB() {
        Integer newItemNumber = 1;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to add to the store?");
            System.out.println("Stop = 0 | Keyboard = 7 |  Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 | ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());

            switch (newItemNumber) {
                case 7:
                    RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
                    Keyboard k = new Keyboard(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateLayout(), g.generateBool());
                    store.addStoreItem(k);
                    rwServiceKeyboard.add(k);
                    logService.createNewLog("Created new keyboard");
                    break;
                case 9:
                    RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
                    Mouse m = new Mouse(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generateConnectionInterface(),
                            g.generateNumberOfButtons(), g.generateDpi());
                    store.addStoreItem(m);
                    rwServiceMouse.add(m);
                    logService.createNewLog("Created new Mouse");
                    break;
                case 10:
                    RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
                    Motherboard mobo = new Motherboard(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateMemoryType(), g.generateFormat(), g.generateNumberOfSata(), g.generateChipsetName());
                    store.addStoreItem(mobo);
                    rwServiceMotherboard.add(mobo);
                    logService.createNewLog("Created new Motherboard");
                    break;
                case 11:
                    RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
                    Integer numOfCores = g.generateNumberOfCores();
                    Processor p = new Processor(g.generateId(), g.generateModelName(), g.generateManufacturer(), g.generatePowerDrown(),
                            g.generateSocket(), g.generateManufacturingProcess(), numOfCores, numOfCores * 2, g.generateFrequency());
                    store.addStoreItem(p);
                    rwServiceProcessor.add(p);
                    logService.createNewLog("Created new Processor");
                    break;

            }
        }
    }

    public void deleteFromDatabase(){
        Integer newItemNumber = 1;
        int id =0;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to remove from db?");
            System.out.println("Stop = 0 | Keyboard = 7 |  Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());

            switch (newItemNumber) {
                case 7:
                    RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
                    System.out.println("The id of the object you want to delete: ");
                    id = Integer.valueOf(scanner.nextLine());
                    rwServiceKeyboard.deleteByDBId(id);
                    logService.createNewLog("Deleted a keyboard");
                    break;
                case 9:
                    RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
                    System.out.println("The id of the object you want to delete: ");
                    id = Integer.valueOf(scanner.nextLine());
                    rwServiceMouse.deleteByDBId(id);
                    logService.createNewLog("Deleted a Mouse");
                    break;
                case 10:
                    RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
                    System.out.println("The id of the object you want to delete: ");
                    id = Integer.valueOf(scanner.nextLine());
                    rwServiceMotherboard.deleteByDBId(id);
                    logService.createNewLog("Deleted a Motherboard");
                    break;
                case 11:
                    RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
                    System.out.println("The id of the object you want to delete: ");
                    id = Integer.valueOf(scanner.nextLine());
                    rwServiceProcessor.deleteByDBId(id);
                    logService.createNewLog("Deleted a Processor");
                    break;

            }
        }
    }

    public void getAnItemFromDB(){
        Integer newItemNumber = 1;
        int id =0;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to get from the store?");
            System.out.println("Stop = 0 | Keyboard = 7 |  Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());

            switch (newItemNumber) {
                case 7:
                    RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
                    System.out.println("The id of the object you want to get: ");
                    id = Integer.valueOf(scanner.nextLine());
                    Optional<Keyboard> retrivedKB = rwServiceKeyboard.getKeyboardById(id);
                    System.out.println("The keyboard from db is:");
                    System.out.println(retrivedKB);
                    logService.createNewLog("Retrieved a keyboard from db");
                    break;
                case 9:
                    RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
                    System.out.println("The id of the object you want to get: ");
                    id = Integer.valueOf(scanner.nextLine());
                    Optional<Mouse> retrivedMouse = rwServiceMouse.getMouseById(id);
                    System.out.println("The mouse from db is:");
                    System.out.println(retrivedMouse);
                    logService.createNewLog("Retrieved a mouse from db");
                    break;
                case 10:
                    RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
                    System.out.println("The id of the object you want to get: ");
                    id = Integer.valueOf(scanner.nextLine());
                    Optional<Motherboard> retrivedMobo = rwServiceMotherboard.getMotherboardById(id);
                    System.out.println("The motherboard from db is:");
                    System.out.println(retrivedMobo);
                    logService.createNewLog("Retrieved a motherboard from db");
                    break;
                case 11:
                    RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
                    System.out.println("The id of the object you want to get: ");
                    id = Integer.valueOf(scanner.nextLine());
                    Optional<Processor> retrivedProc = rwServiceProcessor.getProcessorById(id);
                    System.out.println("The processor from db is:");
                    System.out.println(retrivedProc);
                    logService.createNewLog("Retrieved a processor from db");
                    break;

            }
        }
    }

    public void updateAnItemFromDB(){
        Integer newItemNumber = 1;
        int id =0;
        String value;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to update from the store?");
            System.out.println("Stop = 0 | Keyboard = 7 |  Mouse = 9 | Motherboard = 10 | " +
                    "Processor = 11 ");
            System.out.print("Obiectul dorit: ");
            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.valueOf(scanner.nextLine());

            switch (newItemNumber) {
                case 7:
                    RWServiceKeyboard rwServiceKeyboard = RWServiceKeyboard.getInstance();
                    System.out.println("The id of the object you want to update: ");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("The new value of the field: ");
                    value = scanner.nextLine();
                    rwServiceKeyboard.updateKeyboardModelNameById(id,value);
                    Optional<Keyboard> retrivedKB = rwServiceKeyboard.getKeyboardById(id);
                    System.out.println("The updated keyboard from db is:");
                    System.out.println(retrivedKB);
                    logService.createNewLog("Modified a keyboard in db");
                    break;
                case 9:
                    RWServiceMouse rwServiceMouse = RWServiceMouse.getInstance();
                    System.out.println("The id of the object you want to update: ");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("The new value of the field: ");
                    value = scanner.nextLine();
                    rwServiceMouse.updateMouseModelNameById(id,value);
                    Optional<Mouse> retrivedMouse = rwServiceMouse.getMouseById(id);
                    System.out.println("The mouse from db is:");
                    System.out.println(retrivedMouse);
                    logService.createNewLog("Modified a mouse in db");
                    break;
                case 10:
                    RWServiceMotherboard rwServiceMotherboard = RWServiceMotherboard.getInstance();
                    System.out.println("The id of the object you want to update: ");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("The new value of the field: ");
                    value = scanner.nextLine();
                    rwServiceMotherboard.updateMotherboardModelNameById(id,value);
                    Optional<Motherboard> retrivedMobo = rwServiceMotherboard.getMotherboardById(id);
                    System.out.println("The motherboard from db is:");
                    System.out.println(retrivedMobo);
                    logService.createNewLog("Modified a motherboard in db");
                    break;
                case 11:
                    RWServiceProcessor rwServiceProcessor = RWServiceProcessor.getInstance();
                    System.out.println("The id of the object you want to update: ");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("The new value of the field: ");
                    value = scanner.nextLine();
                    rwServiceProcessor.updateProcessorModelNameById(id,value);
                    Optional<Processor> retrivedProc = rwServiceProcessor.getProcessorById(id);
                    System.out.println("The processor from db is:");
                    System.out.println(retrivedProc);
                    logService.createNewLog("Modified a processor in db");
                    break;

            }
        }
    }
}
