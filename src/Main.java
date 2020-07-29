class Main {
    public static void main(String[] args) {
        UserInputReader userInputReader = new UserInputReader();
        UserOutputPrinter userOutputPrinter = new UserOutputPrinter();

        WeatherForecaster weatherForecaster = new WeatherForecaster();


        String cityName = userInputReader.readInputCityName();
        WeatherForecast weatherForecast = weatherForecaster.generateWeatherForecast(cityName);
        userOutputPrinter.printWeatherForecast(weatherForecast);

        // Testing
        System.out.println("These are just a couple of tests:");
        ExceptionMessagePrinter.printExceptionMessage("Please try again!");
    }

}
