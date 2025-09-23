public class WeddingPlanner {
    // Follows Singleton pattern with static instance and private constructor
    static private WeddingPlanner;

    private WeddingPlanner() {
        // TODO
    }

    public getInstance() {
        if (weddingPlanner == null) {
            weddingPlanner = new WeddingPlanner();
        }
        return weddingPlanner;
    }
}
