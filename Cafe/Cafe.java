/**
 * Define a Cafe class with the following attributes:
MenuItem menuItem1, menuItem2, menuItem3 (three MenuItem objects representing the available menu items)
Order currentOrder (an Order object representing the current order being placed)
Add methods to the Cafe class:
addMenuItem1(MenuItem item): Adds a MenuItem to the first slot of the café's menu.
addMenuItem2(MenuItem item): Adds a MenuItem to the second slot of the café's menu.
addMenuItem3(MenuItem item): Adds a MenuItem to the third slot of the café's menu.
placeOrder(Order order): Sets the currentOrder to the given order and calculates the total.
Create a method called displayMenu that prints out all available items in the café’s menu.
 */

public class Cafe {
    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;

    private Order currentOrder;

    public void addMenuItem1(MenuItem item) {
        this.menuItem1 = item;
    }

    public void addMenuItem2(MenuItem item) {
        this.menuItem2 = item;
    }

    public void addMenuItem3(MenuItem item) {
        this.menuItem3 = item;
    }

    public void placeOrder(Order order) {
        this.currentOrder = order;
        this.currentOrder.calculateTotal();
    }

    public void displayMenu() {
        System.out.println("Café Menu:");
        if (menuItem1 != null) {
            menuItem1.displayItemInfo();
        }
        if (menuItem2 != null) {
            menuItem2.displayItemInfo();
        }
        if (menuItem3 != null) {
            menuItem3.displayItemInfo();
        }
    }
}