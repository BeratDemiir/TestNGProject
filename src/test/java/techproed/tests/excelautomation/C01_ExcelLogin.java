package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginpage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginpage blueRentalLoginpage;

    // Bu method login sayfasina gitmek icin kullanilir.
    public void login(){
        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        // home page login e tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginpage = new BlueRentalLoginpage();

        // Ilk giris
        blueRentalHomePage.loginKink.click();
        ReusableMethods.waitFor(1);
        // Login sayfasindayiz
    }

    @Test
    public void customerLogin() {

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

