package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        CartPage cartPage = new CartPage(driver);

        // Открываем корзину
        cartPage.openCart();

        // Оформляем заказ
        cartPage.placeOrder();

        // Проверяем, что открылась форма оформления заказа
        Assert.assertTrue(driver.getPageSource().contains("Place Order"), "Форма заказа не открылась!");
    }
}
