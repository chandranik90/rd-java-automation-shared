package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesPage extends BasePage {

    private String prodNameLocTemplate = "//p[text()='%s']";
    private By articlesLoc = By.tagName("article");
    private By navBarLinksLoc = By.cssSelector("div[data-sub-nav]>ul>li>a");

    private String url = "c/accessories";

    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void clickOnProductByText(String prodName) {
        WebElement prodNameElem = driver.findElement(By.xpath(String.format(prodNameLocTemplate,prodName)));
        prodNameElem.click();
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(articlesLoc,5));
    }

}
