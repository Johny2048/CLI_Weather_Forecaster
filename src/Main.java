class Main {
    public static void main(String[] args) {
        UserInputReader userInputReader = new UserInputReader();
        UserOutputPrinter userOutputPrinter = new UserOutputPrinter();
        WeatherForecaster weatherForecaster = new WeatherForecaster();

        // Task 1
        WeatherForecast weatherForecast = weatherForecaster.generateWeatherForecast(60.59329987, -1.44250533);

//        // Task 2
//        String cityName = userInputReader.readInputCityName();
//        WeatherForecast weatherForecast = weatherForecaster.generateWeatherForecast(cityName);

        // Task 3

        userOutputPrinter.printWeatherForecast(weatherForecast);
    }
}
