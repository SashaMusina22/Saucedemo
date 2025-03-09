package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private By productLinks = By.cssSelector(".hrefch");
    private By addToCartButton = By.cssSelector("a[onclick*='addToCart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstProduct() {
        List<WebElement> products = driver.findElements(productLinks);
        if (!products.isEmpty()) {
            products.get(0).click(); // Открываем первый товар
        } else {
            throw new RuntimeException("Ошибка: Нет доступных товаров на странице!");
        }
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}
