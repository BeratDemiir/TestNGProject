package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PositiveLoginTest {

    @Test
    public void US100201_Admin_Login() throws InterruptedException {

        BlueRentalLoginpage blueRentalLoginpage = new BlueRentalLoginpage();
        BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();

        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        Thread.sleep(3000);
        blueRentalHomePage.loginKink.click();

        // bilgileri gir
        blueRentalLoginpage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginpage.passwordBox.sendKeys(ConfigReader.getProperty("admin_password"));
        blueRentalLoginpage.loginButton.click();
    }
}
