package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    /*
    NOTE:  @Test(dependsOnMethods = "homeTest") methodlari birbirine baglamak icin kullanilir.
    NOTE: Assert.assertTrue(false); bu annotations o @Test method u  fail etmek icin kullanilir.
     */
    @Test
    public void homeTest() {
        System.out.println("Home Test");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "homeTest")
    public void searchTest() {
        System.out.println("Search Test");
    }

    @Test(dependsOnMethods = "homeTest")
    public void paymentTest() {
        System.out.println("Payment Test");
    }
}
