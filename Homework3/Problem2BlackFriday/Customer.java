// subscribes to BlackFridayDeals notifications

public class Customer implements Observer {
    private String name;
    private String deal;
    private boolean isSubscribed;

    public Customer(String name, boolean isSubscribed) {
        this.name = name;
        this.isSubscribed = isSubscribed;
    }

    public void receiveNotification(String deal) {
        System.out.println(name + " received deal notification: " + deal);
    }

    @Override
    public void update(String deal) {
        this.deal = deal;
        display();
    }

    private void display() {
        System.out.println("Customer " + getName() + " has the Black Friday deal " + deal);
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public String getName() {
        return name;
    }
}