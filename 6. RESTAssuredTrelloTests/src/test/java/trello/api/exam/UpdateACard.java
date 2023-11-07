package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.CARD_ID;
import static com.telerikacademy.api.tests.Endpoints.*;
import static io.restassured.RestAssured.given;

public class UpdateACard extends BaseTestSetup {

    @Test
    public void updateACard_when_validDataProvided() {

        Response response = authorization_via_queryParam()
                .baseUri(BASE_URL+API_VERSION)
                .body(UPDATE_A_CARD)
                .when()
                .put(CARDS_UPDATE_ENDPOINT + CARD_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );
        Assert.assertEquals(response.getBody().jsonPath().get("desc"), UPDATED_DESC);
        Assert.assertEquals(response.getBody().jsonPath().get("name"), UPDATED_TITLE);

        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());
    }
}
