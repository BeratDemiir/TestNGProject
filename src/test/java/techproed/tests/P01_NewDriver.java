package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class P01_NewDriver {

    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.closeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("techpro_url"));
        Driver.getDriver().get("https://instagram.com");
        Driver.closeDriver();
    }
}
