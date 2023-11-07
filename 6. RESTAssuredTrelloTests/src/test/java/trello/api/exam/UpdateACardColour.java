package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.API_VERSION;
import static com.telerikacademy.api.tests.Endpoints.CARDS_UPDATE_ENDPOINT;
import static io.restassured.RestAssured.given;

public class UpdateACardColour extends BaseTestSetup {

    @Test
    public void updateACard_when_validDataProvided() {

        Response response = authorization_via_queryParam()
                .baseUri(BASE_URL+API_VERSION)
                .body(UPDATE_A_CARD_COLOR)
                .when()
                .put(CARDS_UPDATE_ENDPOINT + CARD_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );
        Assert.assertEquals(response.getBody().jsonPath().get("cover.color"), TARGET_COLOR);


        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());
        System.out.println("Status color = " + response.getBody().jsonPath().get("cover.color"));
    }
}
