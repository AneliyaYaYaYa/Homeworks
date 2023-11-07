package test.cases.jira;

import com.telerikacademy.testframework.UserActions;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.jira.ContentPage;
import pages.jira.LoginPage;
import pages.jira.ProjectPage;
import pages.jira.ProjectsPage;

public class BaseTest {
    UserActions actions = new UserActions();
    LoginPage loginPage = new LoginPage(actions.getDriver());
    ContentPage contentPage = new ContentPage(actions.getDriver());
    ProjectsPage projectsPage = new ProjectsPage(actions.getDriver());
    ProjectPage projectPage = new ProjectPage(actions.getDriver());
    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("jira.homePage");

    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }

    public void login() {
        loginPage.loginUser("user");
    }

}
