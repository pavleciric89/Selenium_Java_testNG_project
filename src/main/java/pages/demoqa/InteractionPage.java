package pages.demoqa;

import base.BaseUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InteractionPage extends BaseUtil {
    WebDriverWait wait;

    public InteractionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void clickOnDroppableItem() {
        WebElement droppableItem = driver.findElement(By.xpath("//li[@id='item-3' and contains (.//span,'Droppable')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", droppableItem);

    }

}
