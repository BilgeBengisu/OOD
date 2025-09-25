public class ManifacturerHighBattery extends Drone {
    private double batteryCapacity = 100;

    public ManifacturerHighBattery(String batteryCapacity, String flightRange, String maxSpeed) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }
}