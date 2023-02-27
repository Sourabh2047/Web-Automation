package doxzillaTest;

import doxzillaPages.AccountSettingPage;
import doxzillaPages.AccountTrackingPage;
import doxzillaPages.LoginPage;
import doxzillaPages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestData;

public class AccountTrackingTest extends BaseTest {

    @Test(groups = "Smoke", description = "Validation of Forgot Password Page URL")
    public void TrackingPageTitleTest() {
        getURL(TestData.getDataValue("TrackingUrl", System.getProperty("env")));
        String Url = driver.getCurrentUrl();
        if (Url.contains("UAT")) {
            Assert.assertTrue(Url.contains("web-uat.doxzilla.com/en/track-account-deletion-request"));
        } else if (Url.contains("QA")) {
            Assert.assertTrue(Url.contains("web-qa.doxzilla.enveu.com/en/track-account-deletion-request"));
        } else if (Url.contains("PROD")) {
            Assert.assertTrue(Url.contains("https://app.doxzilla.com/en/track-account-deletion-request"));
        }
    }

    @Test(groups = {"Sanity", "Regression"}, description = "Validation of Tracking ID Field with invalid Inputs")
    public void InvalidTrackingIDTest() {
        getURL(TestData.getDataValue("TrackingUrl", System.getProperty("env")));
        AccountTrackingPage track = new AccountTrackingPage(driver);
        track.TrackingBox().sendKeys("40e881ce5a90-4b47-97aa101116c030fd");
        track.TrackButton();
        String heading = track.getTrackingMessage();
        Assert.assertEquals(heading, "No such request available for this tracking id");
    }

    @Test(groups = {"Sanity", "Regression"}, description = "Validation of Email Field with Valid Inputs")
    public void ValidTrackingIDTest1() throws InterruptedException {
        getURL(TestData.getDataValue("TrackingUrl", System.getProperty("env")));
        AccountTrackingPage track = new AccountTrackingPage(driver);
        track.TrackingBox().sendKeys("40e881ce-5a90-4b47-97aa-101116c030fd");
        track.TrackButton();
        String heading = track.getTrackingMessage();
        Assert.assertEquals(heading, "Delete Account Request Status : Rejected");
    }

    @Test(groups = {"Sanity", "Regression"}, description = "Validation of Email Field with Valid Inputs")
    public void ValidTrackingIDTest2() {
        getURL(TestData.getDataValue("TrackingUrl", System.getProperty("env")));
        AccountTrackingPage track = new AccountTrackingPage(driver);
        track.TrackingBox().sendKeys("40e881ce-5a90-4b47-97aa-101116c030fd");
        track.TrackButton();
        String heading = track.getTrackingMessage();
        Assert.assertTrue(heading.contains("Delete Account Request Status : Under Review"));
    }

    @Test(groups = {"Sanity", "Regression"}, description = "Validation of Email Field with Valid Inputs")
    public void ValidTrackingIDTest3() {
        getURL(TestData.getDataValue("TrackingUrl", System.getProperty("env")));
        AccountTrackingPage page = new AccountTrackingPage(driver);
        LoginPage l = new LoginPage(driver);
        OnboardingPage on = new OnboardingPage(driver);
        AccountSettingPage ac = new AccountSettingPage(driver);
        page.TrackingBox().sendKeys("40e881ce-5a90-4b47-97aa-101116c030fd");
        page.TrackButton();
        String heading = page.getTrackingMessage();
        String Status1 = "Delete Account Request Status : Rejected", Status2 = "Delete Account Request Status : Under Review";
        if (Status1.trim().equals(heading.trim()) || Status2.equals(heading)) {
            driver.get("https://enveu-saas:husai5We@web-uat.doxzilla.com/en/");
            on.clickSignIn();
            l.loginCredentials(TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass"));
            ac.UserIMG();
            ac.AccSettingButton();
            ac.logout();
        } else {
            System.out.println("Heading Message Found " + heading);
        }
    }
}