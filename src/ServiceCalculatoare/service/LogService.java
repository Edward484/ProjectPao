package ServiceCalculatoare.service;
import java.sql.Timestamp;
import java.util.Date;
import java.io.*;
import java.nio.file.*;

public class LogService {
    private static final String filePath ="resources/logs/logs.csv";

    public void  createNewLog(String log){
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath),
                    StandardOpenOption.APPEND);
            Timestamp timestamp = new Timestamp(new Date().getTime());
            writer.write(log + " , " + timestamp + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
