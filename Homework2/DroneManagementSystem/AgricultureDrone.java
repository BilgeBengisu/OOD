public class AgricultureDrone extends Drone {
    public AgricultureDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.specialFeature = specialFeature;
    }

    @Override
    public void displaySpecs() {
        System.out.println("Agricultural Drone -> Battery: " + batteryCapacity + " mAh, "
                + "Range: " + flightRange + " km, "
                + "Max Speed: " + maxSpeed + " km/h, "
                + "Feature: " + specialFeature);
    }
}