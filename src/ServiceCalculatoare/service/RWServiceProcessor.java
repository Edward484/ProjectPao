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

public class RWServiceProcessor {
    private static final String filePath = "resources/data/processor.csv";
    private static final String fileTestPathWrite =  "resources/dataTest/processor.csv";
    private static final RWServiceProcessor instance = new RWServiceProcessor();

    private RWServiceProcessor() {
    }

    public static RWServiceProcessor getInstance() {
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
                Integer manufacturingProcess = Integer.parseInt(item[5]);
                Integer numberOfCores = Integer.parseInt(item[6]);
                Integer numberOfThreads = Integer.parseInt(item[7]);
                Integer frequency = Integer.parseInt(item[8]);
                Processor processor = new Processor(id,modelName,manufacturer,powerDrown,socket,manufacturingProcess,numberOfCores,numberOfThreads,frequency);
                store.addStoreItem(processor);

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

    public void write(ArrayList<Item> processors) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileTestPathWrite),
                    StandardOpenOption.TRUNCATE_EXISTING);
            writer.write("id,modelName,manufacturer,powerDrown,socket,manufacturingProcess,numberOfCores,numberOfThreads,frequency\n");
            writer.flush();
            for(Item p : processors) {
                Processor processor = (Processor) p;
                if(processor != null) {
                    writer.write(processor.getId()+","+processor.getModelName()+","+processor.getManufacturer()+","
                            +processor.getPowerDrown()+","+processor.getSocket()+","+processor.getManufacturingProcess()+","+processor.getNumberOfCores()+
                            ","+processor.getNumberOfThreads()+","+processor.getFrequency()+"\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
