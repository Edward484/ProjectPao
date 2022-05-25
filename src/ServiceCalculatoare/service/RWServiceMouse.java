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

public class RWServiceMouse extends RWServiceGeneric<Mouse> {
    private static final RWServiceMouse instance = new RWServiceMouse();

    private RWServiceMouse() {
        super("mouse");
    }

    public static RWServiceMouse getInstance() {
        return instance;
    }

    public void add(Mouse mouse) {
        String sql = "insert into mouses values (null, ?, ?, ?, ?, ?,?) ";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, mouse.getModelName());
            statement.setString(2, mouse.getManufacturer());
            statement.setString(3, mouse.getConnectionInterface());
            statement.setInt(4, mouse.getNumberOfButtons());
            statement.setInt(5,mouse.getDpi() );
            statement.setInt(6, mouse.getId());

            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Mouse> getMouseById(int id) {
        String sql = "select * from mouses va where va.id = ?";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer mouseId = result.getInt(1);
                String modelName = result.getString(2);
                String manufacturer = result.getString(3);
                String connesctionInterface = result.getString(4);
                Integer numberOfButtons = result.getInt(5);
                Integer dpi = result.getInt(6);
                Integer internalId = result.getInt(7);

                return Optional.of(new Mouse(mouseId, modelName, manufacturer, connesctionInterface, numberOfButtons, dpi));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateMouseModelNameById(int id, String value) {
        String sql = "update mouses set modelName = ? where id = ?";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(2, id);
            statement.setString(1, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByDBId(int id){
        String sql = "delete from mouses where id = ?";
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
