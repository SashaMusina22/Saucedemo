package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;

import java.time.Duration;

public class SignUpTest extends BaseTest {
    public static String generatedUsername;

    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.openSignUpModal();

        // Генерируем уникальное имя пользователя
        generatedUsername = "user" + System.currentTimeMillis();
        String password = "newPassword123";

        // Заполняем данные
        signUpPage.enterUsername(generatedUsername);
        signUpPage.enterPassword(password);
        signUpPage.clickSignUp();

        System.out.println("SignUp выполнен, username = " + generatedUsername);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            Assert.assertEquals(alertText, "Sign up successful.");
            alert.accept();
        } catch (Exception e) {
            System.out.println("Ошибка: Alert не появился!");
            Assert.fail("Alert не найден после регистрации!");
        }
    }
}
