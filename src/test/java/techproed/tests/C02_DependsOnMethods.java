package techproed.tests;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test
    public void homeTest() {
        System.out.println("Home Test");
    }

    @Test
    public void searchTest() {
        System.out.println("Search Test");
    }

    @Test
    public void paymentTest() {
        System.out.println("Payment Test");
    }
}
