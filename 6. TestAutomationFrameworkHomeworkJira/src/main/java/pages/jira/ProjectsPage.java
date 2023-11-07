package pages.jira;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class ProjectsPage extends BaseJiraPage {


    public ProjectsPage(WebDriver driver) {
        super(driver, "jira.projectsPage");
    }

    public void createAProject() {
        String projectName = getUIMappingByKey("jira.projectName");
        String keyName = getUIMappingByKey("jira.keyName");

        actions.waitForElementVisible("jira.projectsPage.createAProject");
        actions.clickElement("jira.projectsPage.createAProject");

        actions.waitForElementVisible("jira.projectsPage.scrumProject");
        actions.clickElement("jira.projectsPage.scrumProject");

        actions.waitForElementVisible("jira.projectsPage.useTemplate");
        actions.clickElement("jira.projectsPage.useTemplate");

        actions.waitForElementVisible("jira.projectsPage.selectTeamManagedProject");
        actions.clickElement("jira.projectsPage.selectTeamManagedProject");

        actions.waitForElementVisible("jira.projectsPage.projectNameInput");
        actions.typeValueInField(projectName, "jira.projectsPage.projectNameInput");

        actions.waitForElementVisible("jira.projectsPage.projectKeyInput");
        actions.typeValueInField(keyName, "jira.projectsPage.projectKeyInput");

        actions.waitForElementVisible("jira.projectsPage.nextButton");
        actions.clickElement("jira.projectsPage.nextButton");
    }

    public void assertProjectCreated() {
        String keyName = getUIMappingByKey("jira.keyName");
        navigateToPage();
        actions.waitForElementPresent("jira.projectsPage.assertProjectPresent", keyName);

    }

    public void openProject(String projectName) {
        navigateToPage();

        actions.waitForElementVisible("jira.projectsPage.findNewProject", projectName);
        actions.clickElement("jira.projectsPage.findNewProject", projectName);

    }

    public void createIssue(String issueType) {
        String summary="";
        String description = "";
        String projectKey = getUIMappingByKey("");

        if(issueType=="Story"){
        summary = getUIMappingByKey("jira.storySummary");
        description = getUIMappingByKey("jira.storyDescr");
        } else if (issueType=="Bug") {
            summary = getUIMappingByKey("jira.bugSummary");
            description = getUIMappingByKey("jira.storyDescr");
        }
        navigateToPage();

        actions.waitForElementVisible("jira.projectsPage.createButton");
        actions.clickElement("jira.projectsPage.createButton");

        actions.waitForElementVisible("jira.projectsPage.selectProjectDropdown");
        actions.waitForElementClickable("jira.projectsPage.selectProjectDropdown");
        actions.clickElement("jira.projectsPage.selectProjectDropdown");
        driver.switchTo().activeElement().sendKeys(projectKey, Keys.ENTER);

        actions.waitForElementVisible("jira.projectsPage.selectIssueType");
        actions.waitForElementClickable("jira.projectsPage.selectIssueType");
        actions.clickElement("jira.projectsPage.selectIssueType");
        driver.switchTo().activeElement().sendKeys(issueType, Keys.ENTER);

        actions.waitForElementVisible("jira.projectsPage.summaryField");
        actions.typeValueInField(summary, "jira.projectsPage.summaryField");

        actions.waitForElementVisible("jira.projectsPage.descriptionField");
        actions.typeValueInField(description, "jira.projectsPage.descriptionField");

        actions.waitForElementVisible("jira.projectsPage.createIssueButton");
        actions.clickElement("jira.projectsPage.createIssueButton");
    }

    public void assertIssueCreated() {
        String summary = getUIMappingByKey("jira.storySummery");
        openProject("My Scrum Project");
        actions.waitForElementVisible("jira.projectPage.openBacklog");
        actions.clickElement("jira.projectPage.openBacklog");

        actions.waitForElementPresent("jira.projectPage.issueName", summary);

    }


}
