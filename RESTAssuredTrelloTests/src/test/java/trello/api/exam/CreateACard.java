package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.LIST_ID;
import static com.telerikacademy.api.tests.Endpoints.API_VERSION;
import static com.telerikacademy.api.tests.Endpoints.CARDS_ENDPOINT;
import static io.restassured.RestAssured.given;

public class CreateACard extends BaseTestSetup {

    @Test
    public void createACard_when_validDataProvided() {

        Response response = authorization_via_queryParam()
                .queryParam("idList", LIST_ID)
                .baseUri(BASE_URL+API_VERSION)
                .body(CREATE_A_CARD)
                .when()
                .post(CARDS_ENDPOINT);

        Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );
        Assert.assertEquals(response.getBody().jsonPath().get("name"), CARD_TITLE);

        CARD_ID = response.getBody().jsonPath().get("id");

        System.out.println("CardID = " + CARD_ID);
        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());
    }
}
