package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-complete.html");
    }

    public By backHomeButton = By.id("back-to-products");

    public void clickBackHome() {
        driver.findElement(backHomeButton).click();
    }
}
