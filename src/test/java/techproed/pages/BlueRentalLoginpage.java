package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalLoginpage {

    public BlueRentalLoginpage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement emailBox;

    @FindBy(id = "formBasicPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_message_1;

    @FindBy(xpath = "//div[.='email must be a valid email']")
    public WebElement error_message_2;

    @FindBy(xpath = "//div[.='Please enter your password']")
    public WebElement error_message_3;
}
