package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class ListenersTest4 {

    @Test
    public void test1(){
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("FAIL");
//        throw new NoSuchElementException("No Such Element Exception");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));//FAIL ETSIN
    }
    @Test
    public void test3(){
        System.out.println("SKIP");
        throw new SkipException("Metotu Atla");
    }
    @Test
    public void test4() {
        System.out.println("EXCEPTION");
//        throw new NoSuchElementException("No Such Element Exception");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));//FAIL ETSIN

    }

    @AfterClass
    public void afterClass() {
        Driver.closeDriver();
    }
}
