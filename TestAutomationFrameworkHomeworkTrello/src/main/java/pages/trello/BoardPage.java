package pages.trello;

import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void openBoard() {
        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.boards.menu");
        actions.clickElement("trello.boards.menu");

        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.waitForElementClickable("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);

    }

    public void addListToCard(String listName){

        actions.waitForElementClickable("trello.createList.titleInput");
        actions.typeValueInField(listName, "trello.createList.titleInput");

        actions.waitForElementClickable("trello.createList.addButton");
        actions.clickElement("trello.createList.addButton");

    }

    public void addCardToList() {
        String cardName = getUIMappingByKey("trello.cardName");
        String listName = "To Do";


        actions.waitForElementClickable("trello.createCard.addButton", listName);
        actions.clickElement("trello.createCard.addButton", listName);

        actions.waitForElementClickable("trello.createCard.titleInput");
        actions.typeValueInField(cardName, "trello.createCard.titleInput");

        actions.clickElement("trello.createCard.submitButton");
    }

    public void moveCardToList() {

        String cardToBeMoved = getUIMappingByKey("trello.boardPage.CardToBeMoved");
        String listToBeMovedTo = getUIMappingByKey("trello.boardPage.newListToBeMovedTo");

        actions.waitForElementPresent(cardToBeMoved);
        WebElement moveThisCard = driver.findElement(By.xpath(cardToBeMoved));
        actions.waitForElementPresent(listToBeMovedTo);
        WebElement toThisPlace = driver.findElement(By.xpath(listToBeMovedTo));

        Actions move = new Actions(driver);
        move.dragAndDrop(moveThisCard, toThisPlace).build().perform();
        //move.dragAndDropBy(moveThisCard, 264, 1).build().perform();
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
