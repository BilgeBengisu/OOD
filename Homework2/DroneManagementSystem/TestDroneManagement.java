public class TestDroneManagement {
    public static void main(String[] args) {
        System.out.println("----- Manufacturer High Speed creating Surveillance Drone with custom inputs -----");

        ManufacturerHighSpeed manufacturerHighSpeed = new ManufacturerHighSpeed();

        Drone surveillanceDrone = manufacturerHighSpeed.createSurveillanceDrone(80,100, 50, "Night Vision");
        surveillanceDrone.displaySpecs();

        System.out.println("----- Manufacturer Long Flight Range creating Agriculture Drone with custom inputs -----");
        ManufacturerLongFlightRange manufacturerLongFlight = new ManufacturerLongFlightRange();
        Drone agricultureDrone = manufacturerLongFlight.createAgriculturalDrone(20, 300, 30, "Sprey");

        agricultureDrone.displaySpecs();

        System.out.println("----- Manufacturer High Battery with custom inputs -----");
        ManufacturerHighBattery manufacturerHighBattery = new ManufacturerHighBattery();
        Drone deliveryDrone = manufacturerHighBattery.createDeliveryDrone(700, 200, 70, "Freezer");
    
        deliveryDrone.displaySpecs();

        System.out.println("Test finished");
    }
}