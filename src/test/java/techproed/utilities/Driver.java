package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    // Driver.getDriver(); -> driver
    private static WebDriver driver;
    // getDriver() sürücü nesnesini örneklemek için kullanılır
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

//                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
//                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
   //      NOTE: sel 4.5
  //          driver = WebDriverManager.operadriver().create();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    // closeDriver() sürücüyü kapatmak için kullanılır
    public static void closeDriver(){
        // sürücü zaten kullanılıyorsa (bir nesneyi işaret ediyorsa)
        // daha sonra sürücüden çıkın
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
