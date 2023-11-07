package pages.jira;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseJiraPage extends BasePage {

    public BaseJiraPage(WebDriver driver, String pageUrlKey) {
        super(driver, pageUrlKey);
    }


}
