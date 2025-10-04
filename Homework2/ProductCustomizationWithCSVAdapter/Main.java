import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvPath = "Sample CSV - Sheet1.csv";
        CSVAdapter adapter = new CSVAdapter();
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                // skip header
                if (first) {
                    first = false;
                    continue;
                }
                if (line.trim().isEmpty()) continue;
                Product p = adapter.toProduct(line);
                products.add(p);
            }
        } catch (IOException e) {
            System.err.println("Failed to read CSV: " + e.getMessage());
            return;
        }

        System.out.println("----- Products are being created from the CSV input -----");

        for (Product p : products) {
            System.out.println(p.displaySpecs());
        }
    }
}