package ServiceCalculatoare.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Clasa definita pentru a stabili conexiunea la baza de date pao_lab11
    Singleton Pattern
 */
public class DbConnection {
    private static Connection connection;

    private DbConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            //url = protocol:db vendor:db server url/db name
            String url = "jdbc:mysql://localhost:3306/serviceDB";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}