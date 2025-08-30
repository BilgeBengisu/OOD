/** 
 * Define an Order class with the following attributes:
MenuItem item1, item2, item3 (three MenuItem objects representing the items in the order)
double totalAmount (the total cost of the order)
Add methods to the Order class:
addItem1(MenuItem item): Adds a MenuItem to the first slot of the order.
addItem2(MenuItem item): Adds a MenuItem to the second slot of the order.
addItem3(MenuItem item): Adds a MenuItem to the third slot of the order.
calculateTotal(): Calculates the total amount for the order based on the items added.
Create a method called displayOrderDetails that prints out the details of the order, including each item and the total amount.
 */

public class Order {
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;

    private double totalAmount;

    public void addItem1(MenuItem item) {
        this.item1 = item;
    }

    public void addItem2(MenuItem item) {
        this.item2 = item;
    }

    public void addItem3(MenuItem item) {
        this.item3 = item;
    }

    public void calculateTotal() {
        totalAmount = 0;
        if (item1 != null) {
            totalAmount += item1.getPrice();
        }
        if (item2 != null) {
            totalAmount += item2.getPrice();
        }
        if (item3 != null) {
            totalAmount += item3.getPrice();
        }
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        if (item1 != null) {
            item1.displayItemInfo();
        }
        if (item2 != null) {
            item2.displayItemInfo();
        }
        if (item3 != null) {
            item3.displayItemInfo();
        }
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
    }
} 