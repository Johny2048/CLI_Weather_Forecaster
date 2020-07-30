package tests;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CityResolverTests {
    private CityResolver cityResolver;

    @Before
    public void initialize() {
        cityResolver = new CityResolver();
    }

    @Test
    public void testAthens() {
        City athens = cityResolver.resolve("Athens");
        assertTrue(athens.getCountry().equals("GR"));
        assertTrue(athens.getName().equals("Athens"));
        assertTrue(athens.getLat() == 37.97945);
        assertTrue(athens.getLng() == 23.71622);
    }

    @Test
    public void testSacramento() {
        City sacramento = cityResolver.resolve("Sacramento");
        assertTrue(sacramento.getCountry().equals("BR"));
        assertTrue(sacramento.getName().equals("Sacramento"));
        assertTrue(sacramento.getLat() == -19.86528);
        assertTrue(sacramento.getLng() == -47.44);
    }

    @Test
    public void testTokyo() {
        City tokyo = cityResolver.resolve("Tokyo");
        assertTrue(tokyo.getCountry().equals("JP"));
        assertTrue(tokyo.getName().equals("Tokyo"));
        assertTrue(tokyo.getLat() == 35.6895);
        assertTrue(tokyo.getLng() == 139.69171);
    }

    @Test
    public void testMelbourne() {
        City melbourne = cityResolver.resolve("Melbourne");
        assertTrue(melbourne.getCountry().equals("AU"));
        assertTrue(melbourne.getName().equals("Melbourne"));
        assertTrue(melbourne.getLat() == -37.814);
        assertTrue(melbourne.getLng() == 144.96332);
    }

    @Test
    public void testSomeCity() {
        City someCity = cityResolver.resolve("SomeCity");
        assertTrue(someCity == null);
    }
}