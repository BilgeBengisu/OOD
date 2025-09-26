public class SurveillanceDrone implements Drone {
    private double cameraResolution;
    private boolean nightVision;

    public Drone createDrone(double batteryCapacity, double flightRange, double maxSpeed,
                            double cameraResolution, boolean nightVision) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.cameraResolution = cameraResolution;
        this.nightVision = nightVision;
        return this;
    }

    public double getCameraResolution() { return cameraResolution; }
    public boolean hasNightVision() { return nightVision; }
}