package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String BASE_URL = "https://6pm.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    abstract public String getUrl();

    public <T extends BasePage> T open() {
        driver.get(BASE_URL + getUrl());
        return (T) this;
    }
}
