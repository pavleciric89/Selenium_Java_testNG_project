package pages.orangeHRM;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseUtil {
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void clickOnLoginButton(){
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

}
