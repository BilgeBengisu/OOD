public class CafeTest {
    public static void main(String[] args) {
        // Create menu items
        MenuItem coffee = new MenuItem("Coffee", 3.50, "Beverage");
        MenuItem sandwich = new MenuItem("Sandwich", 5.00, "Food");
        MenuItem cake = new MenuItem("Cake", 4.00, "Dessert");

        // Create a cafe and add menu items
        Cafe cafe = new Cafe();
        cafe.addMenuItem1(coffee);
        cafe.addMenuItem2(sandwich);
        cafe.addMenuItem3(cake);

        // Display the cafe menu
        cafe.displayMenu();

        // Create an order and add items to it
        Order order = new Order();
        order.addItem1(coffee);
        order.addItem2(cake);

        // Place the order
        cafe.placeOrder(order);

        // Display the order details
        order.displayOrderDetails();
    }
}