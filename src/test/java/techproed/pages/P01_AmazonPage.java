package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class P01_AmazonPage {

    // ilk yapmamiz gereken bir tane constructor olusturmak , class ismi ile ayni olmalidir.
    public P01_AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement sonucYazisi;
}
