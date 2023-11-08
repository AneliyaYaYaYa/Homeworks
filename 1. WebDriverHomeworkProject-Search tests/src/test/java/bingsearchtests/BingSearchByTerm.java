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

    private static final String BING_COM = "https://www.bing.com/";
    private static final String TELERIK_ACADEMY_ALPHA = "Telerik Academy Alpha";
    private static final String ALPHA_SEARCH_RESULT = "IT Career Start in 6 Months - Telerik Academy Alpha";
    private static final String ALPHA_SEARCH_RESULT_2 = "Telerik Academy Alpha - IT Career Start in 6 Months";
    private static final String CDP_SELENIUM = "cdp + selenium";
    private static final String CDP_SEARCH_RESULT = "Chrome DevTools";
    private static final String ERROR_MESSAGE = "The first result found was not as expected";
    private static WebDriver driver;

    //explicit wait:
    private static WebDriverWait wait;

    @BeforeAll
    public static void startUp() {
        driver = DriverType.choseDriver(DriverType.EDGE);

        driver.navigate().to(BING_COM);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        driver.navigate().to(BING_COM);
    }
    @Test
    public void correctResultFound_when_searchingByTerm_telerikAcademyAlpha() {
        WebElement searchField = driver.findElement
                (By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys(TELERIK_ACADEMY_ALPHA);

        WebElement searchButton = driver.findElement
                (By.xpath("//label[@id='search_icon']"));
        searchButton.click();
        //some headless browsers were not working without the following wait:
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("(//h2)[1]")));
        WebElement searchFirstResult = driver.findElement
                (By.xpath("(//h2)[1]"));
        Assertions.assertTrue(searchFirstResult.getText().contains(ALPHA_SEARCH_RESULT) ||
                (searchFirstResult.getText().contains(ALPHA_SEARCH_RESULT_2)), ERROR_MESSAGE );
    }

    @Test
    public void correctResultFound_when_searchingByTerm_cdpselenium() {
        WebElement searchField = driver.findElement
                (By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys(CDP_SELENIUM, Keys.ENTER); //using keyboard <enter> instead of search button

        //Firefox browser is not working without the following wait:
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("(//h2/a)[1]")));
        WebElement searchFirstResult = driver.findElement
                (By.xpath("(//h2/a)[1]"));
        Assertions.assertTrue(searchFirstResult.getText().contains(CDP_SEARCH_RESULT), ERROR_MESSAGE );
    }
}
