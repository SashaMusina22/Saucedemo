package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartContentTest extends BaseTest {

    @Test
    public void testCartContainsProduct() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openFirstProduct();
        productsPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        // Проверяем, что товар появился в корзине
        Assert.assertTrue(cartPage.isProductInCart(), "Ошибка: Добавленный товар не отображается в корзине.");
    }
}
