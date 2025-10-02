public class AgricultureDrone extends Drone {
    private boolean spray;
    private double coverageArea;

    public AgricultureDrone createDrone(double batteryCapacity, double flightRange, double maxSpeed,
                             String specialFeature) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.specialFeature;
    }

    public boolean isSpray() { return spray; }
    public double getCoverageArea() { return coverageArea; }

    @Override
    public void displaySpecs() {
        System.out.println("Agricultural Drone -> Battery: " + batteryCapacity + " mAh, "
                + "Range: " + flightRange + " km, "
                + "Max Speed: " + maxSpeed + " km/h, "
                + "Feature: " + specialFeature);
    }
}