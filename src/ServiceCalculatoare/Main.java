package ServiceCalculatoare;

import ServiceCalculatoare.model.Item;
import ServiceCalculatoare.service.PcShopServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PcShopServices service = new PcShopServices();
        service.readFromCSV();

        int newItemNumber = 1;

        while (newItemNumber != 0) {

            System.out.println("What item would you like to add to the store?");
            System.out.println("Stop = 0\ngenerateNewComponentAndAddToStore = 1\nshowAllElementsInStoreByType = 2\ngetAllElementsByTypeInStore = 3\n" +
                    "getAllComponentsOfAType = 4\nshowAllElementsInStore = 5\ngetRandomPcPart = 6\ncreateNewFinalProduct = 7\n" +
                    "getBestThreeItemsOfASpecifiedType = 8\nshowAllItemsWithTheSameManufacturer = 9\ngetBestThreeItemsOfASpecifiedType = 10\n" +
                    "showAllLaptopsInStoreSortedFromWorstToBest = 11\nreadFromCSV = 12\nwriteToCSV = 13\ngenerateNewComponentAndAddToStoreAndDB = 14\n" +
                    "deleteFromDatabase = 15\ngetAnItemFromDB = 16\nupdateAnItemFromDB = 17");
            System.out.print("Obiectul dorit: ");

            Scanner scanner = new Scanner(System.in);
            newItemNumber = Integer.parseInt(scanner.nextLine());

            switch (newItemNumber) {
                case 1:
                    service.generateNewComponentAndAddToStore();
                    break;
                case 2:
                    service.showAllElementsInStoreByType();
                    break;
                case 3:
                    service.getAllElementsByTypeInStore();
                    break;
                case 4:
                    System.out.print("Introduceti tipul obiectului dorit: ");
                    String type = scanner.nextLine();
                    ArrayList<Item> listT = service.getAllComponentsOfAType(type);
                    System.out.println("Produsele dorite: ");
                    for(Item item : listT){
                        System.out.println(item);
                    }
                    break;
                case 5:
                    service.showAllElementsInStore();
                    break;
                case 6:
                    System.out.print("Introduceti tipul obiectului dorit: ");
                    String type1 = scanner.nextLine();
                    Item t = service.getRandomPcPart(type1);
                    System.out.println(t);
                    break;
                case 7:
                    service.createNewFinalProduct();
                    break;
                case 8:
                    System.out.print("Introduceti tipul obiectului dorit: ");
                    String type2 = scanner.nextLine();
                    List<Item> listT1 = service.getWorstThreeItemsOfASpecifiedType(type2);
                    for(Item item : listT1){
                        System.out.println(item);
                    }
                    break;
                case 9:
                    System.out.print("Introduceti producatorul dorit: ");
                    String type3 = scanner.nextLine();
                    service.showAllItemsWithTheSameManufacturer(type3);
                    break;
                case 10:
                    System.out.print("Introduceti tipul obiectului dorit: ");
                    String type4 = scanner.nextLine();
                    List<Item> listT4 = service.getBestThreeItemsOfASpecifiedType(type4);
                    for(Item item : listT4){
                        System.out.println(item);
                    }
                    break;
                case 11:
                    service.showAllLaptopsInStore();
                    break;
                case 12:
                    service.readFromCSV();
                    break;
                case 13:
                    service.writeToCSV();
                case 14:
                    service.generateNewComponentAndAddToStoreAndDB();
                    break;
                case 15:
                    service.deleteFromDatabase();
                case 16:
                    service.getAnItemFromDB();
                case 17:
                    service.updateAnItemFromDB();
            }
        }

    }
}
