import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccessoriesPage;
import pages.HomePage;
import pages.ProductsPage;

public class ProductsDisplayTest {

    private WebDriver driver;

    @BeforeMethod
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://6pm.com");
    }

    @Test
    public void testProductsDisplay() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilPageLoads();
        homePage.clickOnNavElementByText("Accessories");
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        accessoriesPage.waitForPageLoad();
        accessoriesPage.clickOnProductByText("Hats");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.waitForPageLoad();
        productsPage.clickOnFilterElem("$25.00 and Under");
        productsPage.waitForPageLoad();
        Assert.assertEquals(productsPage.getAllProductsCount(),69,
                "Products actual count differs from expected one");
//        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
