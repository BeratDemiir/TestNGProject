package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class C02_ExcelLogin2 {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginpage blueRentalLoginpage;
    // Bu method login sayfasina gitmek icin kullanilacak

    ExcelUtils excelUtils;
    List<Map<String,String>> excelDatalari;
    @Test
    public void customerLogin() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata (1).xlsx";
        String sayfa = "customer_info";
        excelUtils = new ExcelUtils(path,sayfa);
        excelDatalari = excelUtils.getDataList();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        // home page logine tikla
        for (Map<String,String> data : excelDatalari){
            // her loop da login sayfasina gider
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            blueRentalHomePage = new BlueRentalHomePage();
            blueRentalLoginpage = new BlueRentalLoginpage();
            blueRentalHomePage.loginKink.click();
            blueRentalLoginpage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginpage.passwordBox.sendKeys(data.get("password"));
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
        }
        Driver.closeDriver();
    }
}
