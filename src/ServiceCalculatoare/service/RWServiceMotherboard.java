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

public class RWServiceMotherboard extends RWServiceGeneric<Motherboard> {
    private static final RWServiceMotherboard instance = new RWServiceMotherboard();

    private RWServiceMotherboard() {
        super("motherboard");
    }

    public static RWServiceMotherboard getInstance() {
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
                Integer powerDrown = Integer.parseInt(item[3]);
                String socket = item[4];
                String memoryType = item[5];
                String format = item[6];
                Integer numberOfSata = Integer.parseInt(item[7]);
                String chipsetName = item[8];
                addToStore(new Motherboard(id,modelName,manufacturer,powerDrown,socket,memoryType,format,numberOfSata,chipsetName),store);

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

    public void write(ArrayList<Item> motherboards) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileTestPathWrite),
                    StandardOpenOption.TRUNCATE_EXISTING);
            writer.write("id,modelName,manufacturer,powerDrown,socket,memoryType,format,numberOfSata,chipsetName\n");
            writer.flush();
            for(Item m : motherboards) {
                Motherboard motherboard = (Motherboard) m;
                if(motherboard != null) {
                    writer.write(motherboard.getId()+","+motherboard.getModelName()+","+motherboard.getManufacturer()+","
                            +motherboard.getPowerDrown()+","+motherboard.getSocket()+","+motherboard.getMemoryType()+","+motherboard.getFormat()+
                            ","+motherboard.getNumberOfSata()+","+motherboard.getChipsetName()+"\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
