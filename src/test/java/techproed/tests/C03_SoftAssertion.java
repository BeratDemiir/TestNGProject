package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void softAssertTest() {
        // 1.Adim softAssert objesi olustur.
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Satir 13");
        softAssert.assertEquals(2,5);// FAIL
        System.out.println("Satir 15");
        softAssert.assertTrue("JAVA".contains("U"));// FAIL
        System.out.println("Satir 17");
        softAssert.assertTrue(true);// PASS
        System.out.println("Satir 19");
        softAssert.assertAll();// PASS yada FAIL olarak assertion lari isaretler
    }
}
