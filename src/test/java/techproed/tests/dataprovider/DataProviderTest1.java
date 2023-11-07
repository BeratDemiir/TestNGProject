package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class DataProviderTest1 {
/*
 Data provider nedir?
     Veri deposudur. Bir cok veriyi Test caselere loop kullanmadan aktarmak icin kullanilir
      Data provider 2D(2 boyutlu) object  retrun eder
      Data provider TestNG den gelen bir ozellikdir

 Data provider ne icin kullanilir?
     Data provider DDT(Data Driven Testing) icin kullanilir. Birden fazla data yi  test case lerde kullanmak icin kullanilir.

 Data provider i nasil kullanirsiniz?
      Data provider annotasyonu ile veri havuzu olusturulur. @Test methodlarina bu data havuzu dataProvider paremetresi ile baglanir

 Data provider da 2 tane parametre vardir:
 name: method ismini override etmek icin, yani farkli bir isim ile data provider i cagirmak icin kullanilir
 parallel: parallel test case ler olusturmak icin kullanilir

 */
    // DATA PROVIDER
    @DataProvider(name = "smoke_test_data")
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
    @Test(dataProvider = "smoke_test_data")
    public void aramaTesti(String data){
        System.out.println(data);
    }

    // GOOGLE ARAMASI
    @Test(dataProvider = "smoke_test_data")
    public void  googleAramasi(String araclar){
        Driver.getDriver().get("https://www.google.com");
        // Araclari arama kutusuna gir ve Enter a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar + Keys.ENTER);
        // sayfa title nin aradigim kelimeyi icerdigini test et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
        Driver.closeDriver();
    }
}
