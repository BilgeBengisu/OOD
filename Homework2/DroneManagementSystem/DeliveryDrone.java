public class DeliveryDrone extends Drone {
    private double payloadCapacity;
    private String deliveryType;

    public Drone createDrone(double batteryCapacity, double flightRange, double maxSpeed,
                         double payloadCapacity, String deliveryType) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.payloadCapacity = payloadCapacity;
        this.deliveryType = deliveryType;
        return this;
    }

    public double getPayloadCapacity() { return payloadCapacity; }
    public String getDeliveryType() { return deliveryType; }
}