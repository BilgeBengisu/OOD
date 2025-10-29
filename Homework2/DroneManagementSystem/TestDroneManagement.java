public class TestDroneManagement {
    public static void main(String[] args) {
        System.out.println("----- Manufacturer High Speed creating Surveillance Drone with custom inputs -----");

        ManufacturerA manufacturerA = new ManufacturerA();

        Drone surveillanceDrone = manufacturerA.createSurveillanceDrone(80,100, 50, "Night Vision");
        surveillanceDrone.displaySpecs();

        System.out.println("----- Manufacturer Long Flight Range creating Agriculture Drone with custom inputs -----");
        ManufacturerB manufacturerB = new ManufacturerB();
        Drone agricultureDrone = manufacturerB.createAgriculturalDrone(20, 300, 30, "Sprey");

        agricultureDrone.displaySpecs();

        // System.out.println("----- Manufacturer High Battery with custom inputs -----");
        // ManufacturerC manufacturerC = new ManufacturerC();
        // Drone deliveryDrone = manufacturerC.createDeliveryDrone(700, 200, 70, "Freezer");
    
        // deliveryDrone.displaySpecs();
   
        System.out.println("----- Manufacturer C building rescue drone with custom inputs -----");
        ManufacturerC manufacturerC = new ManufacturerC();
        Drone rescueDrone = manufacturerC.createRescueDrone(150, 250, 60, "Clone");

        rescueDrone.displaySpecs();



        System.out.println("Test finished");
    }
}