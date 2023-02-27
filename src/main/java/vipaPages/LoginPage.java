package vipaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class='btn btn-pink singin-btn']")
    private WebElement skipBanner;
    @FindBy(xpath = "//button[@class='btn btn-pink singin-btn']")
    private WebElement signinButton;
    @FindBy(xpath = "(//input[@name='email'])[1]")
    private WebElement emailTextBox;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "(//button[@class='btn-gradient-bg'])[1]")
    private WebElement signinSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }

    public void skipWelcome() {
        //wait.until(ExpectedConditions.elementToBeClickable(.....)).click();
    }

    public void clickSignin() {
        wait.until(ExpectedConditions.elementToBeClickable(signinButton)).click();
    }

    public void enterEmail(String username) {
        emailTextBox.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        passwordTextBox.sendKeys(pwd);
    }

    public void signInSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(signinSubmit)).click();
    }

    public void loginCredentials(String username, String password) {
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        signInSubmit();
    }
}