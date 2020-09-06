package tests;

import base.BaseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.orangeHRM.DashboardPage;
import pages.orangeHRM.LoginPage;

public class Test_3 extends BaseUtil {
    @Test
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.clickOnLoginButton();
        dashboardPage.clickOnRecruitmentModule();
        dashboardPage.clickOnCandidatesInRecruitmentModule();
        dashboardPage.switchToIframe();
        dashboardPage.defaultNumberOfCandidatesInTheTable();
        dashboardPage.printOutTheNumberOfCandidates("before changing" ,dashboardPage.defaultNumberOfCandidatesInTheTable());
        dashboardPage.clickOnAddCandidateButton();
        dashboardPage.fillTheCandidateCredentials("QA","Automation", "email@mail.com");
        dashboardPage.numberOfCandidatesInTheTableAfterAddingOne();
        Assert.assertEquals((dashboardPage.defaultNumberOfCandidatesInTheTable()), dashboardPage.numberOfCandidatesInTheTableAfterAddingOne());
        dashboardPage.selectLastAddedCandidate();
        dashboardPage.clickOnThreeDots();
        dashboardPage.clickOndeleteOption();
        dashboardPage.clickOnDeleteButtonToConfirmDeleting();
        dashboardPage.numberOfCandidatesInTheTableAfterDeletingOne();
        Assert.assertEquals(dashboardPage.defaultNumberOfCandidatesInTheTable() , dashboardPage.numberOfCandidatesInTheTableAfterDeletingOne());
        dashboardPage.logout();


    }

}
