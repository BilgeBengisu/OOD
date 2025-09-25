public class ManifacturerLongFlightRange implements DroneManufacturer {
    private double flightRange = 100.0;

    public ManifacturerLongFlightRange(String batteryCapacity, String flightRange, String maxSpeed) {
        super(batteryCapacity, flightRange, maxSpeed);
        this.flightRange = flightRange;
    }

    public createAgricultureDrone() {
        AgricultureDrone agricultureDrone = new AgricultureDrone();
        agricultureDrone.setFlightRange(this.flightRange);
        return agricultureDrone;
    }
    public createDeliveryDrone() {
        DeliveryDrone deliveryDrone = new DeliveryDrone();
        deliveryDrone.setFlightRange(this.flightRange);
        return deliveryDrone;
    }

    public createSurveillanceDrone() {
        SurveillanceDrone surveillanceDrone = new SurveillanceDrone();
        surveillanceDrone.setFlightRange(this.flightRange);
        return surveillanceDrone;
    }
}