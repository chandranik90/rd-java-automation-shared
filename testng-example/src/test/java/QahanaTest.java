import org.testng.annotations.*;
import org.testng.*;
import org.testng.asserts.*;

public class QahanaTest {

    private Qahana qahana = new Qahana();

    @Test
    public void bigAmountTest() throws Exception {
        int actualCashback = qahana.aghotel(100000, "test");
        int expectedCashback = 10000;
        Assert.assertEquals(actualCashback, expectedCashback);
    }

    @Test
    public void boundaryAmountTest() throws Exception {
        int actualCashback = qahana.aghotel(10000, "test");
        int expectedCashback = 1000;

        String actualCurrency = "AMD";
        String expectedCurrency = "EUR";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCurrency, expectedCurrency);
        softAssert.assertEquals(actualCashback, expectedCashback+1);
        softAssert.assertAll();
    }

    @Test(expectedExceptions = Exception.class)
    public void smallAmountTest() throws Exception {
        qahana.aghotel(9999, "test");
    }
}
