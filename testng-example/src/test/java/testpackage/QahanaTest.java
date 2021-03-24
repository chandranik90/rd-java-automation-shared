package testpackage;

import org.testng.annotations.*;
import org.testng.*;
import org.testng.asserts.*;
import qahana.Qahana;

public class QahanaTest {

    // Suite
    // Test
    // Class
    // Method

    private Qahana qahana = new Qahana();

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite executed");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite executed");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test executed");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test executed");
    }

    @BeforeClass
    public void beforeAllMethods() {
        System.out.println("before 111111 class executed");
    }

    @AfterClass
    public void afterAllMethods() {
        System.out.println("after 111111 class executed");
    }

    @BeforeMethod
    public void beforeEachTestMethod() {
        System.out.println("before method executed");
    }

    @AfterMethod
    public void afterEachTestMethod() {
        System.out.println("after method executed");
    }

    @Test
    public void bigAmountTest() throws Exception {
        System.out.println("bigAmountTest test method executed");
        int actualCashback = qahana.aghotel(100000, "test");
        int expectedCashback = 10000;
        Assert.assertEquals(actualCashback, expectedCashback);
    }

    @Test
    public void boundaryAmountTest() throws Exception {
        System.out.println("boundaryAmountTest test method executed");
        int actualCashback = qahana.aghotel(10000, "test");
        int expectedCashback = 1000;

        String actualCurrency = "EUR";
        String expectedCurrency = "EUR";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCurrency, expectedCurrency);
        softAssert.assertEquals(actualCashback, expectedCashback);
        softAssert.assertAll();
    }

    @Test(expectedExceptions = Exception.class)
    public void smallAmountTest() throws Exception {
        System.out.println("smallAmountTest test method executed");
        qahana.aghotel(9999, "test");
    }
}
