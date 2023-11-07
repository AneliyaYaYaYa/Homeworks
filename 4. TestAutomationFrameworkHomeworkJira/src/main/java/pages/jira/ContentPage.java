package pages.jira;

import org.openqa.selenium.WebDriver;

public class ContentPage extends BaseJiraPage{
    public ContentPage(WebDriver driver) {
        super(driver, "jira.contentPage");
    }

    public void openJira(){
        actions.waitForElementVisible("jira.contentPage.jiraSoftware");
        actions.clickElement("jira.contentPage.jiraSoftware");

        actions.waitForElementVisible("jira.projectsPage.title");
    }

}
