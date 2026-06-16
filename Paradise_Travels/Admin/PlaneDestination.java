package Admin;

import java.io.FileWriter;
import java.io.IOException;

public class PlaneDestination {
    public static void saveToFile(String from, String to, String className , String date) {
        try {
            FileWriter writer = new FileWriter("PlaneDestination.txt", true);
            writer.write(from + ";" + to + ";"+ className + ";" + date + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
