package vipaTest;

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

    @Test(dataProvider = "validLogin", groups = {"Sanity", "Regression"}, description = "In this Test we validate when enter Valid registred username and valid password")
    public void ValidLoginTest(String user, String pass) throws InterruptedException {
        vipaPages.LoginPage lp = new vipaPages.LoginPage(driver);
        lp.skipWelcome();
        Thread.sleep(10000);
        lp.clickSignin();
        Thread.sleep(2000);
        lp.enterEmail(user);
        lp.enterPassword(pass);
        lp.signInSubmit();
        Thread.sleep(1000);
    }
}