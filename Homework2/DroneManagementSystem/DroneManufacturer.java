public interface DroneManufacturer {
    // Create different types of drones. Used by manifacturers
    Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed,
                              double payloadCapacity, String deliveryType);

    Drone createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed,
                                 double cameraResolution, boolean nightVision);

    Drone createAgricultureDrone(double batteryCapacity, double flightRange, double maxSpeed,
                                boolean spray, double coverageArea);
}
