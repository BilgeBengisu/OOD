// Command interface implemented
public class SaveResultsCommand implements Command {
    private ResultsSaver results;

    public SaveResultsCommand(ResultsSaver results) {
        this.results = results;
    }

    @Override
    public void execute(){
        results.saveResult();
    }
}