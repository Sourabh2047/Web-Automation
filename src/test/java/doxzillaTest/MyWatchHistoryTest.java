package doxzillaTest;

import doxzillaPages.AccountSettingPage;
import doxzillaPages.LoginPage;
import doxzillaPages.OnboardingPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestData;

public class MyWatchHistoryTest extends BaseTest {

    @DataProvider(name = "loginCredential")
    public Object[][] detailsDataProvider() {
        return new Object[][]{{TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass")}};
    }

    @Test(priority = 0, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Validation of MyProfile Edit")
    public void YourDetailsTest(String user, String pass) throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage log = new LoginPage(driver);
        log.loginCredentials(user, pass);
        AccountSettingPage ac = new AccountSettingPage(driver);
        Thread.sleep(3000);
        ac.UserIMG();
        Thread.sleep(1000);
        ac.MyHistory();

    }
}
