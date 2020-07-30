import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherForecaster {
    private static final String apiKey = "1a43d545710c14571dbbe87b13bad8c7";

    public WeatherForecaster() {

    }

    private String getResponseString(double latitude, double longitude) {
        String responseString = null;
        String uri = "https://api.darksky.net/forecast/" + apiKey + "/" + latitude + "," + longitude;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseString = httpResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return responseString;
    }

    private WeatherForecast buildWeatherForecastBasedOnResponseString(String responseString) {
        WeatherForecast weatherForecast = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            weatherForecast = objectMapper.readValue(responseString, WeatherForecast.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return weatherForecast;
    }

    public WeatherForecast generateWeatherForecast(double latitude, double longitude) {
//        String responseString = getResponseString(latitude, longitude);
        String responseString = "{\"latitude\":60.59329987,\"longitude\":-1.44250533,\"timezone\":\"Europe/London\",\"currently\":{\"time\":1596115026,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.76,\"apparentTemperature\":54.76,\"dewPoint\":51.92,\"humidity\":0.9,\"pressure\":1016.2,\"windSpeed\":6.63,\"windGust\":6.94,\"windBearing\":321,\"cloudCover\":0.57,\"uvIndex\":4,\"visibility\":10,\"ozone\":333.4},\"hourly\":{\"summary\":\"Windy tomorrow afternoon and evening.\",\"icon\":\"wind\",\"data\":[{\"time\":1596114000,\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.63,\"apparentTemperature\":54.63,\"dewPoint\":51.94,\"humidity\":0.91,\"pressure\":1016.2,\"windSpeed\":7.06,\"windGust\":7.49,\"windBearing\":321,\"cloudCover\":0.62,\"uvIndex\":4,\"visibility\":10,\"ozone\":334.6},{\"time\":1596117600,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.1,\"apparentTemperature\":55.1,\"dewPoint\":51.89,\"humidity\":0.89,\"pressure\":1016.4,\"windSpeed\":5.59,\"windGust\":5.73,\"windBearing\":321,\"cloudCover\":0.44,\"uvIndex\":4,\"visibility\":10,\"ozone\":330.1},{\"time\":1596121200,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.75,\"apparentTemperature\":55.75,\"dewPoint\":52,\"humidity\":0.87,\"pressure\":1016.6,\"windSpeed\":4.28,\"windGust\":4.38,\"windBearing\":332,\"cloudCover\":0.34,\"uvIndex\":3,\"visibility\":10,\"ozone\":326},{\"time\":1596124800,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":56.28,\"apparentTemperature\":56.28,\"dewPoint\":52.14,\"humidity\":0.86,\"pressure\":1016.4,\"windSpeed\":2.96,\"windGust\":3.13,\"windBearing\":5,\"cloudCover\":0.38,\"uvIndex\":2,\"visibility\":10,\"ozone\":322.8},{\"time\":1596128400,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":56.21,\"apparentTemperature\":56.21,\"dewPoint\":51.84,\"humidity\":0.85,\"pressure\":1016.2,\"windSpeed\":1.82,\"windGust\":2.55,\"windBearing\":82,\"cloudCover\":0.5,\"uvIndex\":1,\"visibility\":10,\"ozone\":319.9},{\"time\":1596132000,\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.98,\"apparentTemperature\":55.98,\"dewPoint\":51.73,\"humidity\":0.86,\"pressure\":1016.1,\"windSpeed\":1.43,\"windGust\":2.78,\"windBearing\":106,\"cloudCover\":0.62,\"uvIndex\":1,\"visibility\":10,\"ozone\":317.3},{\"time\":1596135600,\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.7,\"apparentTemperature\":55.7,\"dewPoint\":51.86,\"humidity\":0.87,\"pressure\":1016.1,\"windSpeed\":2.07,\"windGust\":3.42,\"windBearing\":115,\"cloudCover\":0.76,\"uvIndex\":0,\"visibility\":10,\"ozone\":315},{\"time\":1596139200,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.47,\"apparentTemperature\":55.47,\"dewPoint\":52.32,\"humidity\":0.89,\"pressure\":1016.3,\"windSpeed\":3.41,\"windGust\":4.56,\"windBearing\":116,\"cloudCover\":0.9,\"uvIndex\":0,\"visibility\":10,\"ozone\":312.9},{\"time\":1596142800,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.06,\"apparentTemperature\":55.06,\"dewPoint\":52.21,\"humidity\":0.9,\"pressure\":1016.4,\"windSpeed\":4.97,\"windGust\":6.36,\"windBearing\":123,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":311.1},{\"time\":1596146400,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.93,\"apparentTemperature\":54.93,\"dewPoint\":52.3,\"humidity\":0.91,\"pressure\":1016.3,\"windSpeed\":6.63,\"windGust\":9.07,\"windBearing\":132,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":309.5},{\"time\":1596150000,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.69,\"apparentTemperature\":54.69,\"dewPoint\":52.39,\"humidity\":0.92,\"pressure\":1016.5,\"windSpeed\":8.49,\"windGust\":12.45,\"windBearing\":138,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":308.2},{\"time\":1596153600,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0002,\"precipProbability\":0.04,\"precipType\":\"rain\",\"temperature\":54.46,\"apparentTemperature\":54.46,\"dewPoint\":52.58,\"humidity\":0.93,\"pressure\":1016.3,\"windSpeed\":10.33,\"windGust\":15.82,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":306.4},{\"time\":1596157200,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.33,\"apparentTemperature\":54.33,\"dewPoint\":52.72,\"humidity\":0.94,\"pressure\":1016,\"windSpeed\":12.09,\"windGust\":19.17,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":303.8},{\"time\":1596160800,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.51,\"apparentTemperature\":54.51,\"dewPoint\":52.9,\"humidity\":0.94,\"pressure\":1015.4,\"windSpeed\":13.82,\"windGust\":22.53,\"windBearing\":140,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":300.8},{\"time\":1596164400,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":54.95,\"apparentTemperature\":54.95,\"dewPoint\":53.16,\"humidity\":0.94,\"pressure\":1014.9,\"windSpeed\":15.46,\"windGust\":25.59,\"windBearing\":139,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":298.5},{\"time\":1596168000,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0003,\"precipProbability\":0.12,\"precipType\":\"rain\",\"temperature\":55.36,\"apparentTemperature\":55.36,\"dewPoint\":53.52,\"humidity\":0.94,\"pressure\":1014.9,\"windSpeed\":17.07,\"windGust\":28.27,\"windBearing\":139,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":297.5},{\"time\":1596171600,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0011,\"precipProbability\":0.15,\"precipType\":\"rain\",\"temperature\":55.67,\"apparentTemperature\":55.67,\"dewPoint\":54.2,\"humidity\":0.95,\"pressure\":1014.4,\"windSpeed\":18.59,\"windGust\":30.64,\"windBearing\":140,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":297.2},{\"time\":1596175200,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0018,\"precipProbability\":0.14,\"precipType\":\"rain\",\"temperature\":55.78,\"apparentTemperature\":55.78,\"dewPoint\":54.73,\"humidity\":0.96,\"pressure\":1014.1,\"windSpeed\":19.87,\"windGust\":32.37,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":296.6},{\"time\":1596178800,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0011,\"precipProbability\":0.09,\"precipType\":\"rain\",\"temperature\":56.55,\"apparentTemperature\":56.55,\"dewPoint\":55.64,\"humidity\":0.97,\"pressure\":1013.8,\"windSpeed\":20.72,\"windGust\":33.05,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":1,\"visibility\":10,\"ozone\":295.1},{\"time\":1596182400,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":57.08,\"apparentTemperature\":57.08,\"dewPoint\":56.08,\"humidity\":0.96,\"pressure\":1013.7,\"windSpeed\":21.3,\"windGust\":33.09,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":2,\"visibility\":10,\"ozone\":293.3},{\"time\":1596186000,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":57.47,\"apparentTemperature\":57.47,\"dewPoint\":56.17,\"humidity\":0.95,\"pressure\":1013.1,\"windSpeed\":21.96,\"windGust\":33.5,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":2,\"visibility\":10,\"ozone\":292.2},{\"time\":1596189600,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":57.99,\"apparentTemperature\":57.99,\"dewPoint\":56.17,\"humidity\":0.94,\"pressure\":1012.7,\"windSpeed\":22.9,\"windGust\":34.77,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":3,\"visibility\":10,\"ozone\":292.5},{\"time\":1596193200,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":58.72,\"apparentTemperature\":58.72,\"dewPoint\":56.1,\"humidity\":0.91,\"pressure\":1012.2,\"windSpeed\":23.92,\"windGust\":36.41,\"windBearing\":141,\"cloudCover\":1,\"uvIndex\":3,\"visibility\":10,\"ozone\":293.7},{\"time\":1596196800,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":59.63,\"apparentTemperature\":59.63,\"dewPoint\":56.14,\"humidity\":0.88,\"pressure\":1011.7,\"windSpeed\":24.78,\"windGust\":37.73,\"windBearing\":142,\"cloudCover\":0.98,\"uvIndex\":4,\"visibility\":10,\"ozone\":294.6},{\"time\":1596200400,\"summary\":\"Windy and Mostly Cloudy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":60.71,\"apparentTemperature\":60.71,\"dewPoint\":56.1,\"humidity\":0.85,\"pressure\":1011.5,\"windSpeed\":25.39,\"windGust\":38.46,\"windBearing\":142,\"cloudCover\":0.75,\"uvIndex\":4,\"visibility\":10,\"ozone\":295.5},{\"time\":1596204000,\"summary\":\"Windy and Partly Cloudy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":61.62,\"apparentTemperature\":61.62,\"dewPoint\":56,\"humidity\":0.82,\"pressure\":1011.3,\"windSpeed\":25.86,\"windGust\":38.88,\"windBearing\":143,\"cloudCover\":0.45,\"uvIndex\":4,\"visibility\":10,\"ozone\":296.2},{\"time\":1596207600,\"summary\":\"Windy\",\"icon\":\"wind\",\"precipIntensity\":0.0002,\"precipProbability\":0.01,\"precipType\":\"rain\",\"temperature\":62.24,\"apparentTemperature\":62.24,\"dewPoint\":55.85,\"humidity\":0.8,\"pressure\":1011,\"windSpeed\":26.12,\"windGust\":39.21,\"windBearing\":144,\"cloudCover\":0.23,\"uvIndex\":3,\"visibility\":10,\"ozone\":296.4},{\"time\":1596211200,\"summary\":\"Windy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":62.23,\"apparentTemperature\":62.23,\"dewPoint\":55.41,\"humidity\":0.78,\"pressure\":1010.2,\"windSpeed\":26.02,\"windGust\":39.47,\"windBearing\":145,\"cloudCover\":0.14,\"uvIndex\":2,\"visibility\":10,\"ozone\":295.7},{\"time\":1596214800,\"summary\":\"Windy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":62.2,\"apparentTemperature\":62.2,\"dewPoint\":55.15,\"humidity\":0.78,\"pressure\":1009.3,\"windSpeed\":25.65,\"windGust\":39.68,\"windBearing\":146,\"cloudCover\":0.13,\"uvIndex\":1,\"visibility\":10,\"ozone\":294.5},{\"time\":1596218400,\"summary\":\"Windy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":61.68,\"apparentTemperature\":61.68,\"dewPoint\":54.82,\"humidity\":0.78,\"pressure\":1008.7,\"windSpeed\":25.37,\"windGust\":40.02,\"windBearing\":148,\"cloudCover\":0.21,\"uvIndex\":1,\"visibility\":10,\"ozone\":293.3},{\"time\":1596222000,\"summary\":\"Windy and Partly Cloudy\",\"icon\":\"wind\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":61.4,\"apparentTemperature\":61.4,\"dewPoint\":54.78,\"humidity\":0.79,\"pressure\":1008.4,\"windSpeed\":25.31,\"windGust\":40.66,\"windBearing\":149,\"cloudCover\":0.44,\"uvIndex\":0,\"visibility\":10,\"ozone\":292.3},{\"time\":1596225600,\"summary\":\"Windy and Mostly Cloudy\",\"icon\":\"wind\",\"precipIntensity\":0.0002,\"precipProbability\":0.04,\"precipType\":\"rain\",\"temperature\":60.94,\"apparentTemperature\":60.94,\"dewPoint\":54.86,\"humidity\":0.8,\"pressure\":1008.7,\"windSpeed\":25.34,\"windGust\":41.42,\"windBearing\":150,\"cloudCover\":0.76,\"uvIndex\":0,\"visibility\":10,\"ozone\":291.2},{\"time\":1596229200,\"summary\":\"Windy and Overcast\",\"icon\":\"wind\",\"precipIntensity\":0.0007,\"precipProbability\":0.07,\"precipType\":\"rain\",\"temperature\":60.97,\"apparentTemperature\":60.97,\"dewPoint\":55.48,\"humidity\":0.82,\"pressure\":1008.1,\"windSpeed\":25.22,\"windGust\":41.98,\"windBearing\":152,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":290.6},{\"time\":1596232800,\"summary\":\"Windy and Overcast\",\"icon\":\"wind\",\"precipIntensity\":0.0021,\"precipProbability\":0.09,\"precipType\":\"rain\",\"temperature\":60.98,\"apparentTemperature\":60.98,\"dewPoint\":56.4,\"humidity\":0.85,\"pressure\":1007.6,\"windSpeed\":24.96,\"windGust\":42.44,\"windBearing\":153,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":9.437,\"ozone\":290.2},{\"time\":1596236400,\"summary\":\"Windy and Overcast\",\"icon\":\"wind\",\"precipIntensity\":0.0046,\"precipProbability\":0.13,\"precipType\":\"rain\",\"temperature\":60.75,\"apparentTemperature\":60.75,\"dewPoint\":57.4,\"humidity\":0.89,\"pressure\":1007.1,\"windSpeed\":24.52,\"windGust\":42.67,\"windBearing\":154,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":7.677,\"ozone\":290.2},{\"time\":1596240000,\"summary\":\"Windy and Overcast\",\"icon\":\"wind\",\"precipIntensity\":0.0073,\"precipProbability\":0.17,\"precipType\":\"rain\",\"temperature\":60.39,\"apparentTemperature\":60.44,\"dewPoint\":57.98,\"humidity\":0.92,\"pressure\":1006.6,\"windSpeed\":23.78,\"windGust\":41.89,\"windBearing\":156,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":6.842,\"ozone\":291.2},{\"time\":1596243600,\"summary\":\"Windy and Overcast\",\"icon\":\"wind\",\"precipIntensity\":0.0086,\"precipProbability\":0.24,\"precipType\":\"rain\",\"temperature\":59.86,\"apparentTemperature\":59.96,\"dewPoint\":58.08,\"humidity\":0.94,\"pressure\":1006.3,\"windSpeed\":22.52,\"windGust\":39.78,\"windBearing\":158,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":7.753,\"ozone\":294.2},{\"time\":1596247200,\"summary\":\"Possible Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0095,\"precipProbability\":0.32,\"precipType\":\"rain\",\"temperature\":59.38,\"apparentTemperature\":59.5,\"dewPoint\":58.06,\"humidity\":0.95,\"pressure\":1006,\"windSpeed\":20.89,\"windGust\":36.63,\"windBearing\":160,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":9.587,\"ozone\":298.3},{\"time\":1596250800,\"summary\":\"Possible Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0109,\"precipProbability\":0.39,\"precipType\":\"rain\",\"temperature\":59.12,\"apparentTemperature\":59.25,\"dewPoint\":58.03,\"humidity\":0.96,\"pressure\":1005.7,\"windSpeed\":19.05,\"windGust\":32.76,\"windBearing\":165,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":301.5},{\"time\":1596254400,\"summary\":\"Possible Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0185,\"precipProbability\":0.59,\"precipType\":\"rain\",\"temperature\":58.86,\"apparentTemperature\":58.97,\"dewPoint\":57.75,\"humidity\":0.96,\"pressure\":1005.3,\"windSpeed\":16.81,\"windGust\":27.35,\"windBearing\":178,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":303},{\"time\":1596258000,\"summary\":\"Rain\",\"icon\":\"rain\",\"precipIntensity\":0.043,\"precipProbability\":0.73,\"precipType\":\"rain\",\"temperature\":58.57,\"apparentTemperature\":58.69,\"dewPoint\":57.71,\"humidity\":0.97,\"pressure\":1005.1,\"windSpeed\":14.45,\"windGust\":21.19,\"windBearing\":191,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":303.7},{\"time\":1596261600,\"summary\":\"Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0615,\"precipProbability\":0.75,\"precipType\":\"rain\",\"temperature\":58.17,\"apparentTemperature\":58.34,\"dewPoint\":57.86,\"humidity\":0.99,\"pressure\":1005,\"windSpeed\":12.97,\"windGust\":17.13,\"windBearing\":194,\"cloudCover\":1,\"uvIndex\":0,\"visibility\":10,\"ozone\":304.9},{\"time\":1596265200,\"summary\":\"Rain\",\"icon\":\"rain\",\"precipIntensity\":0.042,\"precipProbability\":0.64,\"precipType\":\"rain\",\"temperature\":57.48,\"apparentTemperature\":57.58,\"dewPoint\":57.2,\"humidity\":0.99,\"pressure\":1005.2,\"windSpeed\":13.19,\"windGust\":17,\"windBearing\":147,\"cloudCover\":0.99,\"uvIndex\":1,\"visibility\":10,\"ozone\":307.1},{\"time\":1596268800,\"summary\":\"Possible Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0149,\"precipProbability\":0.3,\"precipType\":\"rain\",\"temperature\":56.7,\"apparentTemperature\":56.7,\"dewPoint\":56.08,\"humidity\":0.98,\"pressure\":1005.6,\"windSpeed\":14.25,\"windGust\":18.95,\"windBearing\":272,\"cloudCover\":0.97,\"uvIndex\":2,\"visibility\":10,\"ozone\":309.8},{\"time\":1596272400,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0042,\"precipProbability\":0.13,\"precipType\":\"rain\",\"temperature\":55.94,\"apparentTemperature\":55.94,\"dewPoint\":54.75,\"humidity\":0.96,\"pressure\":1006.1,\"windSpeed\":14.9,\"windGust\":20.31,\"windBearing\":260,\"cloudCover\":0.96,\"uvIndex\":2,\"visibility\":10,\"ozone\":312.3},{\"time\":1596276000,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0017,\"precipProbability\":0.07,\"precipType\":\"rain\",\"temperature\":55.59,\"apparentTemperature\":55.59,\"dewPoint\":53.99,\"humidity\":0.94,\"pressure\":1006.6,\"windSpeed\":14.58,\"windGust\":19.92,\"windBearing\":284,\"cloudCover\":0.98,\"uvIndex\":3,\"visibility\":10,\"ozone\":315.1},{\"time\":1596279600,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0.0005,\"precipProbability\":0.05,\"precipType\":\"rain\",\"temperature\":55.42,\"apparentTemperature\":55.42,\"dewPoint\":53.22,\"humidity\":0.92,\"pressure\":1007.5,\"windSpeed\":13.85,\"windGust\":18.9,\"windBearing\":220,\"cloudCover\":1,\"uvIndex\":3,\"visibility\":10,\"ozone\":317.8},{\"time\":1596283200,\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.63,\"apparentTemperature\":55.63,\"dewPoint\":52.66,\"humidity\":0.9,\"pressure\":1007.9,\"windSpeed\":13.12,\"windGust\":17.94,\"windBearing\":247,\"cloudCover\":0.96,\"uvIndex\":3,\"visibility\":10,\"ozone\":319.4},{\"time\":1596286800,\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":55.8,\"apparentTemperature\":55.8,\"dewPoint\":52.09,\"humidity\":0.87,\"pressure\":1008.4,\"windSpeed\":12.54,\"windGust\":17.33,\"windBearing\":252,\"cloudCover\":0.73,\"uvIndex\":4,\"visibility\":10,\"ozone\":318.9}]},\"daily\":{\"summary\":\"Rain on Saturday through Wednesday.\",\"icon\":\"rain\",\"data\":[{\"time\":1596063600,\"summary\":\"Mostly cloudy throughout the day.\",\"icon\":\"partly-cloudy-day\",\"sunriseTime\":1596080400,\"sunsetTime\":1596141960,\"moonPhase\":0.37,\"precipIntensity\":0.0005,\"precipIntensityMax\":0.0027,\"precipIntensityMaxTime\":1596066000,\"precipProbability\":0.18,\"precipType\":\"rain\",\"temperatureHigh\":56.81,\"temperatureHighTime\":1596125760,\"temperatureLow\":53.84,\"temperatureLowTime\":1596157020,\"apparentTemperatureHigh\":56.31,\"apparentTemperatureHighTime\":1596125760,\"apparentTemperatureLow\":54.33,\"apparentTemperatureLowTime\":1596157020,\"dewPoint\":52.25,\"humidity\":0.93,\"pressure\":1014.9,\"windSpeed\":11.21,\"windGust\":28.15,\"windGustTime\":1596063600,\"windBearing\":316,\"cloudCover\":0.81,\"uvIndex\":4,\"uvIndexTime\":1596115500,\"visibility\":10,\"ozone\":328.1,\"temperatureMin\":52.24,\"temperatureMinTime\":1596072720,\"temperatureMax\":56.81,\"temperatureMaxTime\":1596125760,\"apparentTemperatureMin\":52.73,\"apparentTemperatureMinTime\":1596072720,\"apparentTemperatureMax\":56.31,\"apparentTemperatureMaxTime\":1596125760},{\"time\":1596150000,\"summary\":\"Possible light rain overnight.\",\"icon\":\"wind\",\"sunriseTime\":1596166980,\"sunsetTime\":1596228240,\"moonPhase\":0.4,\"precipIntensity\":0.0004,\"precipIntensityMax\":0.0046,\"precipIntensityMaxTime\":1596236400,\"precipProbability\":0.31,\"precipType\":\"rain\",\"temperatureHigh\":62.78,\"temperatureHighTime\":1596208740,\"temperatureLow\":56.99,\"temperatureLowTime\":1596265200,\"apparentTemperatureHigh\":62.28,\"apparentTemperatureHighTime\":1596208740,\"apparentTemperatureLow\":57.58,\"apparentTemperatureLowTime\":1596265200,\"dewPoint\":54.99,\"humidity\":0.88,\"pressure\":1012.1,\"windSpeed\":21.45,\"windGust\":42.69,\"windGustTime\":1596235800,\"windBearing\":144,\"cloudCover\":0.8,\"uvIndex\":4,\"uvIndexTime\":1596203100,\"visibility\":9.938,\"ozone\":295.7,\"temperatureMin\":53.84,\"temperatureMinTime\":1596157020,\"temperatureMax\":62.78,\"temperatureMaxTime\":1596208740,\"apparentTemperatureMin\":54.33,\"apparentTemperatureMinTime\":1596157020,\"apparentTemperatureMax\":62.28,\"apparentTemperatureMaxTime\":1596208740},{\"time\":1596236400,\"summary\":\"Rain in the morning.\",\"icon\":\"rain\",\"sunriseTime\":1596253500,\"sunsetTime\":1596314460,\"moonPhase\":0.44,\"precipIntensity\":0.0094,\"precipIntensityMax\":0.0615,\"precipIntensityMaxTime\":1596261600,\"precipProbability\":0.88,\"precipType\":\"rain\",\"temperatureHigh\":58.67,\"temperatureHighTime\":1596261600,\"temperatureLow\":52.52,\"temperatureLowTime\":1596335640,\"apparentTemperatureHigh\":58.34,\"apparentTemperatureHighTime\":1596261600,\"apparentTemperatureLow\":53.01,\"apparentTemperatureLowTime\":1596335640,\"dewPoint\":54.14,\"humidity\":0.91,\"pressure\":1007.3,\"windSpeed\":13.69,\"windGust\":42.67,\"windGustTime\":1596236400,\"windBearing\":211,\"cloudCover\":0.74,\"uvIndex\":4,\"uvIndexTime\":1596289620,\"visibility\":9.707,\"ozone\":311.5,\"temperatureMin\":53.31,\"temperatureMinTime\":1596322800,\"temperatureMax\":61.25,\"temperatureMaxTime\":1596236400,\"apparentTemperatureMin\":53.8,\"apparentTemperatureMinTime\":1596322800,\"apparentTemperatureMax\":60.75,\"apparentTemperatureMaxTime\":1596236400},{\"time\":1596322800,\"summary\":\"Possible drizzle in the morning.\",\"icon\":\"rain\",\"sunriseTime\":1596340080,\"sunsetTime\":1596400740,\"moonPhase\":0.47,\"precipIntensity\":0.0011,\"precipIntensityMax\":0.0045,\"precipIntensityMaxTime\":1596358620,\"precipProbability\":0.46,\"precipType\":\"rain\",\"temperatureHigh\":56.3,\"temperatureHighTime\":1596376500,\"temperatureLow\":51.85,\"temperatureLowTime\":1596419640,\"apparentTemperatureHigh\":55.8,\"apparentTemperatureHighTime\":1596376500,\"apparentTemperatureLow\":52.34,\"apparentTemperatureLowTime\":1596419640,\"dewPoint\":50.62,\"humidity\":0.87,\"pressure\":1007.6,\"windSpeed\":12.07,\"windGust\":23.28,\"windGustTime\":1596409200,\"windBearing\":226,\"cloudCover\":0.7,\"uvIndex\":3,\"uvIndexTime\":1596374760,\"visibility\":10,\"ozone\":330,\"temperatureMin\":52.52,\"temperatureMinTime\":1596335640,\"temperatureMax\":56.3,\"temperatureMaxTime\":1596376500,\"apparentTemperatureMin\":53.01,\"apparentTemperatureMinTime\":1596335640,\"apparentTemperatureMax\":55.8,\"apparentTemperatureMaxTime\":1596376500},{\"time\":1596409200,\"summary\":\"Possible drizzle in the morning.\",\"icon\":\"rain\",\"sunriseTime\":1596426600,\"sunsetTime\":1596486960,\"moonPhase\":0.51,\"precipIntensity\":0.0024,\"precipIntensityMax\":0.0067,\"precipIntensityMaxTime\":1596444120,\"precipProbability\":0.54,\"precipType\":\"rain\",\"temperatureHigh\":54.87,\"temperatureHighTime\":1596448740,\"temperatureLow\":52.15,\"temperatureLowTime\":1596504300,\"apparentTemperatureHigh\":54.37,\"apparentTemperatureHighTime\":1596448740,\"apparentTemperatureLow\":52.64,\"apparentTemperatureLowTime\":1596504300,\"dewPoint\":48.13,\"humidity\":0.81,\"pressure\":1007,\"windSpeed\":14.52,\"windGust\":23.4,\"windGustTime\":1596412020,\"windBearing\":237,\"cloudCover\":0.91,\"uvIndex\":3,\"uvIndexTime\":1596457500,\"visibility\":10,\"ozone\":333.6,\"temperatureMin\":51.85,\"temperatureMinTime\":1596419640,\"temperatureMax\":54.97,\"temperatureMaxTime\":1596480540,\"apparentTemperatureMin\":52.34,\"apparentTemperatureMinTime\":1596419640,\"apparentTemperatureMax\":54.47,\"apparentTemperatureMaxTime\":1596480540},{\"time\":1596495600,\"summary\":\"Possible light rain overnight.\",\"icon\":\"partly-cloudy-day\",\"sunriseTime\":1596513180,\"sunsetTime\":1596573180,\"moonPhase\":0.54,\"precipIntensity\":0.0008,\"precipIntensityMax\":0.0037,\"precipIntensityMaxTime\":1596542700,\"precipProbability\":0.35,\"precipType\":\"rain\",\"temperatureHigh\":56.9,\"temperatureHighTime\":1596536040,\"temperatureLow\":53.2,\"temperatureLowTime\":1596595500,\"apparentTemperatureHigh\":56.4,\"apparentTemperatureHighTime\":1596536040,\"apparentTemperatureLow\":53.69,\"apparentTemperatureLowTime\":1596595500,\"dewPoint\":48.93,\"humidity\":0.82,\"pressure\":1005.5,\"windSpeed\":13.47,\"windGust\":22.59,\"windGustTime\":1596511380,\"windBearing\":211,\"cloudCover\":0.68,\"uvIndex\":4,\"uvIndexTime\":1596542340,\"visibility\":10,\"ozone\":341.3,\"temperatureMin\":52.15,\"temperatureMinTime\":1596504300,\"temperatureMax\":56.9,\"temperatureMaxTime\":1596536040,\"apparentTemperatureMin\":52.64,\"apparentTemperatureMinTime\":1596504300,\"apparentTemperatureMax\":56.4,\"apparentTemperatureMaxTime\":1596536040},{\"time\":1596582000,\"summary\":\"Light rain in the morning and afternoon.\",\"icon\":\"rain\",\"sunriseTime\":1596599700,\"sunsetTime\":1596659460,\"moonPhase\":0.57,\"precipIntensity\":0.0117,\"precipIntensityMax\":0.0349,\"precipIntensityMaxTime\":1596650460,\"precipProbability\":0.82,\"precipType\":\"rain\",\"temperatureHigh\":59.68,\"temperatureHighTime\":1596639240,\"temperatureLow\":54.07,\"temperatureLowTime\":1596674760,\"apparentTemperatureHigh\":59.18,\"apparentTemperatureHighTime\":1596639240,\"apparentTemperatureLow\":54.56,\"apparentTemperatureLowTime\":1596674760,\"dewPoint\":51.99,\"humidity\":0.86,\"pressure\":1001.1,\"windSpeed\":13.57,\"windGust\":17.43,\"windGustTime\":1596605760,\"windBearing\":189,\"cloudCover\":0.94,\"uvIndex\":3,\"uvIndexTime\":1596629280,\"visibility\":10,\"ozone\":340.2,\"temperatureMin\":53.2,\"temperatureMinTime\":1596595500,\"temperatureMax\":59.68,\"temperatureMaxTime\":1596639240,\"apparentTemperatureMin\":53.69,\"apparentTemperatureMinTime\":1596595500,\"apparentTemperatureMax\":59.18,\"apparentTemperatureMaxTime\":1596639240},{\"time\":1596668400,\"summary\":\"Partly cloudy throughout the day.\",\"icon\":\"partly-cloudy-day\",\"sunriseTime\":1596686280,\"sunsetTime\":1596745680,\"moonPhase\":0.6,\"precipIntensity\":0.0015,\"precipIntensityMax\":0.0049,\"precipIntensityMaxTime\":1596704700,\"precipProbability\":0.32,\"precipType\":\"rain\",\"temperatureHigh\":60.15,\"temperatureHighTime\":1596727380,\"temperatureLow\":54.79,\"temperatureLowTime\":1596765060,\"apparentTemperatureHigh\":59.65,\"apparentTemperatureHighTime\":1596727380,\"apparentTemperatureLow\":55.28,\"apparentTemperatureLowTime\":1596765060,\"dewPoint\":51.6,\"humidity\":0.83,\"pressure\":1011,\"windSpeed\":10.13,\"windGust\":17.62,\"windGustTime\":1596674460,\"windBearing\":221,\"cloudCover\":0.47,\"uvIndex\":3,\"uvIndexTime\":1596721080,\"visibility\":10,\"ozone\":344.5,\"temperatureMin\":54.07,\"temperatureMinTime\":1596674760,\"temperatureMax\":60.15,\"temperatureMaxTime\":1596727380,\"apparentTemperatureMin\":54.56,\"apparentTemperatureMinTime\":1596674760,\"apparentTemperatureMax\":59.65,\"apparentTemperatureMaxTime\":1596727380}]},\"flags\":{\"sources\":[\"meteoalarm\",\"cmc\",\"gfs\",\"icon\",\"isd\",\"madis\"],\"meteoalarm-license\":\"Based on data from EUMETNET - MeteoAlarm [https://www.meteoalarm.eu/]. Time delays between this website and the MeteoAlarm website are possible; for the most up to date information about alert levels as published by the participating National Meteorological Services please use the MeteoAlarm website.\",\"nearest-station\":6.02,\"units\":\"us\"},\"offset\":1}";

        return buildWeatherForecastBasedOnResponseString(responseString);
    }

    public WeatherForecast generateWeatherForecast(String cityName) {
        return new WeatherForecast();
    }
}
