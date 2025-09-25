public class DeliveryDrone extends Drone {
    private double payloadCapacity = 5.0;
    private String deliveryType = "Standard";

    public DeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed,
                         double payloadCapacity, String deliveryType) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.payloadCapacity = payloadCapacity;
        this.deliveryType = deliveryType;
    }

    public double getPayloadCapacity() { return payloadCapacity; }
    public String getDeliveryType() { return deliveryType; }
}