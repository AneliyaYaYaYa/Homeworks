package saucedemotests;

import core.BaseTest;
import core.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class LoginTest extends BaseTest {

    private static final String LOGIN_SUCCESS_MSG = "Logged in successful!";
    private static final String LOGIN_ERROR_MSG = "The Page Title does not correspondent to expected result";
    private static final String USERNAME = "standard_user";
    private static final String PASS = "secret_sauce";

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        authenticateWithUser(new LoginForm(USERNAME, PASS));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).getText().equals("Swag Labs"),
                LOGIN_ERROR_MSG);
        System.out.println(LOGIN_SUCCESS_MSG);
    }
}
