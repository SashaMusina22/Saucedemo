package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpButton = By.id("signin2");
    private By loginButton = By.id("login2");
    private By cartButton = By.id("cartur");

    public void openSignUp() {
        driver.findElement(signUpButton).click();
    }

    public void openLogin() {
        driver.findElement(loginButton).click();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }
}
