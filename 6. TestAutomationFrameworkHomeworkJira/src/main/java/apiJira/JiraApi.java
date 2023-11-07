package apiJira;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;

public class JiraApi {
    public static final String YOUR_JIRA_INSTANCE = "myjiratesttotelerikaccount";
    public static final String BASE_URL = "https://" + YOUR_JIRA_INSTANCE + ".atlassian.net";

    public static String createProjectBody = "{\n" +
            "  \"assigneeType\": \"PROJECT_LEAD\",\n" +
            "  \"avatarId\": 10200,\n" +
            "  \"categoryId\": 10120,\n" +
            "  \"description\": \"Cloud migration initiative\",\n" +
            "  \"issueSecurityScheme\": 10001,\n" +
            "  \"key\": \"TEST\",\n" +
            "  \"leadAccountId\": \"712020:383ead62-daae-475c-b185-f40f86acb35b\",\n" +
            "  \"name\": \"Example Test\",\n" +
            "  \"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-simplified-scrum-classic\",\n" +
            "  \"projectTypeKey\": \"software\",\n" +
            "  \"url\": \"http://atlassian.com\"\n" +
            "}";

    //authorisation
    public void basicAuthorisation() {
        PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
        basicAuth.setUserName("jira.users.user.username");
        basicAuth.setPassword("jira.users.user.apiToken");
        RestAssured.authentication = basicAuth;
    }

    //create a project and get project key

    public Response createAProject(){

        return RestAssured.given()
                .auth().preemptive().basic("jira.users.user.username", "jira.users.user.apiToken")
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(createProjectBody)
                .post("/rest/api/2/project");
    }

    public Response deleteAProject(){
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
        basicAuth.setUserName("jira.users.user.username");
        basicAuth.setPassword("jira.users.user.apiToken");
        RestAssured.authentication = basicAuth;

        return RestAssured.given()
                .auth().preemptive().basic("jira.users.user.username", "jira.users.user.apiToken")
                .baseUri(BASE_URL)
                .contentType("application/json")
                .delete("/rest/api/2/project/"+"jira.keyName");
    }

}
