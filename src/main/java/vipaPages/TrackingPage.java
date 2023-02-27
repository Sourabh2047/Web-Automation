package vipaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackingPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//input[@name='trackid']")
    private WebElement TrackingTextBox;

    @FindBy(xpath = "//button[@class='btn-track']")
    private WebElement TrackingButton;

    @FindBy(xpath = "//div[@class='account-tracking']/h3")
    private WebElement message;

    public TrackingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }

    public WebElement TrackingBox() {
        wait.until(ExpectedConditions.elementToBeClickable(TrackingTextBox)).click();
        return TrackingTextBox;
    }

    public void TrackButton() {
        TrackingButton.click();
    }

    public String getTrackingMessage() {

        return wait.until(ExpectedConditions.visibilityOf(message)).getText();
    }
}