package saucedemotests;

import core.BaseTest;
import core.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.ErrorMessages.*;


public class LoginTest extends BaseTest {



    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        authenticateWithUser(new LoginForm(USERNAME, PASSWORD));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).getText().equals("Swag Labs"),
                LOGIN_ERROR_MSG);
        System.out.println(LOGIN_SUCCESS_MSG);
    }
}
