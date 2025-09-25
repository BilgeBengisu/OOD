public class AgricultureDrone extends Drone {
    private boolean spray = true;
    private double coverageArea = 100.0;

    public AgricultureDrone() {
        super(batteryCapacity, flightRange, maxSpeed);
        this.spray = spray;
        this.coverageArea = coverageArea;
    }

    public boolean isSpray() { return spray; }
    public double getCoverageArea() { return coverageArea; }
}