// Command interface implemented
public class PredictionCommand implements Command {
    private HurricanePredictionTemplate prediction;

    public PredictionCommand(HurricanePredictionTemplate prediction) {
        this.prediction = prediction;
    }

    @Override
    public void execute() {
        prediction.predictHurricane();  // run the template’s algorithm
    }
}