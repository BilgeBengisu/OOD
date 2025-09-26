public abstract class Drone {
    private double batteryCapacity;
    private double flightRange;
    private double maxSpeed;

    public Drone createDrone(double batteryCapacity, double flightRange, double maxSpeed) {
        this.batteryCapacity = batteryCapacity;
        this.flightRange = flightRange;
        this.maxSpeed = maxSpeed;
        return this;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }   

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}