package test.cases.trello;

import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import org.junit.Ignore;
import org.junit.Test;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardTest extends BaseTest {

    @Test
    public void createBoardWhenCreateBoardClicked() {

        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertListExists("To Do");
    }


    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();
        boardPage.addCardToList();
        boardPage.assertCardExists("My First Card");

    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {

        login();
        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();
        boardPage.moveCardToList();
        boardPage.assertCardMoved("Doing", "My First Card");
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {

        login();
        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();
        boardPage.deleteBoard();
        boardPage.assertBoardDeleted();
    }
}
