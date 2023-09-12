package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartPage  extends BasePage {
    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    public By shoppingCartItems = By.className("inventory_item_name");
    //public By shoppingCartList = By.className("cart_list");
    public By checkOut = By.id("checkout");
    public List<WebElement> findItems() {
        return driver.findElements(shoppingCartItems);
    }

    public void clickCheckOut() {
        driver.findElement(checkOut).click();
    }
}
