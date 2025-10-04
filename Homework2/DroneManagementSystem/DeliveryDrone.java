public class DeliveryDrone extends Drone {
    public DeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed,
                         String specialFeature) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.specialFeature = specialFeature;
    }

    @Override
    public void displaySpecs() {
        System.out.println("Delivery Drone -> Battery: " + batteryCapacity + " mAh, "
                + "Range: " + flightRange + " km, "
                + "Max Speed: " + maxSpeed + " km/h, "
                + "Feature: " + specialFeature);
    }
}