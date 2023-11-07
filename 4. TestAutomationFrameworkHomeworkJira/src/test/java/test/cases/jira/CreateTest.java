package test.cases.jira;

import apiJira.JiraApi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateTest extends BaseTest {
    @Before
    public void beforeTests() {
        login();
        contentPage.openJira();
        projectsPage.createAProject();
        projectsPage.assertProjectCreated();
    }

    @After
    public void afterTest() {
    projectPage.deleteProject();
       // JiraApi jiraApi = new JiraApi();
       // jiraApi.deleteAProject();
    }

    @Test
    public void createIssue_when_validDataProvided() {
        //api:create a project

        projectsPage.createIssue("Story");
        projectsPage.createIssue("Bug");
        projectsPage.assertIssueCreated();

    }
}
