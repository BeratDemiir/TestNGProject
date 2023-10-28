package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_NegativeLoginTest {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginpage blueRentalLoginpage;

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        blueRentalLoginpage = new BlueRentalLoginpage();
        blueRentalHomePage = new BlueRentalHomePage();

        blueRentalHomePage.loginKink.click();

        blueRentalLoginpage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginpage.passwordBox.sendKeys(ConfigReader.getProperty("fake_password"));
        blueRentalLoginpage.loginButton.click();

        Thread.sleep(2000);

        Assert.assertEquals(blueRentalLoginpage.error_message_1.getText(),"Bad credentials");

        Driver.closeDriver();


    }
}
