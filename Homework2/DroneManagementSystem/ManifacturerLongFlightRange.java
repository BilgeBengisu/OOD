public class ManifacturerLongFlightRange implements DroneManufacturer {

    private double flightRange;

    // ??? creating extra agriculture object ????
    public Drone createAgricultureDrone(double batteryCapacity, double flightRange, double maxSpeed,
                                  double cameraResolution, boolean nightVision) {
        agricultureDrone = super(double batteryCapacity, double flightRange, double maxSpeed,
                                  double cameraResolution, boolean nightVision);
        agricultureDrone.setFlightRange(this.flightRange);
        return agricultureDrone;
    }

    public Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed,
                              double payloadCapacity, String deliveryType) {
        deliveryDrone = super(double batteryCapacity, double flightRange, double maxSpeed,
                              double payloadCapacity, String deliveryType);
        deliveryDrone.setFlightRange(this.flightRange);
        return deliveryDrone;
    }

    public createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed,
                            double cameraResolution, boolean nightVision) {
        surveillanceDrone = super(double batteryCapacity, double flightRange, double maxSpeed,
                            double cameraResolution, boolean nightVision);
        deliveryDrone.setFlightRange(this.flightRange);
        return deliveryDrone;
    }
}