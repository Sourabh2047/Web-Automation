package doxzillaTest;

import doxzillaPages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {
    @Test(groups = {"Sanity", "Regression"}, description = "Validation of SignIn Button on Onboarding Page.")
    public void ValidationOfSigninButton() throws InterruptedException {
        OnboardingPage obj = new OnboardingPage(driver);
        Thread.sleep(1000);
        obj.clickSignIn();
        if (driver.getCurrentUrl().contains("th")) {
            Assert.assertFalse(driver.getCurrentUrl().contains("th/signup"));
            driver.navigate().back();
        } else {
            Assert.assertFalse(driver.getCurrentUrl().contains("en/signup"));
            driver.navigate().back();
        }
    }

    @Test(groups = {"Sanity", "Regression"}, description = "Validation of All Subscribe Button's on Onboarding Page.")
    public void ValidationOfSubscribeMainButton() throws InterruptedException {
        OnboardingPage obj = new OnboardingPage(driver);
        obj.subscribeMain();
        if (driver.getCurrentUrl().contains("th")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("th/signup"));
            driver.navigate().back();
            Thread.sleep(2000);
            obj.subscribeBottom();
            Assert.assertTrue(driver.getCurrentUrl().contains("th/signup"));
            driver.navigate().back();
            Thread.sleep(2000);
            obj.clickSignIn();
            obj.signUp();
            Assert.assertTrue(driver.getCurrentUrl().contains("th/signup"));
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains("en/signup"));
            driver.navigate().back();
            Thread.sleep(2000);
            obj.subscribeBottom();
            Assert.assertTrue(driver.getCurrentUrl().contains("en/signup"));
            driver.navigate().back();
            Thread.sleep(2000);
            obj.clickSignIn();
            obj.signUp();
            Assert.assertTrue(driver.getCurrentUrl().contains("en/signup"));
        }
    }
/* Create to Check TextBox is taking email id and user is able to signup with that.
    @Test(groups = {"Sanity", "Regression"}, description = "Validation All Subscribe Button's TextBox on Onboarding Page.")
    public void ValidationOfSubscribeBoxSignup() throws InterruptedException {
        OnboardingPage obj = new OnboardingPage(driver);
        obj.subscribeMain();

        obj.subscribeBottomBox();
        obj.subscribeBottom();
        String Url = driver.getCurrentUrl();
        if (Url.contains("th")) {
            Assert.assertTrue(Url.contains("th/signup"));
            String heading = obj.getTopHeading();
            Assert.assertEquals(heading, "สร้างรหัสผ่านเพื่อเริ่มต้นเป็นสมาชิก");
        } else {
            Assert.assertTrue(Url.contains("en/signup"));
            String heading = obj.getTopHeading();
            Assert.assertEquals(heading, "Create a password to start your membership");
        }
        Thread.sleep(2000);
        driver.navigate().back();
    }
    */
}