// concrete subject - no subject interface in my implementation

import java.util.ArrayList;
import java.util.List;

public class BlackFridayDeals {
    private List<Observer> observers = new ArrayList<>();
    private String deal = "";

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            // only update if the user is subscribed!!
            if (observer instanceof Customer customer && customer.isSubscribed()) {
                observer.update(deal);
            }
        }
    }
    public void setDeal(String deal) {
        this.deal = deal;
        notifyObservers();
    }
}