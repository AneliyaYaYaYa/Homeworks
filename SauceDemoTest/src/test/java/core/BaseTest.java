package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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

    @BeforeEach
    public  void startUp() {
        driver = BrowserTypes.choseDriver(BrowserTypes.CHROME);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterEach
    public  void terminate() {
        driver.close();
    }

//    @AfterEach
//    public void resetApp() {
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reset_sidebar_link")));
//        driver.findElement(By.id("reset_sidebar_link")).click();
//        driver.get("https://www.saucedemo.com/inventory.html");
//    }

    protected static void authenticateWithUser(LoginForm login) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys(login.getUsername());

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(login.getPassword());

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement inventoryPageTitle = driver.findElement(By.xpath("//div[@class='app_logo']"));
        wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));

    }

    protected static void addProductsToCart() {
        authenticateWithUser(new LoginForm("standard_user", "secret_sauce"));
//        //add backpack and t-shirt to cart
//        WebElement chooseBackPack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
//        chooseBackPack.click();
//        WebElement chooseTShirt = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
//        chooseTShirt.click();

        // add backpack and t-shirt to cart
        String backPack = "Sauce Labs Backpack";
        String tshirt = "Sauce Labs Bolt T-Shirt";

        WebElement chooseBackpack = getProductByTile(backPack);
        chooseBackpack.findElement(By.className("btn_inventory")).click();
        WebElement chooseTshirt = getProductByTile(tshirt);
        chooseTshirt.findElement(By.className("btn_inventory")).click();

        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
    }

    protected static WebElement getProductByTile(String title) {
        return driver.findElement(By.xpath(String.format(
                "//div[@class='inventory_item' and descendant::div[text()='%s']]", title)));
    }

    protected static void addUsersDetails(UserDetails details) {

        driver.findElement(By.id("checkout")).click();
        //fill contact details
        driver.findElement(By.id("first-name")).sendKeys(details.firstName);
        driver.findElement(By.id("last-name")).sendKeys(details.lastName);
        driver.findElement(By.id("postal-code")).sendKeys(details.zipCode);
        driver.findElement(By.id("continue")).click();

    }


}


