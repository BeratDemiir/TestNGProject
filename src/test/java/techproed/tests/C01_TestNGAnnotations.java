package techproed.tests;

import org.testng.annotations.*;

public class C01_TestNGAnnotations {

    /*
      @Test: Test case olusturmak icin kullanilir
      @Before ve @After : 5 Before 5 After annotations var
      suite > tests > grup > class > method

      @BeforeSuite : Her bir test suite den once 1 sefer calisir
      @AfterSuite : Her bir test suite den sonra 1 sefer calisir
      @BeforeTest : Her bir test den once (Test Case ile karistirilmamali) 1 sefer calisir
      @AfterTest : Her bir test den sonra (Test Case ile karistirilmamali) 1 sefer calisir
      @BeforeClass : Her bir class dan once 1 sefer calisir
      @AfterClass : Her bir class dan sonra 1 sefer calisir
      @BeforeMethod : Her bir @Test annotationsdan once tek sefer calisir. JUnitdeki karsiligi @Before
      @AfterMethod : Her bir @Test annotationsdan sonra tek sefer calisir. JUnitdeki karsiligi @After

      @Ignore : @Test caseleri atlamak icin kullanilir
      (enabled = false) : @Test caseleri kullanima kapatmak icin kullanilir

      NOTE: TestNG de test case ler isim sirasina gore calisir
      @Test(priority = x) : Test caseler oncelemek icin kullanilir x degeri hangisi kucukse o once calisir.

     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Group");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test @Ignore
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 1)
    public void test8() {
        System.out.println("Test 2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("Test 4");
    }

    @Test(priority = 4)
    public void test5() {
        System.out.println("Test 5");
    }

    @Test(priority = 2)
    public void test6() {
        System.out.println("Test 6");
    }
}
