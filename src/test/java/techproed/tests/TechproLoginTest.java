package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TechproLoginTest {

    @Test
    public void techproLoginTest() throws InterruptedException {

        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("techproed_url"));

        // object olustur
        TechproLoginPage techproLoginPage = new TechproLoginPage();

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techproed_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techproed_password"));
        techproLoginPage.submitButton.click();

        // Assertion
        TechproHomePage techproHomePage = new TechproHomePage();

        Assert.assertTrue(techproHomePage.logout.isDisplayed());

        // logout butonuna bas ve cikis yap
        techproHomePage.logout.click();
        Thread.sleep(3000);

        // sayfadan cikis yapildigini test et
        Thread.sleep(2000);
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

        // sayfayi kapat
        Driver.closeDriver();
    }
}
