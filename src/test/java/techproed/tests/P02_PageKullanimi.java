package techproed.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.P01_AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class P02_PageKullanimi {

    @Test
    public void testName() {

        P01_AmazonPage amazonPage = new P01_AmazonPage();
        // amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        // iphone aratalim
        amazonPage.aramaKutusu.sendKeys("iphone", Keys.ENTER);

        // sonuc yazisinin iphone icerdigini test edelim
        String actualSonuc = amazonPage.sonucYazisi.getText();
        String arananKelime ="iphone";
        assert actualSonuc.contains(arananKelime);

        Driver.closeDriver();
    }
}
