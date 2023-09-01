package test.cases.trello;

import org.junit.After;
import org.junit.Before;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import org.junit.Ignore;
import org.junit.Test;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardTest extends BaseTest {

    @Before
    public void beforeTests(){
        login();

    }
    @After
    public void afterTest(){
        logout();
    }



    @Test
    public void createBoardWhenCreateBoardClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addListToCard("To Do");
        boardPage.assertListExists("To Do");

        boardPage.deleteBoard();
    }


    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addListToCard("To Do");
        boardPage.addCardToList();
        boardPage.assertCardExists("My First Card");

        boardPage.deleteBoard();

    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addListToCard("To Do");
        boardPage.addListToCard("Doing");
        boardPage.addCardToList();
        boardPage.moveCardToList();
        boardPage.assertCardMoved("Doing", "My First Card");

        boardPage.deleteBoard();
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.deleteBoard();
       boardPage.assertBoardDeleted();

    }
}
