package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test(priority = 2, dependsOnMethods = "tests.SignUpTest.testSignUp") // Запуск после SignUpTest
    public void testLogin() {
        if (SignUpTest.generatedUsername.isEmpty()) {
            throw new IllegalStateException("Ошибка: username не установлен в SignUpTest!");
        }

        String username = SignUpTest.generatedUsername;
        String password = "newPassword123";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginModal();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginPage.getLoggedInUsernameElement())));

        String displayedUsername = loginPage.getLoggedInUsername();
        Assert.assertEquals(displayedUsername, "Welcome " + username, "Ошибка: Имя пользователя не отображается!");
        System.out.println("✅ Login выполнен для " + username);
    }
}
