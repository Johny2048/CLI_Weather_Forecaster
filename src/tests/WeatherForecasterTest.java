package tests;

import main.*;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class WeatherForecasterTest {
    private WeatherForecaster weatherForecaster;

    @Before
    public void initialize() {
        weatherForecaster = new WeatherForecaster();
    }

    @Test
    public void test0() {
        WeatherForecast forecast = weatherForecaster.buildWeatherForecastBasedOnResponseString("{\"currently\":{\"precipProbability\":0.1},\"hourly\":{\"summary\":\"It will be sunny.\"},\"daily\":{\"summary\":\"It will still be sunny.\"}}");
        assertTrue(forecast.getCurrently().getPrecipProbability() == 0.1);
        assertTrue(forecast.getHourly().getSummary().equals("It will be sunny."));
        assertTrue(forecast.getDaily().getSummary().equals("It will still be sunny."));
    }

    @Test
    public void test1() {
        WeatherForecast forecast = weatherForecaster.buildWeatherForecastBasedOnResponseString("{\"currently\":{\"precipProbability\":0.05},\"hourly\":{\"summary\":\"It will most probably be raining.\"},\"daily\":{\"summary\":\"Rain. Rain. Rain.\"}}");
        assertTrue(forecast.getCurrently().getPrecipProbability() == 0.05);
        assertTrue(forecast.getHourly().getSummary().equals("It will most probably be raining."));
        assertTrue(forecast.getDaily().getSummary().equals("Rain. Rain. Rain."));
    }

    @Test
    public void test2() {
        WeatherForecast forecast = weatherForecaster.buildWeatherForecastBasedOnResponseString("{\"currently\":{\"precipProbability\":0.2},\"hourly\":{\"summary\":\"SNOW!!!\"},\"daily\":{\"summary\":\"It will snow for about 4 days.\"}}");
        assertTrue(forecast.getCurrently().getPrecipProbability() == 0.2);
        assertTrue(forecast.getHourly().getSummary().equals("SNOW!!!"));
        assertTrue(forecast.getDaily().getSummary().equals("It will snow for about 4 days."));
    }

    @Test
    public void test3() {
        WeatherForecast forecast = weatherForecaster.buildWeatherForecastBasedOnResponseString("{\"currently\":{\"precipProbability\":0.5},\"hourly\":{\"summary\":\"RAINY DAY AHEAD!\"},\"daily\":{\"summary\":\"Umbrella time o'clock.\"}}");
        assertTrue(forecast.getCurrently().getPrecipProbability() == 0.5);
        assertTrue(forecast.getHourly().getSummary().equals("RAINY DAY AHEAD!"));
        assertTrue(forecast.getDaily().getSummary().equals("Umbrella time o'clock."));
    }
}
