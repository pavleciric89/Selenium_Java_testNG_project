package pages.demoqa;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseUtil {


    WebDriverWait wait;
    public MainPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }
    //    WebElement InteractionsCard = driver.findElement(By.xpath("//div[@class='card mt-4 top-card' and contains(.//h5,'Interactions')]"));
//    WebElement InteractionsCard = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards > div.card.mt-4.top-card:nth-child(5)"));



    public void clickOnInteractionsCard(){
        WebElement InteractionsCard = driver.findElement(By.xpath("//div[@class='card mt-4 top-card' and contains(.//h5,'Interactions')]"));
        InteractionsCard.click();
    }

}
