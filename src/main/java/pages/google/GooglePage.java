package pages.google;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GooglePage extends BaseUtil {
    WebDriverWait wait;
    public GooglePage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void enterDemoQaInSearchInputAndPressEnter(){
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("demoqa.com");
        searchInput.sendKeys(Keys.RETURN);
    }
    public void clickOnDemoQaFirstLink(){
        By FirstLinkInSearch = By.xpath("//h3[contains(text(),'Demo QA')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(FirstLinkInSearch)).click();

    }
    public void compareResults(String enterWhatToSearch, long expectedNumberOfFoundResults){
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(enterWhatToSearch);
        searchInput.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String statisticMessage = driver.findElement(By.id("result-stats")).getText();
        String numberOnlyFromTheMessage= statisticMessage.replaceAll("[^0-9]", "");
        System.out.println(numberOnlyFromTheMessage);
        long actualResult = Long.parseLong(numberOnlyFromTheMessage);
        Assert.assertEquals(actualResult,expectedNumberOfFoundResults,"There is too much cheese on the internet");
    }

}
