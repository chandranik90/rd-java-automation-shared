import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestForGreetz {

    private WebDriver driver;

    @Test
    public void testLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.greetz.nl/auth/login");
        Thread.sleep(3000);
        WebElement loginFormElem = driver.findElement(By.id("loginForm"));
        String email = "valod@valod.com";
        String pass = "vvalodshnik15";

        loginFormElem.findElement(By.name("email")).sendKeys(email);
        loginFormElem.findElement(By.name("password")).sendKeys(pass);

        driver.findElement(By.id("login-cta")).click();
        Thread.sleep(5000);
//        Assert.assertTrue(isLoggedIn("Valody"), "Failed to log in user " + email);

        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='header-message']//span[text()='Welkom Valod']")).size() > 0,
                "Failed to log in user " + email);
    }

    public boolean isLoggedIn(String firstName) {
        try {
            driver.findElement(By.xpath("//div[@class='header-message']//span[text()='Welkom " + firstName + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
