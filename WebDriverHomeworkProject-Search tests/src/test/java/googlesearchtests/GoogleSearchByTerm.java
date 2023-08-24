package googlesearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import Enum.DriverType;

public class GoogleSearchByTerm {


    public static WebDriver driver;

    @BeforeAll
    public static void startUpClass() {
        driver = DriverType.choseDriver(DriverType.CHROME_HEADLESS);
        driver.get("https://www.google.com/");

        //implicit wait:
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement agreeToCookies = driver.findElement
                (By.xpath("//button[@id='L2AGLb']"));
        agreeToCookies.click();
    }

    @AfterAll
    public static void terminateClass() {
        driver.close();
    }

    @BeforeEach
    public void setUpTests() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void correctResultFound_when_searchingByTerm_telerikAcademyAlpha() {
        WebElement searchField = driver.findElement
                (By.xpath("//textarea[@name='q'][@class='gLFyf']"));
        searchField.sendKeys("Telerik Academy Alpha");

        WebElement searchButton = driver.findElement
                (By.xpath("//input[@name='btnK'][1]"));
        searchButton.click();

        WebElement searchFirstResult = driver.findElement
                (By.xpath("//a/h3[@class='LC20lb MBeuO DKV0Md'][1]"));
        Assertions.assertEquals
                ("IT Career Start in 6 Months - Telerik Academy Alpha",
                        searchFirstResult.getText(),
                        "The first result found was not as expected");
    }

    @Test
    public void correctResultFound_when_searchingByTerm_cdpselenium() {
        WebElement searchField = driver.findElement
                (By.xpath("//textarea[@name='q'][@class='gLFyf']"));
        searchField.sendKeys("cdp + selenium");

        WebElement searchButton = driver.findElement
                (By.xpath("//input[@name='btnK'][1]"));
        searchButton.click();

        WebElement searchFirstResult = driver.findElement
                (By.xpath("//a/h3[@class='LC20lb MBeuO DKV0Md'][1]"));
        Assertions.assertEquals
                ("Chrome DevTools - Selenium",
                        searchFirstResult.getText(),
                        "The first result found was not as expected");
    }
}
