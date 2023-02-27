package doxzillaTest;

import doxzillaPages.AccountSettingPage;
import doxzillaPages.LoginPage;
import doxzillaPages.OnboardingPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestData;

public class AccountSettingTest extends BaseTest {
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
        ac.AccSettingButton();
        ac.YourDetailsButton();
        Thread.sleep(1000);
        ac.Name().sendKeys("MyTestUser");

    }

    /*
        @Test(priority = 1, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Validation of Change Password")
        public void ChangePassTest(String user, String pass) throws InterruptedException {
            OnboardingPage on = new OnboardingPage(driver);
            on.clickSignIn();
            LoginPage log = new LoginPage(driver);
            log.loginCredentials(user, pass);
            AccountSettingPage ac = new AccountSettingPage(driver);
            Thread.sleep(3000);
            ac.UserIMG();
            Thread.sleep(1000);
            ac.AccSettingButton();
            ac.EditPassButton();
            ac.ChangePass();
            ac.logout();
            //Login with new pass and change pass again.
            LoginPage log1 = new LoginPage(driver);
            AccountSettingPage ac1 = new AccountSettingPage(driver);
            Thread.sleep(2000);
            on.clickSignIn();
            log1.loginCredentials(user, "NewPass@123");
            Thread.sleep(5000);
            ac1.UserIMG();
            Thread.sleep(1000);
            ac1.AccSettingButton();
            ac1.EditPassButton();
            ac1.ChangePass1();
            ac1.logout();
        }

        @Test(priority = 2, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Verifying Order History of Purchases.")
        public void OrderHistoryTest(String user, String pass) throws InterruptedException {
            new OnboardingPage(driver).clickSignIn();
            LoginPage log = new LoginPage(driver);
            log.loginCredentials(user, pass);
            AccountSettingPage ac = new AccountSettingPage(driver);
            ac.UserIMG();
            Thread.sleep(1000);
            ac.AccSettingButton();
            Thread.sleep(3000);
            ac.verifyOrderHistory();
            ac.logout();
        }

        @Test(priority = 3, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Cancelling Subscription Plan")
        public void ManageSubscriptionTest(String user, String pass) throws InterruptedException {
            new OnboardingPage(driver).clickSignIn();
            LoginPage log = new LoginPage(driver);
            log.loginCredentials(user, pass);
            Thread.sleep(1000);
            AccountSettingPage ac = new AccountSettingPage(driver);
            ac.UserIMG();
            Thread.sleep(2000);
            ac.AccSettingButton();
            Thread.sleep(2000);
            ac.ManageSubButton();
        }

        @Test(priority = 4, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Validation of Delete Account")
        public void DeleteAccountTest(String user, String pass) throws InterruptedException {
            new OnboardingPage(driver).clickSignIn();
            LoginPage log = new LoginPage(driver);
            log.loginCredentials(user, pass);
            Thread.sleep(1000);
            AccountSettingPage ac = new AccountSettingPage(driver);
            ac.UserIMG();
            Thread.sleep(2000);
            ac.AccSettingButton();
            Thread.sleep(1000);
            ac.DelAccButton();
            Thread.sleep(2000);
            ac.logout();
        }*/
    @Test(priority = 5, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Validation of  Order History")
    public void DeleteAccountTest(String user, String pass) throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage log = new LoginPage(driver);
        log.loginCredentials(user, pass);
        Thread.sleep(1000);
        AccountSettingPage ac = new AccountSettingPage(driver);
        ac.UserIMG();
        Thread.sleep(2000);
        ac.AccSettingButton();
        Thread.sleep(1000);
        ac.ChangeVideoQuality();

    }

    //Adding Test Cases
    @Test(priority = 6, dataProvider = "loginCredential", groups = {"Sanity", "Regression"}, description = "Validation of  Content Prefrence")
    public void ContPref(String user, String pass) throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage log = new LoginPage(driver);
        log.loginCredentials(user, pass);
        Thread.sleep(1000);
        AccountSettingPage ac = new AccountSettingPage(driver);
        ac.UserIMG();
        Thread.sleep(2000);
        ac.AccSettingButton();
        Thread.sleep(1000);
        ac.ChangeContPref();
        ac.logout();

    }
}