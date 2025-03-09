package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);

        // Добавляем первый товар в корзину
        productsPage.openFirstProduct();
        productsPage.addToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText().trim();
        alert.accept();

        Assert.assertEquals(alertText, "Product added", "Ошибка: Сообщение после добавления товара неверное!");
    }
}
