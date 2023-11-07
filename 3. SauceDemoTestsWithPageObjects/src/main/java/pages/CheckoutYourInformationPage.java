package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }

    public By continueButton = By.id("continue");


    public void fillShippingDetails(String firstName, String lastName, String zip) {
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys(lastName);
        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));
        zipCodeInput.sendKeys(zip);
    }
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

}
