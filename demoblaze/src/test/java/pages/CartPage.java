package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By cartItems = By.cssSelector("#tbodyid tr");
    private By placeOrderButton = By.cssSelector("button[data-target='#orderModal']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(By.id("cartur")).click();
    }

    public boolean isProductInCart() {
        List<WebElement> products = driver.findElements(cartItems);
        return !products.isEmpty();  // Если список не пуст, значит товар в корзине
    }

    public void placeOrder() {
        driver.findElement(placeOrderButton).click();
    }
}
