package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
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

public class C01_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginpage blueRentalLoginpage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    // Bu method login sayfasina gitmek icin kullanilir.
    public void login(){
        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        // home page login e tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginpage = new BlueRentalLoginpage();

        // Ilk giris
        try {
            blueRentalHomePage.loginKink.click();
            ReusableMethods.waitFor(1);
            // Login sayfasindayiz
        }catch (Exception e){
        }

        // Sonraki girisler
        try {
            // kullanici ID ye tikla
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            // sonra logout linkine tikla
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            // cikan bildirimde ok a tikla
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            // home page logine tikla
            blueRentalHomePage.loginKink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }

    }

    @Test
    public void customerLogin() throws IOException {
        String path = "src/test/java/resources/mysmoketestdata (1).xlsx";
        String sayfa = "customer_info";

        // Datalari excel utils methodlari kullanarak buraya alacagiz.
        excelUtils = new ExcelUtils(path,sayfa);

        // excel datalarini getDataList method u ile cekelim
       excelDatalari = excelUtils.getDataList();

       // loop kullanilarak datalari tek tek test case de kullan
        for (Map<String,String> data : excelDatalari){
            login();// her loop da login sayfasina gider
            // kullanici adini gir
            blueRentalLoginpage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            // kullanici sifresini gir
            blueRentalLoginpage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            // login buttonuna tikla
            blueRentalLoginpage.loginButton.click();
            ReusableMethods.waitFor(1);

            // giris isleminin basarili oldugunu gostermek icin assertion yaptik
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);

            // her bir islem den sonra ekran goruntusu aldik
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }
    }

    @AfterMethod
    public void terDown(){
        Driver.closeDriver();
    }
}

//       USERNAME				                PASSWORD
// sam.walker@bluerentalcars.com				c!fas_art
// raj.khan@bluerentalcars.com				    v7Hg_va^
// pam.raymond@bluerentalcars.com				Nga^g6!

// ilk olarak home page deyiz
// home page deyken login buttonuna tikla
// kullanici adini gir(excel den al)
// kullanici sifresini gir(excel den al)
// login page deki login nuttonuna tikla
// siteye giris yaptiktan sonra
// kullanici ID ye tikla
// sonra logout linkine tikla
// cikan bildirimde ok a tikla

