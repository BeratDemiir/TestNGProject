package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C06_TechproLoginTest {

    @Test
    public void techproLoginTest() throws InterruptedException {

        // object olustur
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();

        // sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("techproed_url"));

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techproed_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techproed_password"));
        techproLoginPage.submitButton.click();

        // Assertion
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
