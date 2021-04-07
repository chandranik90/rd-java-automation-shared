package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.util.List;

public class HomePage extends BasePage {

    private final String homePageContent = "div[data-page-id='homepage-new']";

    private String userName;

    @FindBy(css = "div[data-sub-nav]>ul>li>a")
    private List<WebElement> navElems;

    @FindBy(css = homePageContent)
    private WebElement homePageContentElem;

    private WebElement getElem(String s, int i) {
        return driver.findElement(By.xpath(""));
    }

    private By homepageContentLoc = By.cssSelector(homePageContent);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "/";
    }

    public void clickOnNavElementByText(String navText) {
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
//        wait.until(ExpectedConditions.numberOfElementsToBe(navBarLinksLoc,10));
    }
}
