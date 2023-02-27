package vipaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DataGenerator;

public class SignupPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//h2[text()[normalize-space()='Create a password to start your membership']]")
    private WebElement SignupTitle;
    @FindBy(xpath = "//div[@id='snackbar']")
    private WebElement snakbarMsg;
    @FindBy(xpath = "//input[@name='Email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@name='Password']")
    private WebElement enterPass;
    @FindBy(xpath = "//input[@name='Confirm password']")
    private WebElement enterCnfPass;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox1;
    @FindBy(xpath = "//button[@class='btn-box-continue']")
    private WebElement page1ContinueButton;
    @FindBy(id = "otp-number-input-2")
    private WebElement enterOTPBox;
    @FindBy(xpath = "//button[@class='otp-box-continue']")
    private WebElement page2ContinueButton;
    @FindBy(xpath = "signout-btn")
    private WebElement logout;
    @FindBy(xpath = "//button[contains(.,'Monthly service fee 99 per month')]")
    private WebElement selectMontlyPackage;
    @FindBy(xpath = "//button[contains(.,'Annual service fee 999 per year')]")
    private WebElement selectAnnualPackage;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox2;
    @FindBy(xpath = "//button[@class='btn-box-continue']")
    private WebElement page3ContinueButton;
    @FindBy(xpath = "(//a[@class='privacytext'])[2]")
    private WebElement privacyLink;
    @FindBy(xpath = "(//a[@class='privacytext'])[1]")
    private WebElement tncLink;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox3;
    @FindBy(xpath = "//button[@class='btn-box-coupon-continue']")
    private WebElement page4ContinueButton;
    @FindBy(xpath = "//span[@class='resend-otp-p']")
    private WebElement resendOTPButton;

    public SignupPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }

    public String signupPageTitle() {
        String Text = SignupTitle.getText();
        return Text;
    }

    public String snakbarMessage() {
        String msg = snakbarMsg.getText();
        return msg;
    }

    public void emailTextBox(String email) {
        enterEmail.sendKeys(email);
    }

    public void passTextBox(String password) {
        enterPass.sendKeys(password);
    }

    public void cnfPassTextBox(String cnfpass) {
        enterCnfPass.sendKeys(cnfpass);
    }

    public void signupCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1)).click();
    }

    public void clickSignupContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(page1ContinueButton)).click();
    }

    public void enterOTP(String otp) {
        wait.until(ExpectedConditions.visibilityOf(enterOTPBox));
        enterOTPBox.sendKeys(otp);
    }

    public void resendOTPButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resendOTPButton)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }

    public void clickOTPContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(page2ContinueButton)).click();
    }

    public void selectMonthly() {
        selectMontlyPackage.click();
    }

    public void selectYearly() {
        selectAnnualPackage.click();
    }

    public void openPrivacyPage() {
        privacyLink.click();
        driver.close();
    }

    public void openTnCPage() {
        tncLink.click();
        driver.close();
    }

    public void packageCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkbox2)).click();
    }

    public void packageContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(page3ContinueButton)).click();
    }

    public void paymentCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkbox3)).click();
    }

    public void paymentContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(page4ContinueButton)).click();
    }

    public void SignupMail() {
        DataGenerator data = new DataGenerator();
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-form-email")));
        String address = "abc123kedar+" + DataGenerator.getAlphaNumericString(4) + "@gmail.com";
        email.sendKeys(address);
    }
}