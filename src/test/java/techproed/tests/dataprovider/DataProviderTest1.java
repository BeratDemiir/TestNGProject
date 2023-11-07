package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class DataProviderTest1 {

    // DATA PROVIDER
    @DataProvider
    public  Object[][] urunler(){
        Object urunListesi[][] = {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"honda"},
                {"toyota"},
                {"volvo"}
        };
        return urunListesi;
    }
    @Test(dataProvider = "urunler")
    public void aramaTesti(String data){
        System.out.println(data);
    }

    // GOOGLE ARAMASI
    @Test(dataProvider = "urunler")
    public void  googleAramasi(String araclar){
        Driver.getDriver().get("https://www.google.com");
        // Araclari arama kutusuna gir ve Enter a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar + Keys.ENTER);
        // sayfa title nin aradigim kelimeyi icerdigini test et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
        Driver.closeDriver();
    }
}
