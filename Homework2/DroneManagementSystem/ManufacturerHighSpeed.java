public class ManufacturerHighSpeed implements DroneFactory {

    @Override
    public Drone createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new SurveillanceDrone(batteryCapacity, flightRange, maxSpeed, specialFeature);
    }

    @Override
    public Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new DeliveryDrone(batteryCapacity, flightRange, maxSpeed, specialFeature);
    }

    @Override
    public Drone createAgriculturalDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new AgricultureDrone(batteryCapacity, flightRange, maxSpeed, specialFeature);
    }
}