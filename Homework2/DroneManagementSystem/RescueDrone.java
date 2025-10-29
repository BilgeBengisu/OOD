public class RescueDrone extends Drone {
    public RescueDrone(double batteryCapacity, double flightRange, double maxSpeed,
                         String specialFeature) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.specialFeature = specialFeature;
    }

    @Override
    public void displaySpecs() {
        System.out.println("Rescue Drone -> Battery: " + batteryCapacity + " mAh, "
                + "Range: " + flightRange + " km, "
                + "Max Speed: " + maxSpeed + " km/h, "
                + "Feature: " + specialFeature);
    }
}