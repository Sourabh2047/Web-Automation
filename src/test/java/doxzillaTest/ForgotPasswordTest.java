package doxzillaTest;

import doxzillaPages.ForgotPassPage;
import doxzillaPages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestData;

public class ForgotPasswordTest extends BaseTest {
    @DataProvider(name = "validLogin")
    public Object[][] getValidCredentials() {
        return new Object[][]{{TestData.getDataValue("Login", "Email")}};
    }

    @Test(priority = 0, groups = {"Sanity", "Regression"}, description = "Validation of Email Field with Blank Input")
    public void BlankEmailTest() {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        fpage.emailTextBox().sendKeys("");
        fpage.submitButton();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "โปรดระบุอีเมล");
        } else {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "Please enter Email");
        }
    }

    @Test(priority = 1, groups = {"Sanity", "Regression"}, description = "Validation of Email Field with invalid Inputs")
    public void InvalidEmailTest() {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        fpage.emailTextBox().sendKeys("so@me@yopmail.com");
        fpage.submitButton();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "อีเมลไม่ถูกต้อง");
        } else {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "Invalid Email");
        }
    }

    @Test(priority = 2, groups = {"Sanity", "Regression"}, description = "Validation of Forgot Password Page, Email Field with Valid Inputs")
    public void UnregisteredEmailTest() {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        fpage.emailTextBox().sendKeys("someone@gmail.com");
        fpage.submitButton();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "ระบบจะส่งข้อความไปยังอีเมล์ของท่านเพื่อทำการยืนยันตัวตน กรุณาตั้งค่ารหัสผ่านใหม่เพื่อเข้าสู่ระบบอีกครั้ง ข้อความที่ตอบกลับไปอาจจะอยู่ในแฟ้มจดหมาย Spam หรือ Junk ได้ กรุณาตรวจสอบในแฟ้มดังกล่าว");
        } else {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "Thanks for putting the request. If we find the email address in our system, we will send the reset link over the mail");
        }
    }

    @Test(priority = 3, dataProvider = "validLogin", groups = {"Sanity", "Regression"}, description = "Validation of Forgot Password TextBox with Valid Registered, Email.")
    public void RegisteredEmailTest(String user) {
        OnboardingPage on = new OnboardingPage(driver);
        on.clickSignIn();
        ForgotPassPage fpage = new ForgotPassPage(driver);
        fpage.clickForgotPass();
        fpage.emailTextBox().sendKeys(user);
        fpage.submitButton();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "ระบบจะส่งข้อความไปยังอีเมล์ของท่านเพื่อทำการยืนยันตัวตน กรุณาตั้งค่ารหัสผ่านใหม่เพื่อเข้าสู่ระบบอีกครั้ง ข้อความที่ตอบกลับไปอาจจะอยู่ในแฟ้มจดหมาย Spam หรือ Junk ได้ กรุณาตรวจสอบในแฟ้มดังกล่าว");
        } else {
            String msg = fpage.getMessage();
            Assert.assertEquals(msg, "Thanks for putting the request. If we find the email address in our system, we will send the reset link over the mail");
        }
    }
}