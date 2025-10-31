public class MachineLearningPrediction extends HurricanePredictionTemplate {
    // uses historical and real-time data
    @Override
    void fetchData() {
        System.out.println("fetching historical and real-time data for Machine Learning Prediction");
    }

    @Override
    void preprocessData() {
        System.out.println("preprocessing combined historical and real-time data for Machine Learning Prediction...");
    }

    @Override
    void applyPredictionModel() {
        System.out.println("Applying Machine Learning model for prediction.");
    }

    @Override
    void postprocessResults() {
        System.out.println("Results are saved from Machine Learning Prediction");
    }
}