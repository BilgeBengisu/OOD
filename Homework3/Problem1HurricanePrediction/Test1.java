public class Test1 {
    public static void main(String[] args) {
        // create objects
        WeatherDataFetcher data = new WeatherDataFetcher();
        ResultsSaver result = new ResultsSaver();

        System.out.println("--- Running Machine Learning Prediction ---");

        // ** --- machine learning prediction -- **
        HurricanePredictionTemplate machineLearningPrediction = new MachineLearningPrediction();

        // create commands
        Command fetchCommand = new FetchDataCommand(data);
        Command predictCommand = new PredictionCommand(machineLearningPrediction);
        Command saveCommand = new SaveResultsCommand(result);

        // set up invoker
        PredictionInvoker invoker = new PredictionInvoker();
        invoker.addCommand(fetchCommand);
        invoker.addCommand(predictCommand);
        invoker.addCommand(saveCommand);

        // execute all commands
        invoker.executeCommands();

        System.out.println("--- Running Statistical Prediction ---");

        // ** --- Statistical prediction -- **

        HurricanePredictionTemplate statisticalPrediction = new StatisticalPrediction();
        Command predictStatistical = new PredictionCommand(statisticalPrediction);
        PredictionInvoker statisticalInvoker = new PredictionInvoker();
        statisticalInvoker.addCommand(new FetchDataCommand(data));
        statisticalInvoker.addCommand(predictStatistical);
        statisticalInvoker.addCommand(saveCommand);
        statisticalInvoker.executeCommands();
    }
}