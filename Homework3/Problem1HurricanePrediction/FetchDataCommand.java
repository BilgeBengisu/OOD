// Command interface implemented
public class FetchDataCommand implements Command {
    private WeatherDataFetcher data;

    public FetchDataCommand(WeatherDataFetcher data) {
        this.data = data;
    }

    @Override
    public void execute(){
        data.fetchData();
    }
}