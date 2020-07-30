package main;

public class UserOutputPrinter {
    public UserOutputPrinter() {

    }

    public void printWeatherForecast(WeatherForecast weatherForecast) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nWeather forecast:\n");
        // Current weather - {Hourly Summary}, Today we will see - {Daily Summary} with a {precipProbability}% chance of rain.
        stringBuilder.append("Current weather - \"" + weatherForecast.getHourly().getSummary() + "\", ");
        stringBuilder.append("Today we will see - \"" + weatherForecast.getDaily().getSummary() + "\" ");
        stringBuilder.append("with a " + weatherForecast.getCurrently().getPrecipProbability() + "% chance of rain.");

        System.out.println(stringBuilder.toString());
    }
}
