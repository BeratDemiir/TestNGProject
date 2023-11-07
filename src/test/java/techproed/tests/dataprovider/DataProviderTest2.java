package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class DataProviderTest2 {

    @DataProvider
    public Object[][] customerData(){
        Object[][] musteriBilgileri= {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return musteriBilgileri;
    }

    // TEST
    @Test(dataProvider = "customerData")
    public void dataProviderTest(String email, String password){
        System.out.println("Email: " + email +" Sifre : " + password );
    }

    // Bu 4 customer data lari ile login testi yapalim
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginpage blueRentalLoginpage;
    @Test(dataProvider = "customerData")
    public void dataProviderLoginTest(String email, String sifre) throws IOException {
        // her loop da login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginpage = new BlueRentalLoginpage();
        blueRentalHomePage.loginKink.click();
        blueRentalLoginpage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginpage.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(1);
        blueRentalLoginpage.loginButton.click();
        ReusableMethods.waitFor(1);

        // giris isleminin basarili oldugunu gostermek icin assertion yaptik
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
        ReusableMethods.waitFor(1);

        // her bir islem den sonra ekran goruntusu aldik
        ReusableMethods.getScreenshot("EkranGoruntusu");
        ReusableMethods.waitFor(1);
        blueRentalHomePage.userID.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.logOutLink.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.OK.click();

        Driver.closeDriver();
    }
}
