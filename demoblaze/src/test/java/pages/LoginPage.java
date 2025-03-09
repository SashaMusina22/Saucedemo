package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By usernameLocator = By.id("nameofuser"); // Логин в шапке

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginModal() {
        driver.findElement(By.id("login2")).click();
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("loginusername")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    public WebElement getLoggedInUsernameElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(usernameLocator)));
    }

    public String getLoggedInUsername() {
        try {
            return getLoggedInUsernameElement().getText();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("🔄 Элемент стал устаревшим, повторяем попытку...");
            return getLoggedInUsernameElement().getText();
        }
    }
}
