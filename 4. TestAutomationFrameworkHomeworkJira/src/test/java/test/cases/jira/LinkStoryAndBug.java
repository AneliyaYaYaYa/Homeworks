package test.cases.jira;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkStoryAndBug extends BaseTest {

    //api: create a story, get the key/id (use models)
    //api: create a bug, get the key/id (use models)
    @Before
    public void beforeTests() {
        login();
        contentPage.openJira();
        projectsPage.createAProject();
        projectsPage.assertProjectCreated();
        projectsPage.createIssue("Story");
        projectsPage.createIssue("Bug");

    }

    @After
    public void afterTest() {
        projectPage.deleteProject();
    }

    @Test
    public void linkStoryToBug_when_validActionsPerformed() {
        projectPage.linkStoryToBug();
        projectPage.assertIssuesLinked();

    }

}
