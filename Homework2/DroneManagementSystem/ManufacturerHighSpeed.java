public class ManufacturerHighSpeed extends Drone {
    private double maxSpeed = 150.0;

    public ManufacturerHighSpeed(String batteryCapacity, String flightRange, String maxSpeed) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.maxSpeed = maxSpeed;
    }
}