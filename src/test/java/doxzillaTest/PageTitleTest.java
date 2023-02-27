package doxzillaTest;

import doxzillaPages.ForgotPassPage;
import doxzillaPages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTitleTest extends BaseTest {
    @Test(groups = "Smoke", description = "Verification of Page Title and Url of Onboarding Page")
    public void OnboardingPageUrlTest() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Doxzilla.com - Know The Unknown");
        if (driver.getCurrentUrl().contains("th")) {
            Assert.assertFalse(driver.getCurrentUrl().contains("th/welcome"));
        } else {
            String msg = driver.getCurrentUrl();
            Assert.assertTrue(driver.getCurrentUrl().contains("en/welcome"));
        }
    }

    @Test(groups = "Smoke", description = "Availability of Doxzilla Logo on Onboarding Page")
    public void OnboardingPageLogoTest() {
        boolean logo1 = new OnboardingPage(driver).DoxzillaLogo();
        Assert.assertTrue(logo1);
        boolean logo2 = new OnboardingPage(driver).DoxzillaLogo1();
        Assert.assertTrue(logo2);
    }

    @Test(groups = "Smoke", description = "Validation of Login Page Title and URL of the Page.")
    public void LoginPageUrlTest() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Doxzilla.com - Know The Unknown");
        if (driver.getCurrentUrl().contains("th")) {
            Assert.assertFalse(driver.getCurrentUrl().contains("th/signin"));
        } else {
            String msg = driver.getCurrentUrl();
            Assert.assertFalse(driver.getCurrentUrl().contains("en/signin"));
        }
    }

    @Test(groups = "Smoke", description = "Verification of Forgot Password Page URL")
    public void ForgotPassPageTitleTest() {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        if (driver.getCurrentUrl().contains("th")) {
            Assert.assertFalse(driver.getCurrentUrl().contains("th/forgot-request"));
        } else {
            String msg = driver.getCurrentUrl();
            Assert.assertTrue(driver.getCurrentUrl().contains("en/forgot-request"));
        }
    }

    @Test(groups = "Smoke", description = "Availability of Doxzilla Logo on Forgot Password Page.")
    public void ForgotPassPageLogoTest() {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        boolean logo = fpage.doxzillaLogo();
        Assert.assertTrue(logo);
    }
}