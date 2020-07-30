public class WeatherForecast {
    private AtomicForecast currently;
    private SubForecast hourly;
    private SubForecast daily;

    public AtomicForecast getCurrently() {
        return currently;
    }

    public SubForecast getHourly() {
        return hourly;
    }

    public SubForecast getDaily() {
        return daily;
    }
}
