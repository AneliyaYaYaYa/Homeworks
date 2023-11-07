package pages.jira;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class ProjectPage extends BaseJiraPage {

    public ProjectPage(WebDriver driver) {
        super(driver, "jira.projectsPage");
    }

    //delete
    public void deleteProject(){
        String keyName = getUIMappingByKey("jira.keyName");
        navigateToPage();

        actions.waitForElementVisible("jira.projectsPage.selectProject", keyName);
        actions.clickElement("jira.projectsPage.selectProject", keyName);

        actions.waitForElementVisible("jira.projectPage.settings");
        actions.clickElement("jira.projectPage.settings");

        actions.waitForElementVisible("jira.projectPage.more");
        actions.clickElement("jira.projectPage.more");

        actions.waitForElementVisible("jira.projectPage.moveToTrash");
        actions.clickElement("jira.projectPage.moveToTrash");

        actions.waitForElementVisible("jira.projectPage.moveConfirm");
        actions.clickElement("jira.projectPage.moveConfirm");

        actions.waitForElementVisible("jira.project.goToTrash");
        actions.clickElement("jira.project.goToTrash");

        actions.waitForElementVisible("jira.projectPage.more");
        actions.clickElement("jira.projectPage.more");

        actions.waitForElementVisible("jira.project.deletePermanently");
        actions.clickElement("jira.project.deletePermanently");

        actions.waitForElementVisible("jira.project.deletePermanentlyConfirmation");
        actions.clickElement("jira.project.deletePermanentlyConfirmation");

    }

    public void linkStoryToBug(){
        String keyName = getUIMappingByKey("jira.keyName");
        String storyName = getUIMappingByKey("jira.storySummary");
        String bugName = getUIMappingByKey("jira.bugSummary");
        navigateToPage();

        actions.waitForElementVisible("jira.projectsPage.selectProject", keyName);
        actions.clickElement("jira.projectsPage.selectProject", keyName);

        actions.waitForElementVisible("jira.projectsPage.selectProjectsBacklog");
        actions.clickElement("jira.projectsPage.selectProjectsBacklog");

        actions.waitForElementVisible("jira.projectsPage.selectStory", storyName);
        actions.clickElement("jira.projectsPage.selectStory", storyName);

        actions.waitForElementVisible("jira.projectsPage.selectLinkIcon");
        actions.clickElement("jira.projectsPage.selectLinkIcon");

        actions.waitForElementVisible("jira.projectsPage.selectLinkButton");
        actions.clickElement("jira.projectsPage.selectLinkButton");

        actions.waitForElementVisible("jira.projectsPage.searchForIssueToBeLinked");
        actions.waitForElementClickable("jira.projectsPage.searchForIssueToBeLinked");
        actions.clickElement("jira.projectsPage.searchForIssueToBeLinked");
        driver.switchTo().activeElement().sendKeys(bugName, Keys.ENTER);

        actions.waitForElementVisible("jira.projectsPage.finalLinkButton");
        actions.clickElement("jira.projectsPage.finalLinkButton");

    }

    public void assertIssuesLinked(){
        actions.assertElementPresent("jira.projectPage.assertIssuesLinked");
    }

}
