package doxzillaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class RetrieveOTP {

    final String parentAddress = "sourabh123qa@gmail.com";
    WebDriverWait wait;
    WebDriver driver;

    public RetrieveOTP(WebDriver driver) {
        super();
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public String getTrackingCodeFromMail(WebDriver driver) {
        String code = null;
        /////////make code to retrive tracking code.
        return code;
    }

    public String getConfirmationCodeFromGmail(WebDriver driver) {
        String code = null;
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.navigate().to("https://accounts.google.com/AccountChooser/signinchooser?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser");
            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
            email.sendKeys(parentAddress);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).sendKeys("MyTest@123");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))).click();
            Thread.sleep(10000);
            code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'The one-time password')]"))).getText();
            code = code.split("Doxzilla is : ")[1];
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            e.getMessage();
        }
        return code;
    }

    public void getConfimrationForSignUp(WebDriver driver, String code) {
        wait = new WebDriverWait(driver, 60);
        char[] c = code.substring(0, 6).toCharArray();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val1"))).sendKeys(String.valueOf(c[0]));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val2"))).sendKeys(String.valueOf(c[1]));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val3"))).sendKeys(String.valueOf(c[2]));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val4"))).sendKeys(String.valueOf(c[3]));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val5"))).sendKeys(String.valueOf(c[4]));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-val6"))).sendKeys(String.valueOf(c[5]));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm']"))).click();
    }
}