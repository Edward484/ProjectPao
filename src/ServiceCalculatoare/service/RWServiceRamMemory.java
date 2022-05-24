package ServiceCalculatoare.service;

import ServiceCalculatoare.config.DbConnection;
import ServiceCalculatoare.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RWServiceRamMemory extends RWServiceGeneric<RamMemory> {
    private static final RWServiceRamMemory instance = new RWServiceRamMemory();

    private RWServiceRamMemory() {
        super("ramMemory");
    }

    public static RWServiceRamMemory getInstance() {
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
                Integer size = Integer.parseInt(item[4]);
                String memoryType = item[5];
                Integer frequency = Integer.parseInt(item[6]);
                addToStore(new RamMemory(id,modelName,manufacturer,powerDrown,size,memoryType,frequency),store);
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

    public void write(ArrayList<Item> ramMemories) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileTestPathWrite),
                    StandardOpenOption.TRUNCATE_EXISTING);
            writer.write("id,modelName,manufacturer,powerDrown,size,memoryType,frequency\n");
            writer.flush();
            for(Item r : ramMemories) {
                RamMemory ramMemory = (RamMemory) r;
                if(ramMemory != null) {
                    writer.write(ramMemory.getId()+","+ramMemory.getModelName()+","+ramMemory.getManufacturer()+","
                            +ramMemory.getPowerDrown()+","+ramMemory.getSize()+","+ramMemory.getMemoryType()+","+ramMemory.getFrequency()+"\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
