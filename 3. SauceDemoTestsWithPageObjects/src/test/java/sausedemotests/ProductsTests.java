package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ProductsTests extends BaseTest {

    private String backpackTitle = "Sauce Labs Backpack";
    private String shirtTitle = "Sauce Labs Bolt T-Shirt";
//    private double backpackPrice = Double.parseDouble(driver.findElement(By.xpath("//div[@class='inventory_item_price' and(descendant::text()='29.99')]"))
//                .getText().replace("$", ""));
////    private double shirtPrice = ;

    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){

        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);
        inventoryPage.clickShoppingCartLink();
        shoppingCartPage.assertNavigated();

        var items = shoppingCartPage.findItems();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);
        inventoryPage.clickShoppingCartLink();

        shoppingCartPage.clickCheckOut();
        checkoutYourInformationPage.assertNavigated();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkoutYourInformationPage.clickContinue();

        checkoutOverviewPage.assertNavigated();

        var items = checkoutOverviewPage.findItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        //must find a way to get those prices from InventoryPage
        double total = checkoutOverviewPage.findTotalAsNum();
        double expectedPrice = 29.99 + 15.99 + 3.68 ;
        Assertions.assertEquals(expectedPrice, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);
        inventoryPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOut();
        checkoutYourInformationPage.assertNavigated();
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkoutYourInformationPage.clickContinue();
        // Complete Order
        checkoutOverviewPage.clickFinish();
        checkoutCompletePage.assertNavigated();
        checkoutCompletePage.clickBackHome();
        inventoryPage.assertNavigated();
        inventoryPage.clickShoppingCartLink();

        // Assert Items removed from Shopping Cart
        var items = shoppingCartPage.findItems();
        Assertions.assertEquals(0, items.size(), "ShoppingCart is not empty as expected");
    }
}