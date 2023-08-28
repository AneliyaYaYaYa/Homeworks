package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTest {

    public static final String URL = "https://www.saucedemo.com/";
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void startUp() {
        driver = BrowserTypes.choseDriver(BrowserTypes.CHROME);

        driver.get(URL);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //authenticateWithUser("standard_user","secret_sauce");
    }

    @AfterAll
    public static void terminate() {
        driver.close();
    }

//    @BeforeEach
//    public void setUpTests() {
//        driver.navigate().to(URL);
//    }

    protected static void authenticateWithUser(String username, String pass){
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys(username);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pass);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement inventoryPageTitle = driver.findElement(By.xpath("//div[@class='app_logo']"));
        wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));

    }
    protected static void addProductsToCart() {
        authenticateWithUser("standard_user","secret_sauce");
        //add backpack and t-shirt to cart
        WebElement chooseBackPack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        chooseBackPack.click();
        WebElement chooseTShirt = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        chooseTShirt.click();
        //click on shopping cart
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
    }
    protected static void addUsersDetails(UserDetails details) {
//(String myFirstName, String myLastName, String myZipCode)
        driver.findElement(By.id("checkout")).click();
        //fill contact details
        driver.findElement(By.id("first-name")).sendKeys(details.firstName);
        driver.findElement(By.id("last-name")).sendKeys(details.lastName);
        driver.findElement(By.id("postal-code")).sendKeys(details.zipCode);
        driver.findElement(By.id("continue")).click();

    }

//    public  WebElement getProductByTile(String title){
//        return driver.findElement(By.xpath(String.format(
//                "//div[@class='inventory_item' and descendant::div[text()='%s']]", title)));
//    }
}


