package pages.demoqa;

import base.BaseUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DroppablePage extends BaseUtil {
    WebDriverWait wait;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void dragAndDrop() {
        WebElement draggableBox = driver.findElement(By.id("draggable"));
        WebElement droppableBox = driver.findElement(By.id("droppable"));
        Actions act = new Actions(driver);
        act.clickAndHold(draggableBox)
                .moveToElement(droppableBox)
                .release()
                .build()
                .perform();
    }

    public void printTheTextFromDroppableBox() {
        WebElement textFromDroppableBox = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
        String text = textFromDroppableBox.getText();
        System.out.println(text);
    }

    public void takeAScreenshot(String fileName) throws IOException {
        TakesScreenshot t = (TakesScreenshot) driver;
        File srcFile = t.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + fileName +"_"+actualDate+ ".png";
        FileUtils.copyFile(srcFile,new File(screenshotPath));
    }
    public void clickOnWidgetSection(){
        WebElement widgetsSection = driver.findElement(By.xpath("//div[@class='header-wrapper' and contains(.//div,'Widgets')]"));
        widgetsSection.click();
    }
    public void clickOnToolTips(){
        WebElement toolTips = driver.findElement(By.xpath("//li[@id='item-6' and contains (.//span,'Tool Tips')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", toolTips);
    }

}
