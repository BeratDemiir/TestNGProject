package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_NegativeLoginTest {

    /*
    Name:
US100208_Negative_Login
Description:
Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
Acceptance Criteria
Customer email: fake@bluerentalcars.com
Customer password: fakepass
Error:
User with email fake@bluerentalcars.com not found
     */
    BlueRentalLoginpage blueRentalLoginpage;
    BlueRentalHomePage blueRentalHomePage;

    @Test
    public void US100208_Negative_Login() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginpage = new BlueRentalLoginpage();

        blueRentalHomePage.loginKink.click();
        blueRentalLoginpage.emailBox.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRentalLoginpage.passwordBox.sendKeys(ConfigReader.getProperty("fake_password"));
        blueRentalLoginpage.loginButton.click();
        Thread.sleep(2000);
      Assert.assertEquals(blueRentalLoginpage.error_message_1.getText(),"User with email fake@bluerentalcars.com not found");

      Driver.closeDriver();

    }

    @Test
    public void test2() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginpage = new BlueRentalLoginpage();
        blueRentalHomePage.loginKink.click();
        blueRentalLoginpage.emailBox.sendKeys(ConfigReader.getProperty("yanlis_email"));
        blueRentalLoginpage.passwordBox.sendKeys(ConfigReader.getProperty("admin_password"));
        blueRentalLoginpage.loginButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(blueRentalLoginpage.error_message_2.getText(),"email must be a valid email");

        Driver.closeDriver();

    }
}
