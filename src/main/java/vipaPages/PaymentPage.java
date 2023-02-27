package vipaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//input[@name='cardNumber']")
    private WebElement cardTextBox;

    @FindBy(xpath = "//input[@name='expyear']")
    private WebElement cardExpiry;

    @FindBy(xpath = "//input[@name='cvv']")
    private WebElement cardCVV;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement cardName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//input[@name='otp']")
    private WebElement OTP;

    @FindBy(xpath = "//input[@name='continue']")
    private WebElement continueButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }
}