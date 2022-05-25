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

public class RWServiceMotherboard extends RWServiceGeneric<Motherboard> {
    private static final RWServiceMotherboard instance = new RWServiceMotherboard();

    private RWServiceMotherboard() {
        super("motherboard");
    }

    public static RWServiceMotherboard getInstance() {
        return instance;
    }

    public void add(Motherboard motherboard) {
        String sql = "insert into motherboards values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, motherboard.getModelName());
            statement.setString(2, motherboard.getManufacturer() );
            statement.setInt(3, motherboard.getPowerDrown());
            statement.setString(4, motherboard.getSocket());
            statement.setString(5,motherboard.getMemoryType() );
            statement.setString(6,motherboard.getFormat() );
            statement.setInt(7, motherboard.getNumberOfSata());
            statement.setString(8, motherboard.getChipsetName());
            statement.setInt(9, motherboard.getId());

            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Motherboard> getMotherboardById(int id) {
        String sql = "select * from motherboards va where va.id = ?";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer motherboardId = result.getInt(1);
                String modelName = result.getString(2);
                String manufacturer = result.getString(3);
                Integer powerDrown = result.getInt(4);
                String socket = result.getString(5);
                String memoryType = result.getString(6);
                String format = result.getString(7);
                Integer numberOfSata = result.getInt(8);
                String chipsetName = result.getString(9);
                Integer internalId = result.getInt(10);

                return Optional.of(new Motherboard(motherboardId, modelName, manufacturer, powerDrown, socket, memoryType,format,numberOfSata,chipsetName));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteByDBId(int id){
        String sql = "delete from motherboards where id = ?";
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
