package pages.orangeHRM;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage extends BaseUtil {
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void clickOnRecruitmentModule() {
        WebElement recruitment = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        recruitment.click();
    }

    public void clickOnCandidatesInRecruitmentModule() {
        WebElement candidates = driver.findElement(By.id("menu_recruitment_viewCandidates"));
        wait.until(ExpectedConditions.visibilityOf(candidates));
        candidates.click();
    }

    public void switchToIframe() {
        driver.switchTo().frame("noncoreIframe");
    }

    public int defaultNumberOfCandidatesInTheTable() {
        List<WebElement> candidates = driver.findElements(By.xpath("//tr[@class='dataDefaultRaw dataRaw handCuser']"));
        int numberOfCandidates = candidates.size();
        return numberOfCandidates;
    }

    public void printOutTheNumberOfCandidates(String momentOfCounting,int n){
        System.out.println("The number of candidates in the list" +momentOfCounting+ " is: " + n);
    }

    public void clickOnAddCandidateButton() {
        WebElement addButton = driver.findElement(By.id("list_item_add"));
        addButton.click();
    }

    public void fillTheCandidateCredentials(String name, String lastName, String eMail) throws InterruptedException {

        //fulfilling credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalAddCandidate")));
        WebElement nameEl = driver.findElement(By.id("addCandidate_firstName"));
        WebElement lastNameEl = driver.findElement(By.id("addCandidate_lastName"));
        WebElement eMailEl = driver.findElement(By.id("addCandidate_email"));
        nameEl.sendKeys(name);
        lastNameEl.sendKeys(lastName);
        eMailEl.sendKeys(eMail);

        //select vacancy
        WebElement vacancyTextArea = driver.findElement(By.id("textarea_addCandidate_vacancy"));
        vacancyTextArea.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(" li.searchSingleObjectLi.not-selected:nth-child(1) a.searchObjectA > p.search-row.searchListObjectName")));

        //select current date
        WebElement selectDate = driver.findElement(By.id("applied_date"));
        selectDate.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='applied_date_root']//button[@class='btn-flat picker__today pickadate--weekend'][contains(text(),'Today')]")));

        //add resume in the form
        WebElement addResumeInput = driver.findElement(By.id("addCandidate_resume"));
        String resumeFileAddress = System.getProperty("user.dir") + "/resume.doc";
        addResumeInput.sendKeys(resumeFileAddress);

        //save fulfilled form
        WebElement saveButton = driver.findElement(By.id("saveCandidateButton"));
        saveButton.click();
    }

    public int numberOfCandidatesInTheTableAfterAddingOne(){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("modalAddCandidate"))));
        List<WebElement> candidates1 = driver.findElements(By.xpath("//tr[@class='dataDefaultRaw dataRaw handCuser']"));
        int numberOfCandidatesAfteradding = candidates1.size();
        return numberOfCandidatesAfteradding;
    }


    public void selectLastAddedCandidate() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr[1]//td[1]//input[1]")));
    }
    public void clickOnThreeDots(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("ohrmList_Menu")));
    }
    public void clickOndeleteOption(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("deleteItemBtn")));
    }
    public void clickOnDeleteButtonToConfirmDeleting(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-delete-candidate")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("candidate-delete-button")));
    }
    public int numberOfCandidatesInTheTableAfterDeletingOne(){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("modal-delete-candidate"))));
        List<WebElement> candidates2 = driver.findElements(By.xpath("//tr[@class='dataDefaultRaw dataRaw handCuser']"));
        int numberOfCandidatesAfterDeleting = candidates2.size();
        return numberOfCandidatesAfterDeleting;
    }
    public void logout(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-dropdown"))));
        WebElement userIcon = driver.findElement(By.id("user-dropdown"));
        userIcon.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logoutLink"))));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("logoutLink")));
    }


}
