public class SurveillanceDrone extends Drone {
    private double cameraResolution = 1080;
    private boolean nightVision = true;

    public SurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed,
                             double cameraResolution, boolean nightVision) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.cameraResolution = cameraResolution;
        this.nightVision = nightVision;
    }

    public double getCameraResolution() { return cameraResolution; }
    public boolean hasNightVision() { return nightVision; }
}