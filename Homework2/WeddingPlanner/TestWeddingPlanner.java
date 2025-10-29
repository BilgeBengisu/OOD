public class TestWeddingPlanner {
    public static void main(String[] args) {
        WeddingPlanner planner = WeddingPlanner.getInstance();
        
        WeddingPackageBuilder builder = new WeddingPackageBuilder();
        WeddingFactory weddingFactoryExample = new WeddingFactory();
        WeddingPackage luxuryCustom = weddingFactoryExample.getWeddingPackage("Luxury");
        builder.setWeddingPackage(luxuryCustom)
            .buildVenue("Beach")
            .buildCatering("Gourmet")
            .buildDecoration("No Flowers")
            .buildPhotography("Local Photography");

        builder.build();
        System.out.println(luxuryCustom.displayInfo());

        WeddingPlanner secondInstance = WeddingPlanner.getInstance();
        if (planner == secondInstance) {
            System.out.println("Singleton works, both variables contain the same instance.");
        } else {
            System.out.println("Singleton failed, variables contain different instances.");
        }


        System.out.println("Planning Default Luxury Wedding");
        WeddingFactory weddingFactory = new WeddingFactory();
        WeddingPackage luxury = weddingFactory.getWeddingPackage("Luxury");
        System.out.println(luxury.displayInfo());

        System.out.println("Planning Custom Luxury Wedding");
         WeddingPackage customLuxury = weddingFactory.getWeddingPackage("Luxury");
        builder.setWeddingPackage(customLuxury)
            .buildVenue("BTS Concert")
            .buildCatering("Chickfil-A")
            .buildDecoration("Friendship Bracelets")
            .buildPhotography("Best Friend's Camera");
        builder.build();
        System.out.println(customLuxury.displayInfo());

        System.out.println("Planning Traditional Wedding in India");
        
        WeddingPackage traditional = weddingFactory.getWeddingPackage("Traditional");
        builder.setWeddingPackage(traditional)
            .buildVenue("Banquet Hall")
            .buildCatering("Indian Cuisine")
            .buildDecoration("Marigold Flowers")
            .buildPhotography("Renowned Indian Photographer");
        builder.build();
        System.out.println(traditional.displayInfo());
    }
}