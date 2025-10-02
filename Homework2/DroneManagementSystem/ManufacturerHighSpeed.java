public class ManufacturerHighSpeed extends Drone {
    @Override
    public Drone createSurveillanceDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new SurveillanceDrone(specialFeature)
                .createDrone(battery, flightRange, maxSpeed); 
    }

    @Override
    public Drone createDeliveryDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new SurveillanceDrone(specialFeature)
                .createDrone(battery, flightRange, maxSpeed); 
    }

    @Override
    public createAgricultureDrone(double batteryCapacity, double flightRange, double maxSpeed, String specialFeature) {
        return new AgricultureDrone(specialFeature)
                .createDrone(battery, flightRange, maxSpeed); 
    }
}