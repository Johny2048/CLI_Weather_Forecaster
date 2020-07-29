import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputReader {
    private BufferedReader bufferedReader;

    public UserInputReader() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    public String readInputCityName() {
        String cityName = null;

        return cityName;
    }
}
