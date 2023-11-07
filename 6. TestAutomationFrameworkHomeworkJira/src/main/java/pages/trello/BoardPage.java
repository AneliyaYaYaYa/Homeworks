package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void openBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.waitForElementClickable("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);

    }

    public void addListToBoard(String listName){
        actions.waitForElementClickable("trello.createList.titleInput");
        actions.typeValueInField(listName, "trello.createList.titleInput");

        actions.waitForElementClickable("trello.createList.addButton");
        actions.clickElement("trello.createList.addButton");

    }

    public void addCardToList(String listName) {
        String cardName = getUIMappingByKey("trello.cardName");

        actions.waitForElementClickable("trello.createCard.addButton", listName);
        actions.clickElement("trello.createCard.addButton", listName);

        actions.waitForElementClickable("trello.createCard.titleInput");
        actions.typeValueInField(cardName, "trello.createCard.titleInput");

        actions.clickElement("trello.createCard.submitButton");
    }

    public void moveCardToList() {
        actions.waitForElementVisible("trello.boardPage.cardByName");
        actions.dragAndDropElement("trello.boardPage.cardByName", "trello.boardPage.listByName");
    }

    public void deleteBoard() {
        actions.waitForElementClickable("trello.boardPage.board.sideMenu");
        actions.clickElement("trello.boardPage.board.sideMenu");

        actions.waitForElementClickable("trello.boardPage.board.closeBoard");
        actions.clickElement("trello.boardPage.board.closeBoard");

        actions.waitForElementClickable("trello.boardPage.board.closeBoardConfirm");
        actions.clickElement("trello.boardPage.board.closeBoardConfirm");

    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertCardExists(String cardName) {
        actions.waitForElementPresent("trello.boardPage.CardByName", cardName);
    }

    public void assertCardMoved(String listName, String cardName) {
        actions.waitForElementPresent("trello.boardPage.assertCardMovedToNewList", listName, cardName);
    }

    public void assertBoardDeleted() {
        actions.waitForElementPresent("trello.boardPage.assertBoardDeleted");
    }
}
