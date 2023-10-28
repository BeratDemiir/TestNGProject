package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PositiveLoginTest {

    BlueRentalLoginpage blueRentalLoginpage;
    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US100201_Admin_Login() throws InterruptedException {

        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        blueRentalLoginpage = new BlueRentalLoginpage();
        blueRentalHomePage = new BlueRentalHomePage();
        Thread.sleep(3000);

        blueRentalHomePage.loginKink.click();

        // bilgileri gir ve giris yap
        blueRentalLoginpage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginpage.passwordBox.sendKeys(ConfigReader.getProperty("admin_password"));
        blueRentalLoginpage.loginButton.click();

        Driver.closeDriver();
    }
}
