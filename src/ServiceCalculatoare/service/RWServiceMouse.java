package ServiceCalculatoare.service;

import ServiceCalculatoare.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class RWServiceMouse extends RWServiceGeneric<Mouse> {
    private static final RWServiceMouse instance = new RWServiceMouse();

    private RWServiceMouse() {
        super("mouse");
    }

    public static RWServiceMouse getInstance() {
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
                Integer numberOfButtons = Integer.parseInt(item[4]);
                Integer dpi = Integer.parseInt(item[5]);
                addToStore(new Mouse(id,modelName,manufacturer,connectionInterface,numberOfButtons,dpi),store);

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

    public void write(ArrayList<Item> mouses) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileTestPathWrite),
                    StandardOpenOption.TRUNCATE_EXISTING);
            writer.write("id,modelName,manufacturer,powerDrown,socket,memoryType,format,numberOfSata,chipsetName\n");
            writer.flush();
            for(Item m : mouses) {
                Mouse mouse = (Mouse) m;
                if(mouse != null) {
                    writer.write(mouse.getId()+","+mouse.getModelName()+","+mouse.getManufacturer()+","
                            +mouse.getConnectionInterface()+","+mouse.getNumberOfButtons()+","+mouse.getDpi()+"\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
