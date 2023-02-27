package doxzillaTest;

import doxzillaPages.AccountSettingPage;
import doxzillaPages.LoginPage;
import doxzillaPages.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestData;

public class LoginTest extends BaseTest {
    @DataProvider(name = "validLogin")
    public Object[][] getValidCredentials() {
        return new Object[][]{{TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass")}};
    }

    @DataProvider(name = "validLogin1")
    public Object[][] getValidCredentials1() {
        return new Object[][]{{TestData.getDataValue("Login1", "Email"), TestData.getDataValue("Login1", "Pass")}};
    }

    @DataProvider(name = "invalidLogin")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{{"j4@yopmal.com", "13621311"}};
    }

    @Test(dataProvider = "invalidLogin", groups = {"Sanity"}, description = "Validation of Login when username is blank.")
    public void InvalidLoginTest1(String user, String pass) {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.EmailTextBox("");
        loginPageObj.signInSubmit();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "โปรดระบุอีเมล");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Please enter Email");
        }
    }

    @Test(groups = {"Sanity"}, description = "Validation of Login when enter invalid username.")
    public void InvalidLoginTest2() {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.EmailTextBox("user&hh@kk@kk.com");
        loginPageObj.enterPassword("123123123");
        loginPageObj.signInSubmit();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "อีเมลไม่ถูกต้อง");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Invalid Email");
        }
    }


    @Test(dataProvider = "invalidLogin", groups = {"Sanity"}, description = "Validation of Login when enter valid username and less than 6 digit password.")
    public void InvalidLoginTest4(String user, String pass) {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.EmailTextBox(user);
        loginPageObj.enterPassword("123");
        loginPageObj.signInSubmit();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "โปรดใส่รหัสผ่าน 6 ถึง 20 ตัวอักษร");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Please enter a password between 6 to 20 characters");
        }
    }

    @Test(dataProvider = "invalidLogin", groups = {"Sanity"}, description = "Validation of Login when enter valid username and password is blank.")
    public void InvalidLoginTest3(String user, String pass) {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.EmailTextBox(user);
        loginPageObj.signInSubmit();
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "กรุณาใส่รหัสผ่าน");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Please enter Password");
        }
    }

    @Test(groups = {"Sanity"}, description = "Validation of Login when enter unregistred username and valid password")
    public void InvalidLoginTest5() {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.loginCredentials("sourabh@gmail.com", "password");
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "ชื่อผู้ใช้หรือรหัสผ่านไม่ตรงกัน");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Username or Password doesn't match.");
        }
    }

    @Test(dataProvider = "invalidLogin", groups = {"Sanity"}, description = "Validation of Login when enter valid registred username and wrong password")
    public void InvalidLoginTest6(String user, String pass) {
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.loginCredentials(user, pass);
        if (driver.getCurrentUrl().contains("th")) {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "ชื่อผู้ใช้หรือรหัสผ่านไม่ตรงกัน");
        } else {
            String msg = loginPageObj.snakbarMsg();
            Assert.assertEquals(msg, "Username or Password doesn't match.");
        }
    }

    @Test(dataProvider = "validLogin", groups = {"Sanity", "Regression"}, description = "In this Test we validate when enter Valid registred username and valid password")
    public void ValidLoginTest(String user, String pass) throws InterruptedException {
        AccountSettingPage ac = new AccountSettingPage(driver);
        OnboardingPage On = new OnboardingPage(driver);
        LoginPage loginPageObj = new LoginPage(driver);
        On.clickSignIn();
        loginPageObj.loginCredentials(user, pass);
        Thread.sleep(3000);
        ac.UserIMG();
        ac.AccSettingButton();
        ac.logout();
        Thread.sleep(1000);
    }
}