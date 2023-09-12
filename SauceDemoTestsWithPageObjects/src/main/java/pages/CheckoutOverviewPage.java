package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-two.html");
    }

    public By overviewTotal = By.className("summary_total_label");
    public By overviewItems = By.className("inventory_item_name");
    public By finishButton = By.id("finish");
    public List<WebElement> findItems() {
        return driver.findElements(overviewItems);
    }

    public String findTotal() {
        return driver.findElement(overviewTotal).getText();
    }
    public Double findTotalAsNum() {
        String price = findTotal();
        return  Double.parseDouble(price.replace("Total: $", ""));
    }
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

}
