public interface DroneFactory {
    Drone createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature);
    Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature);
    Drone createAgriculturalDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature);
}