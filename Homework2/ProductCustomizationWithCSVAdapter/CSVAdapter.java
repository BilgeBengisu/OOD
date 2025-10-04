import java.util.Map;
import java.util.HashMap;

public class CSVAdapter {
    public Product toProduct(String csvLine) {
        // Split on commas (CSV). This is a simple parser and assumes no embedded commas in fields.
        String[] fields = csvLine.split(",");

        // Trim whitespace from each field
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }

        String productName = fields[0];
        String processor = fields[1];
        int ram = Integer.parseInt(fields[2]);
        int storage = Integer.parseInt(fields[3]);
        String integrated = (fields[4] == null || fields[4].isEmpty()) ? "N/A" : fields[4];
        String operatingSystem = fields[5];
        double price = Double.parseDouble(fields[6]);

        return new Product(productName, processor, ram, storage,
                           integrated, operatingSystem, price);
    }
}