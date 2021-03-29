package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;
    private String filterXpathtemplate = "//span[text()='%s']";
    private By priceFacetLoc = By.cssSelector("ul[aria-labelledby=priceFacet]");
    private By prodsLoc = By.cssSelector("#searchPage article");
    private WebDriverWait wait;

    public void clickOnFilterElem(String filterText) {
        driver.findElement(By.xpath(String.format(filterXpathtemplate,filterText))).click();
    }

//    public void login(String user, String pass) {
//        loginElem.sendKeys(user);
//        passElem.sendKeys(pass);
//        loginElem.click();
//    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceFacetLoc));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(prodsLoc,20));
    }

    public int getAllProductsCount() {
        return driver.findElements(prodsLoc).size();
    }
}
