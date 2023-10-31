package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class P01_NewDriver {

    @Test
    public void testName() {
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().get("https://instagram.com");
        Driver.closeDriver();
    }
}
