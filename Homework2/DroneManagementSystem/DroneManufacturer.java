public interface DroneManufacturer {
    // Create different types of drones. Implementations may override or tune attributes.
    Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed,
                              double payloadCapacity, String deliveryType);

    Drone createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed,
                                 double cameraResolution, boolean nightVision);

    Drone createAgricultureDrone(double batteryCapacity, double flightRange, double maxSpeed,
                                boolean spray, double coverageArea);
}
