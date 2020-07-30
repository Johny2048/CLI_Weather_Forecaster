import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class CityResolver {
    private static final String citiesUri = "https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json";
    private List<City> cities;


    public CityResolver() {
        constructCityList();
    }

    private void constructCityList() {
        HttpContentRetriever httpContentRetriever = new HttpContentRetriever();
        String responseString = httpContentRetriever.retrieveContentAsStringFromUri(citiesUri);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            cities = objectMapper.readValue(responseString, new TypeReference<List<City>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public City resolve(String cityName) {
        City city = null;

        for(int i = 0; i < cities.size(); i++) {
            if(cities.get(i).getName().equals(cityName)) {
                city = cities.get(i);
                break;
            }
        }

        return city;
    }
}
