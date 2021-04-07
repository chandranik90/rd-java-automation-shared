package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    private String filterXpathtemplate = "//span[text()='%s']";
    private By priceFacetLoc = By.cssSelector("ul[aria-labelledby=priceFacet]");
    private By prodsLoc = By.cssSelector("#searchPage article");

    public void clickOnFilterElem(String filterText) {
        driver.findElement(By.xpath(String.format(filterXpathtemplate,filterText))).click();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "/";
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
