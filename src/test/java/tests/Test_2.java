package tests;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.google.GooglePage;

public class Test_2 extends BaseUtil {
    @Test
    public void test() {
        GooglePage googlePage = new GooglePage(driver);
googlePage.compareResults("cheese",777);
    }
}
