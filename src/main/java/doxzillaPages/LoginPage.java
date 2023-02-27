package doxzillaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement EmailTextBox;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement PasswordTextBox;
    @FindBy(xpath = "//button[@class='signin-botton']")
    private WebElement SigninSubmit;
    @FindBy(xpath = "//div[@id='snackbar']")
    private WebElement Snakbar;


    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public void signInSubmit() {

        wait.until(ExpectedConditions.elementToBeClickable(SigninSubmit)).click();
    }

    public void loginCredentials(String username, String password) {
        EmailTextBox.sendKeys(username);
        PasswordTextBox.sendKeys(password);
        signInSubmit();
    }

    //..gyhgvh
    public void EmailTextBox(String username) {
        EmailTextBox.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        PasswordTextBox.sendKeys(pwd);
    }

    public String snakbarMsg() {
        wait.until(ExpectedConditions.visibilityOf(Snakbar));
        String msg = Snakbar.getText();
        return msg;
    }
}