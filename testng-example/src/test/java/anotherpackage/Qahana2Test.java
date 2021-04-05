package anotherpackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qahana.Qahana;

public class Qahana2Test {

    // Suite
    // Test
    // Class
    // Method

    private Qahana qahana = new Qahana();

    private int uuuuu;
    public Qahana2Test(int uuuuu) {
        this.uuuuu = uuuuu;
    }

    @BeforeClass
    public void beforeAllMethods() {
        System.out.println("before class 22222 executed");
    }

    @AfterClass
    public void afterAllMethods() {
        System.out.println("after 22222 class executed");
    }

    @BeforeMethod
    public void beforeEachTestMethod() {
        System.out.println("before method executed");
    }

    @AfterMethod
    public void afterEachTestMethod() {
        System.out.println("after method executed");
    }

    @Parameters({"valodParameter", "vramParameter"})
    @Test
    public void bigAmountTest(@Optional("default valod value") String valodParameter, @Optional("default vram value") String vramParameter) throws Exception {
        System.out.printf("parameters - %s, %s%n", valodParameter, vramParameter);
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

    @Test(dataProvider = "myDataProvider", dataProviderClass = DataGenerator.class)
    public void parameterizedTest(String p1, String p2, Integer p3) {
        System.out.println("Current thread - " + Thread.currentThread().getId());
        System.out.printf("test %s, %s, %d%n", p1, p2, p3);
//        Assert.assertEquals( p3.intValue(), 5, "P3 parameter is incorrect");
    }

    @Test(expectedExceptions = Exception.class)
    public void smallAmountTest() throws Exception {
        System.out.println("smallAmountTest test method executed");
        qahana.aghotel(9999, "test");
    }
}

class DataGenerator {

    @DataProvider(name = "myDataProvider", parallel = true)
    public static Object[][] myDataProviderMethod() {
        return new Object[][]
                {
                        {"Guru99", "India", 5},
                        {"Krishna", "UK", 7},
                        {"Bhupesh", "USA", -9},
                        {"Bhupesh", "Armenia", -9},
                        {"Vlad", "Fitness", 0},
                        {"Gaspar", "USA", -900}
                };

    }
}