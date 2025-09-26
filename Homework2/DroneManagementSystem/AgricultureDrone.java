public class AgricultureDrone extends Drone {
    private boolean spray;
    private double coverageArea;

    public Drone AgricultureDrone() {
        super(batteryCapacity, flightRange, maxSpeed);
        this.spray = spray;
        this.coverageArea = coverageArea;
        return this;
    }

    public boolean isSpray() { return spray; }
    public double getCoverageArea() { return coverageArea; }
}