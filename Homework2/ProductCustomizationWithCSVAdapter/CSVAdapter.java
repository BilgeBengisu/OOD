public class CSVAdapter {
    public Product toProduct(String csvLine) {
        
        String[] fields = csvLine.split("\t");

        String productName = fields[0];
        String processor = fields[1];
        int ram = Integer.parseInt(fields[2]);
        int storage = Integer.parseInt(fields[3]);
        String integrated = fields[4].isEmpty() ? "N/A" : fields[4];
        String operatingSystem = fields[5];
        double price = Double.parseDouble(fields[6]);

        return new Product(productName, processor, ram, storage,
                           integrated, operatingSystem, price);
    }
}