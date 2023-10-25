package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C05_OpenSourceLogin {

    @Test
    public void openSourceLogin() throws InterruptedException {

     //  1. Adim sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        // 2. Adim page object i olustur
        OpenSourcePage openSourcePage = new OpenSourcePage();

        // 3. Adim Bu object i kullanarak o sinifdaki object lere ulasalim
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

        // 4. Adim Assertion sayfaya giris yapildimi
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        Thread.sleep(2000);
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

        // sayfayi kapatalim
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
