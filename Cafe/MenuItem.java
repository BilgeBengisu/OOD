public class MenuItem {
    private String name;
    private double price;
    private String category;

    // constructor
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this .category = category;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

    public void setCategory(String category) {
        this.category = category;
    }

    // method to display item info
    public void displayItemInfo() {
        System.out.println("Item: " + name + ", Price: $" + price + ", Category: " + category);
    }
}