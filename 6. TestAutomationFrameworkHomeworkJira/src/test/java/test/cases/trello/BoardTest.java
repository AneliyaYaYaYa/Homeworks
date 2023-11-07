package test.cases.trello;

import apiTrello.BoardModel;
import apiTrello.ListModel;
import apiTrello.TrelloApi;
import org.apache.http.HttpStatus;
import org.junit.*;

public class BoardTest extends BaseTest {

    private TrelloApi trelloApi = new TrelloApi();
    private BoardModel createdBoard;

    @Before
    public void beforeTests() {
        createdBoard = trelloApi.createBoard("board from automation", "descr from automation");
        Assert.assertNotNull(createdBoard.id);
        login();
    }

    @After
    public void afterTest() {
        var deletionBoard = trelloApi.deleteBoard(createdBoard.id);
        Assert.assertTrue(deletionBoard.statusCode() == HttpStatus.SC_OK);
        logout();
    }

    @Test
    public void createBoardWhenCreateBoardClicked() {

        boardsPage.createBoard();
        boardPage.addListToBoard("ListNameAutoTo");
        boardPage.assertListExists("ListNameAutoTo");

    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        ListModel responseList = trelloApi.createList(createdBoard.id, "listFromAutomation");

        boardPage.openBoard(createdBoard.name);
        boardPage.addCardToList(responseList.name);
        boardPage.assertCardExists("My First Card");
        boardPage.deleteBoard();

    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        ListModel responseListFrom = trelloApi.createList(createdBoard.id, "ListNameAutoFrom");
        ListModel responseListTo = trelloApi.createList(createdBoard.id, "ListNameAutoTo");
        trelloApi.createCard(responseListFrom.id, "CardNameAuto");

        boardPage.openBoard(createdBoard.name);
        boardPage.moveCardToList();
        boardPage.assertCardMoved(responseListTo.name, "CardNameAuto");

    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {

        boardPage.openBoard(createdBoard.name);
        boardPage.deleteBoard();
        boardPage.assertBoardDeleted();

    }
}
