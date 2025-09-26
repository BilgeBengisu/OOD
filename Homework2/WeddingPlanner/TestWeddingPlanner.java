public class TestWeddingPlanner {
    public static void main(String[] args) {
        System.out.println("Testing Wedding Planner");
        WeddingPlanner planner = WeddingPlanner.getInstance();
        WeddingPackageBuilder builder = new WeddingPackageBuilder();

        System.out.println("Planning Luxury Wedding");
        WeddingFactory weddingFactory = new WeddingFactory();
        WeddingPackage luxury = weddingFactory.getWeddingPackage("Luxury");
        System.out.println(luxury.displayInfo());
    }
}