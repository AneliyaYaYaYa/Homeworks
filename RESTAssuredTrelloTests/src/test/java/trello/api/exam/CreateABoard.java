package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.*;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;


public class CreateABoard extends BaseTestSetup {



    @Test
    public void createABoard_when_validDataProvided() {

        Response response = authorization_via_queryParam()
                .baseUri(BASE_URL+API_VERSION)
                .body(CREATE_A_BOARD)
                .when()
                .post(BOARDS_ENDPOINT);

        Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );
        Assert.assertEquals(response.getBody().jsonPath().get("name"), BOARD_TITLE);


        BOARD_ID = response.getBody().jsonPath().get("id");

        System.out.println(BOARD_ID);
        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());
    }

}
