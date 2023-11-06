package techproed.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class ReusableMethods {
    public ReusableMethods() {
    }

    public static String getScreenshot(String name) throws IOException {
        String date = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date());
        TakesScreenshot ts = (TakesScreenshot)Driver.getDriver();
        File source = (File)ts.getScreenshotAs(OutputType.FILE);
        String var10000 = System.getProperty("user.dir");
        String target = var10000 + "/test-output/Screenshots/" + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        Iterator var2 = Driver.getDriver().getWindowHandles().iterator();

        do {
            if (!var2.hasNext()) {
                Driver.getDriver().switchTo().window(origin);
                return;
            }

            String handle = (String)var2.next();
            Driver.getDriver().switchTo().window(handle);
        } while(!Driver.getDriver().getTitle().equals(targetTitle));

    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            WebElement el = (WebElement)var2.next();
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }

        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList();
        Iterator var3 = elems.iterator();

        while(var3.hasNext()) {
            WebElement el = (WebElement)var3.next();
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }

        return elemTexts;
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep((long)(sec * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeout));
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeout));
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeout));
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeout));
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        int i = 0;

        while(i < timeout) {
            try {
                element.click();
                return;
            } catch (WebDriverException var4) {
                waitFor(1);
                ++i;
            }
        }

    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    public static void doubleClick(WebElement element) {
        (new Actions(Driver.getDriver())).doubleClick(element).build().perform();
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else if (element.isSelected()) {
            element.click();
        }

    }

    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public static void verifyElementDisplayed(By by) {
        try {
            AssertJUnit.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException var2) {
            Assert.fail("Element not found: " + by);
        }

    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            AssertJUnit.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException var2) {
            var2.printStackTrace();
        }

    }

    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            AssertJUnit.assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException var2) {
            var2.printStackTrace();
        }

    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            AssertJUnit.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException var2) {
            Assert.fail("Element not found: " + element);
        }

    }

    public static void uploadFilePath(String filePath) {
        try {
            waitFor(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, (ClipboardOwner)null);
            Robot robot = new Robot();
            robot.keyPress(17);
            waitFor(3);
            robot.keyPress(86);
            waitFor(3);
            robot.keyRelease(17);
            waitFor(3);
            robot.keyRelease(86);
            waitFor(3);
            System.out.println("YAPISTIRMA ISLEMI : PASSED");
            waitFor(3);
            robot.keyPress(10);
            waitFor(3);
            robot.keyRelease(10);
            waitFor(3);
            System.out.println("DOSYA YUKLENDI ");
        } catch (Exception var3) {
        }

    }
}
