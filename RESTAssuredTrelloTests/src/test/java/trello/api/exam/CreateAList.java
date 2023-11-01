package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.API_VERSION;
import static com.telerikacademy.api.tests.Endpoints.LIST_ENDPOINT;
import static io.restassured.RestAssured.given;

public class CreateAList extends BaseTestSetup {

    @Test
    public void createAList_when_validDataProvided() {

        Response response = authorization_via_queryParam()
                .queryParam("idBoard", BOARD_ID)
                .baseUri(BASE_URL+API_VERSION)
                .body(CREATE_A_LIST)
                .when()
                .post(LIST_ENDPOINT);

        Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );
        Assert.assertEquals(response.getBody().jsonPath().get("name"), LIST_TITLE);

        LIST_ID = response.getBody().jsonPath().get("id");

        System.out.println("ListID = " + LIST_ID);
        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());
    }
}
