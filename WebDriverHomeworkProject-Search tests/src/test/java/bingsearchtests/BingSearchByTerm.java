package bingsearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import Enum.DriverType;

public class BingSearchByTerm {

    public static WebDriver driver;
    //explicit wait:
    public static WebDriverWait wait;

    @BeforeAll
    public static void startUp() {
        driver = DriverType.choseDriver(DriverType.EDGE_HEADLESS);

        driver.navigate().to("https://www.bing.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("//button[@id='bnp_btn_accept']")));

        WebElement agreeToCookies = driver.findElement
                (By.xpath("//button[@id='bnp_btn_accept']"));
        agreeToCookies.click();
    }

    @AfterAll
    public static void terminate() {
        driver.close();
    }

    @BeforeEach
    public void setUpTests() {
        driver.navigate().to("https://www.bing.com/");
    }
    @Test
    public void correctResultFound_when_searchingByTerm_telerikAcademyAlpha() {
        WebElement searchField = driver.findElement
                (By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys("Telerik Academy Alpha", Keys.ENTER);

        //Firefox browser is not working without the following wait:
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("(//h2/a)[1]")));
        WebElement searchFirstResult = driver.findElement
                (By.xpath("(//h2/a)[1]"));
        Assertions.assertEquals
                ("IT Career Start in 6 Months - Telerik Academy Alpha",
                        searchFirstResult.getText(),
                        "The first result found was not as expected");
    }
    @Test
    public void correctResultFound_when_searchingByTerm_cdpselenium() {
        WebElement searchField = driver.findElement
                (By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys("cdp + selenium", Keys.ENTER); //using keyboard <enter> instead of search button

        //Firefox browser is not working without the following wait:
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("(//h2/a)[1]")));
        WebElement searchFirstResult = driver.findElement
                (By.xpath("(//h2/a)[1]"));
        Assertions.assertEquals
                ("Chrome DevTools | Selenium",
                        searchFirstResult.getText(),
                        "The first result found was not as expected");
    }
}
