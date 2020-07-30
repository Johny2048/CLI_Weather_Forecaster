package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInputReader {
    private BufferedReader bufferedReader;
    private UserOutputPrinter userOutputPrinter;
    private WeatherForecaster weatherForecaster;
    private final String logoString = "      ___      ___       ___  __      ___  __   __   ___  __        __  ___  ___  __  \n" +
                                      "|  | |__   /\\   |  |__| |__  |__)    |__  /  \\ |__) |__  /  `  /\\  /__`  |  |__  |__) \n" +
                                      "|/\\| |___ /~~\\  |  |  | |___ |  \\    |    \\__/ |  \\ |___ \\__, /~~\\ .__/  |  |___ |  \\ \n" +
                                      "                                                                                      ";

    public UserInputReader() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
        userOutputPrinter = new UserOutputPrinter();
        weatherForecaster = new WeatherForecaster();
    }

    private void interactWithUserInTask1() {
        double latitude = 60.59329987;
        double longitude = -1.44250533;
        WeatherForecast weatherForecast = weatherForecaster.generateWeatherForecast(latitude, longitude);
        userOutputPrinter.printWeatherForecast(weatherForecast);
    }

    private void interactWithUserInTasks2And3() {
        int choice = 0;
        double latitude = 0;
        double longitude = 0;
        WeatherForecast weatherForecast = null;

        try {
            while(choice != 3) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("Enter the appropriate number below.");
                System.out.println("1. Get weather forecast by coordinates;");
                System.out.println("2. Get weather forecast by city name;");
                System.out.println("3. End session.");
                System.out.print("Choice = ");

                try {
                    choice = Integer.parseInt(bufferedReader.readLine());
                } catch (Exception e) {
                    choice = 0;
                }

                switch(choice) {
                    case 1:
                        try {
                            System.out.println("Please enter the coordinates below.");
                            System.out.print("Latitude = ");
                            latitude = Double.parseDouble(bufferedReader.readLine());
                            System.out.print("Longitude = ");
                            longitude = Double.parseDouble(bufferedReader.readLine());

                            weatherForecast = weatherForecaster.generateWeatherForecast(latitude, longitude);
                            userOutputPrinter.printWeatherForecast(weatherForecast);
                        } catch (Exception e) {
                            System.out.println("The entered value is not valid.");
                            System.out.println("Please try again.");
                            choice = 0;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter a city name below.");
                        System.out.print("City name = ");
                        String cityName = bufferedReader.readLine();

                        weatherForecast = weatherForecaster.generateWeatherForecast(cityName);
                        if(weatherForecast != null) {
                            userOutputPrinter.printWeatherForecast(weatherForecast);
                        } else {
                            System.out.println("No results found for \"" + cityName + "\".");
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("The entered value is not valid.");
                        System.out.println("Please try again.");
                        choice = 0;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void greetUser() {
        System.out.println();
        System.out.println(logoString);
        System.out.println("Welcome to Weather Forecaster v0.0.1!\n");
    }

    private void sayGoodByeToUser() {
        System.out.println("\nThank you for using Weather Forecaster!");
        System.out.println("Have a nice day!\n");
    }

    public void interactWithUser() {
        boolean shouldInteractWithUserInTask1 = false;

        greetUser();

        if(shouldInteractWithUserInTask1) {
            interactWithUserInTask1();
        } else {
            interactWithUserInTasks2And3();
        }

        sayGoodByeToUser();
    }
}
