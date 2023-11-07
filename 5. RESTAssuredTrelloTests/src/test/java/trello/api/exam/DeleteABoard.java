package trello.api.exam;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteABoard extends BaseTestSetup {

    @Test
    public void delete_when_validDataProvided() {

            Response response = authorization_via_queryParam()
                .baseUri(BASE_URL+API_VERSION)
                .when()
                .delete(BOARDS_ENDPOINT +"/"+"64d62aa5d132dfeaec39683a");

            //Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code. Expected 200." );

            System.out.println("Status code = " + response.getStatusCode());
            System.out.println("Status body = " + response.getBody().asPrettyString());
    }

    @Test
    public void showAllBoards_when_requestSent(){
        String base = BASE_URL+API_VERSION+"/members/me?key="+ API_KEY + "&token="+ API_TOKEN;
        Response response = authorization_via_queryParam()
                .baseUri(base)
                .when()
                .get();
        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Status body = " + response.getBody().asPrettyString());

    }


//    @Test
//    public void delete_All_Boards_For_User() {
//        List<String> boardIds = new ArrayList<>();
//
//            Response response = authorization_via_queryParam()
//                    .get();
//        System.out.println("Status body = " + response.getBody().asPrettyString());
//
//            //Assert.assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200");
//           // Assert.assertEquals(response.jsonPath().get("id"), TRELLO_ID);
//            boardIds = response.jsonPath().get("idBoards");
//            if (boardIds.size() == 0)
//                System.out.println("No boards found for deletion");
//            for (String board:boardIds) {
//                given()
//                        .delete(String.format(DELETE_ALL_BOARDS, board));
//                Assert.assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200");
//            }
//            if (boardIds.size() != 0)
//                System.out.println("All existing boards were deleted");
//
//    }


}
