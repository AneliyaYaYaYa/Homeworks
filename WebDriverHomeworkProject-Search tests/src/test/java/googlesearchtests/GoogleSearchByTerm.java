package googlesearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import Enum.DriverType;

public class GoogleSearchByTerm {


    private static final String ALPHA_SEARCH_RESULT = "IT Career Start in 6 Months - Telerik Academy Alpha";
    private static final String ALPHA_SEARCH_RESULT_2 = "Telerik Academy Alpha - IT Career Start in 6 Months";
    private static final String ERROR_MESSAGE = "The first result found was not as expected";
    private static final String SELENIUM_CDP_RESULT = "Chrome DevTools - Selenium";
    private static final String GOOGLE_COM = "https://www.google.com/";
    private static final String TELERIK_ACADEMY_ALPHA = "Telerik Academy Alpha";
    public static final String CDP_SELENIUM = "cdp + selenium";
    private static WebDriver driver;

    @BeforeAll
    public static void startUpClass() {
        driver = DriverType.choseDriver(DriverType.CHROME_HEADLESS);
        driver.get(GOOGLE_COM);

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
        driver.get(GOOGLE_COM);
    }

    @Test
    public void correctResultFound_when_searchingByTerm_telerikAcademyAlpha() {
        WebElement searchField = driver.findElement
                (By.xpath("//textarea[@name='q'][@class='gLFyf']"));
        searchField.sendKeys(TELERIK_ACADEMY_ALPHA);

        WebElement searchButton = driver.findElement
                (By.xpath("//input[@name='btnK'][1]"));
        searchButton.click();

        WebElement searchFirstResult = driver.findElement
                (By.xpath("//a/h3[@class='LC20lb MBeuO DKV0Md'][1]"));
        Assertions.assertTrue(searchFirstResult.getText().contains(ALPHA_SEARCH_RESULT) ||
                (searchFirstResult.getText().contains(ALPHA_SEARCH_RESULT_2)), ERROR_MESSAGE );
    }
//  additional test
//    @Test
//    public void correctResultFound_when_searchingByTerm_cdpselenium() {
//        WebElement searchField = driver.findElement
//                (By.xpath("//textarea[@name='q'][@class='gLFyf']"));
//        searchField.sendKeys(CDP_SELENIUM);
//
//        WebElement searchButton = driver.findElement
//                (By.xpath("//input[@name='btnK'][1]"));
//        searchButton.click();
//
//        WebElement searchFirstResult = driver.findElement
//                (By.xpath("//a/h3[@class='LC20lb MBeuO DKV0Md'][1]"));
//        Assertions.assertTrue(searchFirstResult.getText().contains(SELENIUM_CDP_RESULT), ERROR_MESSAGE );
//    }
}
