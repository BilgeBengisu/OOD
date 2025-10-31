public class StatisticalPrediction extends HurricanePredictionTemplate{
    // uses historical data

    @Override
    void fetchData() {
        System.out.println("fetching historical data for Statistical Prediction");
    }

    @Override
    void preprocessData() {
        System.out.println("preprocessing historical data for Statistical Prediction...");
    }

    @Override
    void applyPredictionModel() {
        System.out.println("Applying Statistical model for prediction.");
    }

    @Override
    void postprocessResults() {
        System.out.println("Results are saved from Statistical Prediction");
    }
}