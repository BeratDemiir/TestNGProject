package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    // Page object lerini bu sinifta buluruz

    // 1. constructor
    public OpenSourcePage(){
    //    PageFactory seleniumdan gelen ve bu sayfa elementlerini baslangic degerlerini vermek(intantiate etmek) icin kullanilir.
    //    Safya object leri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(),this);
    }

  // PAGE OBJECTLERINI OLUSTUR
  // public WebElement username = Driver.getDriver().findElement(By.name("username"));
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement submitButton;
}
