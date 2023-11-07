package apiTrello;

import com.telerikacademy.testframework.PropertiesManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class TrelloApi {
    private RequestSpecification getRestAssured() {
        //Gson deserializer = new Gson();
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .baseUri(PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("trello.api.baseUrl"))
                .queryParam("key", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("trello.users.user.apiKey"))
                .queryParam("token", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("trello.users.user.apiToken"));
    }

    //authenticate
    public List<String> getUserBoards() {
        return getRestAssured()
                .get("/members/me")
                .thenReturn()
                .jsonPath()
                .get("idBoards");
    }

    //api create a board
    public BoardModel createBoard(String name, String desc) {
        return getRestAssured()
                .queryParam("name", name)
                .queryParam("description", desc)
                .when()
                .post("/board")
                .then()
                .extract()
                .response()
                .as(BoardModel.class);

    }

    //api create a list
    public ListModel createList(String boardId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .post("boards/" + boardId + "/lists")
                .then()
                .extract()
                .response()
                .as(ListModel.class);
    }

    //api: create card
    public Response createCard(String listId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .queryParam("idList", listId)
                .post( "/cards")
                .then()
                .extract()
                .response();
    }

    //api: cleanup
    public Response deleteBoard(String boardId) {
        return getRestAssured()
                .when()
                .delete("boards/" + boardId)
                .then()
                .extract()
                .response();
    }
}