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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class RWServiceProcessor extends RWServiceGeneric<Processor> {
    private static final RWServiceProcessor instance = new RWServiceProcessor();

    private RWServiceProcessor() {
        super("processor");
    }

    public static RWServiceProcessor getInstance() {
        return instance;
    }

    public void add(Processor processor) {
        String sql = "insert into processors values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, processor.getModelName());
            statement.setString(2, processor.getManufacturer());
            statement.setInt(3, processor.getPowerDrown());
            statement.setString(4, processor.getSocket());
            statement.setInt(5, processor.getManufacturingProcess());
            statement.setInt(6, processor.getNumberOfCores());
            statement.setInt(7, processor.getNumberOfThreads());
            statement.setInt(8, processor.getFrequency());
            statement.setInt(9, processor.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Processor> getProcessorById(int id) {
        String sql = "select * from processors va where va.id = ?";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer processorId = result.getInt(1);
                String modelName = result.getString(2);
                String manufacturer = result.getString(3);
                Integer powerDrown = result.getInt(4);
                String socket = result.getString(5);
                Integer manProccess = result.getInt(6);
                Integer numberOfCores = result.getInt(7);
                Integer numberOfThreads = result.getInt(8);
                Integer frequency = result.getInt(9);
                Integer internalId = result.getInt(10);

                return Optional.of(new Processor(processorId, modelName, manufacturer, powerDrown, socket, manProccess,numberOfCores,numberOfThreads,frequency));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateProcessorModelNameById(int id, String value) {
        String sql = "update processors set modelName = ? where id = ?";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(2, id);
            statement.setString(1, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByDBId(int id){
        String sql = "delete from processors where id = ?";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
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
                addToStore(new Processor(id,modelName,manufacturer,powerDrown,socket,manufacturingProcess,numberOfCores,numberOfThreads,frequency),store);

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
