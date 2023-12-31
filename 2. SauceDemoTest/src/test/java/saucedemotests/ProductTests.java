package saucedemotests;

import core.BaseTest;
import core.UserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.ErrorMessages.*;

public class ProductTests extends BaseTest {

//    //VERSION_1
//    @ParameterizedTest
//    @CsvSource ({
//            "Sauce Labs Backpack, $29.99",
//            "Sauce Labs Bike Light, $9.99",
//            "Sauce Labs Bolt T-Shirt, $15.99",
//            "Sauce Labs Fleece Jacket, $49.99",
//            "Sauce Labs Onesie, $7.99",
//            "Test.allTheThings() T-Shirt (Red), $15.99"
//    })
//    public void productAddedToShoppingCart_when_addToCart(String searchTerm, String searchPrice) {
//        authenticateWithUser(new LoginForm(USERNAME, PASSWORD));
//        WebElement chooseProduct = getProductByTile(searchTerm);
//        chooseProduct.findElement(By.className("btn_inventory")).click();
//        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
//        shoppingCart.click();
//
//        var items = driver.findElements(By.className("inventory_item_name"));
//        var prices = driver.findElements(By.className("inventory_item_price"));
//
//        Assertions.assertEquals(searchTerm, items.get(0).getText(),
//                PRODUCT_ERROR_MSG);
//        Assertions.assertEquals(searchPrice, prices.get(0).getText(),
//                PRICE_ERROR_MSG);
//        System.out.println(PRODUCTS_SUCCESS_MSG);
//    }
        //VERSION_2
        @Test
        public void productAddedToShoppingCart_when_addToCart() {
            addProductsToCart();

            var items = driver.findElements(By.className("inventory_item_name"));
            Assertions.assertEquals(2,items.size(), ITEM_COUNT_ERROR_MSG);
            Assertions.assertEquals("Sauce Labs Backpack", items.get(0).getText(),
                    PRODUCT_ERROR_MSG);
            Assertions.assertEquals("Sauce Labs Bolt T-Shirt", items.get(1).getText(),
                    PRODUCT_ERROR_MSG);
            System.out.println(PRODUCTS_SUCCESS_MSG);
        }



    @Test
    public void usersDetailsAdded_when_checkOutWithValidInfo() {
        addProductsToCart();
        addUsersDetails(new UserDetails(FIRST_NAME, LAST_NAME, ZIP_CODE));

        var prices = driver.findElements(By.className("inventory_item_price"));
        var total = driver.findElement(By.className("summary_total_label")).getText();

        String firstPrice = prices.get(0).getText().substring(1);
        String secondPrice = prices.get(1).getText().substring(1);
        String vat = driver.findElement(By.className("summary_tax_label")).getText().substring(6);

        double calculatedTotal = Double.parseDouble(firstPrice) + Double.parseDouble(secondPrice) + Double.parseDouble(vat);
        String expectedTotal = String.format("Total: $%.2f", calculatedTotal);

        Assertions.assertEquals(2, prices.size(), ITEM_COUNT_ERROR_MSG);
        Assertions.assertEquals(expectedTotal, total, TOTAL_AMOUNT_ERROR_MSG);
        System.out.println(CHECKOUT_SUCCESS_MSG);
    }


    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        addProductsToCart();
        addUsersDetails(new UserDetails(FIRST_NAME, LAST_NAME, ZIP_CODE));

        driver.findElement(By.id("finish")).click();
        String expected= "Thank you for your order!";

        Assertions.assertEquals(expected, driver.findElement(By.xpath("//h2[@class='complete-header']")).getText(), ORDER_ERROR_MSG);
        System.out.println(ORDER_SUCCESS_MSG);

    }

    @Test
    public void shoppingCartEmpty_when_orderCompleted(){
        addProductsToCart();
        addUsersDetails(new UserDetails(FIRST_NAME, LAST_NAME, ZIP_CODE));

        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        var items = driver.findElements(By.className("cart_item"));
        Assertions.assertEquals(0, items.size(), SHOPPINGCART_ERROR_MSG);
        System.out.println(SHOPPINGCART_SUCCESS_MSG);

    }
}
