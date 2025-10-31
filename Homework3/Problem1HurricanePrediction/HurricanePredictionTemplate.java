abstract class HurricanePredictionTemplate {
    // template method
    public void predictHurricane() {
        fetchData();
        preprocessData();
        applyPredictionModel();
        postprocessResults();
    }

    // Steps to be implemented by subclasses
    abstract void fetchData();
    abstract void applyPredictionModel();
    abstract void postprocessResults();

    // Common step for all subclasses (optional override in subclasses)
    void preprocessData() {
        System.out.println("preprocessing the data...");
    }
}