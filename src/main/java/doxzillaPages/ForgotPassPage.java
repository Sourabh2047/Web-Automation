package doxzillaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassPage {

    WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//img[@src='https://cdn-nextstep.enveu.tv/web/images/log-in-logo.png']")
    private WebElement logo;
    @FindBy(xpath = "//span[@class='forgetpass']")
    private WebElement ForgotPassLink;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailBox;
    @FindBy(xpath = "//button[@class='forget-botton']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@id='snackbar']")
    private WebElement snakbarMsg;

    public ForgotPassPage(WebDriver driver) {
        super();
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public boolean doxzillaLogo() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }

    public WebElement emailTextBox() {
        wait.until(ExpectedConditions.elementToBeClickable(emailBox)).click();
        return emailBox;
    }

    public void clickForgotPass() {
        wait.until(ExpectedConditions.elementToBeClickable(ForgotPassLink)).click();
    }

    public void submitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public String getMessage() {
        String msg = wait.until(ExpectedConditions.visibilityOf(snakbarMsg)).getText();
        return msg;
    }
}