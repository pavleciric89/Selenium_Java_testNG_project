package tests;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.demoqa.DroppablePage;
import pages.demoqa.InteractionPage;
import pages.demoqa.MainPage;
import pages.demoqa.ToolTipsPage;
import pages.google.GooglePage;

import java.io.IOException;

public class Test_1 extends BaseUtil {
    @Test
    public void test() throws IOException {
        GooglePage googlePage = new GooglePage(driver);
        MainPage mainPage = new MainPage(driver);
        InteractionPage interactionPage = new InteractionPage(driver);
        DroppablePage droppablePage = new DroppablePage(driver);
        ToolTipsPage toolTipsPage = new ToolTipsPage(driver);

        googlePage.enterDemoQaInSearchInputAndPressEnter();
        googlePage.clickOnDemoQaFirstLink();
        mainPage.clickOnInteractionsCard();
        interactionPage.clickOnDroppableItem();
        droppablePage.dragAndDrop();
        droppablePage.printTheTextFromDroppableBox();
        droppablePage.takeAScreenshot("droppablePage");
        droppablePage.clickOnWidgetSection();
        droppablePage.clickOnToolTips();
        toolTipsPage.printTheTextFromTooltipPopup();
    }



}
