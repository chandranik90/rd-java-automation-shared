package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By navBarLinksLoc = By.cssSelector("div[data-sub-nav]>ul>li>a");
    private By homepageContentLoc = By.cssSelector("div[data-page-id='homepage-new']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNavElementByText(String navText) {
        List<WebElement> navElems = driver.findElements(navBarLinksLoc);
        for (WebElement navLink: navElems) {
            if (navLink.getText().equalsIgnoreCase(navText)) {
                navLink.click();
                return;
            }
        }
        throw new RuntimeException("ERROR: No such text " + navText);
    }

    public void waitUntilPageLoads() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepageContentLoc));
        wait.until(ExpectedConditions.numberOfElementsToBe(navBarLinksLoc,10));
    }
}
