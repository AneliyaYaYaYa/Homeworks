package test.cases.trello;

import pages.trello.LoginPage;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {

        UserActions.loadBrowser("trello.homePage");

    }

    @AfterClass
    public static void tearDown() {


        UserActions.quitDriver();
    }

    public void login() {

        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

    public void logout() {
        //I know, this should go into a page
        actions.waitForElementClickable("trello.logout.memberHeader");
        actions.clickElement("trello.logout.memberHeader");
        actions.waitForElementClickable("trello.logout.switchAccounts");
        actions.clickElement("trello.logout.switchAccounts");

    }


}
