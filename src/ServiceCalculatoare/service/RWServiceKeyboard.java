package ServiceCalculatoare.service;

import ServiceCalculatoare.config.DbConnection;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class RWServiceKeyboard extends RWServiceGeneric<Keyboard> {
    private static final RWServiceKeyboard instance = new RWServiceKeyboard();

    private RWServiceKeyboard() {
        super("keyboard");
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

    public void add(Keyboard keyboard) {
        String sql = "insert into keyboards values (null, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, keyboard.getLayout());
            statement.setBoolean(2, keyboard.getMechanical());
            statement.setString(3, keyboard.getConnectionInterface());
            statement.setString(4, keyboard.getModelName());
            statement.setString(5, keyboard.getManufacturer());
            statement.setInt(6, keyboard.getId());

            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Keyboard> getKeyboardById(int id) {
        String sql = "select * from keyboards va where va.id = ?";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer keyboardId = result.getInt(1);
                String layout = result.getString(2);
                Boolean isMechanichal = result.getBoolean(3);
                String connesctionInterface = result.getString(4);
                String modelName = result.getString(5);
                String manufacturer = result.getString(6);
                Integer internalId = result.getInt(7);

                return Optional.of(new Keyboard(keyboardId, modelName, manufacturer, connesctionInterface, layout, isMechanichal));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateKeyboardModelNameById(int id, String value) {
        String sql = "update keyboards set modelName = ? where id = ?";
        try (PreparedStatement statement = DbConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(2, id);
            statement.setString(1, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteByDBId(int id){
        String sql = "delete from keyboards where id = ?";
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
                String layout = item[4];
                Boolean isMechanical = convertToBool(item[5]);
                addToStore(new Keyboard(id,modelName,manufacturer,connectionInterface,layout,isMechanical),store);

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
