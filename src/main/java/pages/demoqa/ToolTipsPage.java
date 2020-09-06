package pages.demoqa;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipsPage extends BaseUtil {
    WebDriverWait wait;

    public ToolTipsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void printTheTextFromTooltipPopup(){
        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        Actions act = new Actions(driver);
        act.moveToElement(toolTipButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tooltip-inner']")));
        WebElement tooltipPopup = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        String text = tooltipPopup.getText();
        System.out.println(text);
    }
}
