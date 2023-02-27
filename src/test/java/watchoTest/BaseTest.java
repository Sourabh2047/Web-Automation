package watchoTest;

import browser.WebDriverManager;
import listeners.LogListener;
import listeners.ReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import util.LoggerUtil;
import util.MailUtil;
import util.TestData;
import util.TestProperties;

import java.util.concurrent.TimeUnit;

@Listeners({ReportListener.class, LogListener.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        LoggerUtil.log("************************** Watcho Test Execution Started ************************************");
        TestProperties.loadAllPropertie();
        TestData.getJsonNode();
    }

    public void getURL(String url) {
        driver.get(url);
    }

    @BeforeMethod
    @Parameters({"browser", "env"})
    protected void setup(@Optional("chrome") String browser, @Optional("env") String env) {
        if (browser.equalsIgnoreCase("Firefox")) {
            io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("Chrome")) {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("disable-infobars");
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("IE")) {
            io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
            System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("Opera")) {
            io.github.bonigarcia.wdm.WebDriverManager.operadriver().setup();
            System.setProperty("webdriver.opera.driver", " C:\\operadriver.exe");
            driver = new OperaDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverManager.setDriver(driver);
        } else if (browser.equalsIgnoreCase("Safari")) {
            SafariOptions options = new SafariOptions();
            driver = new SafariDriver(options);
            driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverManager.setDriver(driver);
        } else {
            System.out.println("No Browser pass, Using Chrome Browser as default");
        }
        if (System.getProperty("env") != null) {
            env = System.getProperty("env");
        }
        getURL(TestData.getDataValue("WatchoBaseUrl", env));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void wrapAllUp(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        LoggerUtil.log("Total number of testcases : " + total);
        LoggerUtil.log("Number of testcases Passed : " + passed);
        LoggerUtil.log("Number of testcases Failed : " + failed);
        LoggerUtil.log("Number of testcases Skipped  : " + skipped);
        boolean mailSent = MailUtil.sendMail(total, passed, failed, skipped);
        LoggerUtil.log("Mail sent : " + mailSent);
        LoggerUtil.log("************************** Watcho Test Execution Finished ************************************");
    }
}