package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    private By signUpButton = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By submitButton = By.xpath("//button[text()='Sign up']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignUpModal() {
        driver.findElement(signUpButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUp() {
        driver.findElement(submitButton).click();
    }
}
