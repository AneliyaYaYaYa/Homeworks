package pages.jira;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class LoginPage extends BaseJiraPage{

    public LoginPage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }

    public void loginUser(String userKey) {
        String username = getConfigPropertyByKey("trello.users." + userKey + ".username");
        String password = getConfigPropertyByKey("trello.users." + userKey + ".password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible("jira.loginPage.username"); ////input[@name='username']
        actions.typeValueInField(username, "jira.loginPage.username");

        actions.waitForElementVisible("jira.loginPage.continueButton");
        actions.clickElement("jira.loginPage.continueButton");

        actions.waitForElementVisible("jira.loginPage.password");
        actions.typeValueInField(password, "jira.loginPage.password");

        actions.clickElement("jira.loginPage.loginButton");

        actions.waitForElementVisible("jira.homePageContent");
    }
}
