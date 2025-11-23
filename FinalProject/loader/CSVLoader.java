package loader;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVLoader {
    public void loadCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Front: " + values[0] + ", Back: " + values[1] + ", Language: " + values[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}