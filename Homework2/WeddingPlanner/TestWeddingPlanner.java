public class TestWeddingPlanner {
    public static void main(String[] args) {
        WeddingPlanner planner = WeddingPlanner.getInstance();
        
        WeddingPackageBuilder builder = new WeddingPackageBuilder();

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