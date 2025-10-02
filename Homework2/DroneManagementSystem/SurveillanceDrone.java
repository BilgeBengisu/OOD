public class SurveillanceDrone extends Drone {
    private double cameraResolution;
    private boolean nightVision;

    public SurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed,
                             String specialFeature) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.specialFeature = specialFeature;
    }

    public double getCameraResolution() { return cameraResolution; }
    public boolean hasNightVision() { return nightVision; }

    @Override
    public void displaySpecs() {
        System.out.println("Surveillance Drone -> Battery: " + batteryCapacity + " mAh, "
                + "Range: " + flightRange + " km, "
                + "Max Speed: " + maxSpeed + " km/h, "
                + "Feature: " + specialFeature);
    }
}