package ServiceCalculatoare.service;

import ServiceCalculatoare.model.Item;
import ServiceCalculatoare.model.Keyboard;
import ServiceCalculatoare.model.Store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Set;

public class RWServiceKeyboard {
    private static final String filePath =  "resources/data/keyboard.csv";
    private static final String fileTestPathWrite =  "resources/dataTest/keyboard.csv";
    private static final RWServiceKeyboard instance = new RWServiceKeyboard();

    private RWServiceKeyboard() {
    }

    private boolean convertToBool(String i){
        int intValue = Integer.parseInt(i);
        if (intValue >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static RWServiceKeyboard getInstance() {
        return instance;
    }

    public void read(Store store){
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            String line = "";
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                Integer id = Integer.parseInt(item[0]);
                String modelName = item[1];
                String manufacturer = item[2];
                String connectionInterface = item[3];
                String layout = item[4];
                Boolean isMechanical = convertToBool(item[5]);
                Keyboard keyboard = new Keyboard(id,modelName,manufacturer,connectionInterface,layout,isMechanical);
                store.addStoreItem(keyboard);

            }
        }
        catch (NoSuchFileException e){
            System.out.println("The file with the path" + filePath + "wasn't found");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

    public void write(ArrayList<Item> keyboards) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileTestPathWrite),
                    StandardOpenOption.TRUNCATE_EXISTING);
            writer.write("id,modelName,manufacturer,connectionInterface,layout,isMechanical\n");
            writer.flush();
            for(Item k : keyboards) {
                Keyboard keyboard = (Keyboard) k;
                if(keyboard != null) {
                    writer.write(keyboard.getId()+","+keyboard.getModelName()+','+keyboard.getManufacturer()+','
                            +keyboard.getConnectionInterface()+','+keyboard.getLayout()+','+ keyboard.getMechanical().compareTo(false)+"\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
