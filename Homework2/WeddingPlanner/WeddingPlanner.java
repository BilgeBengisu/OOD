/*
 * Singleton, Factory, and Builder Patterns are followed
 * The concrete Wedding Packages are like the recipes with the ingredients
 * The WeddingPackageBuilder is like the chef who chooses which ingredients to include
 */


public class WeddingPlanner {
    // Follows Singleton pattern with static instance and private constructor
    static private WeddingPlanner instance;

    private WeddingPlanner() { }

    // protecting the singleton pattern in case of multi-thread use
    public static synchronized WeddingPlanner getInstance() {
        if (instance == null) {
            instance = new WeddingPlanner();
        }
        return instance;
    }
}
