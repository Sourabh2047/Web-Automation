package vipaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettingPage extends BasePage {

    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='userimg-pic']")
    private WebElement UserIMG;
    @FindBy(xpath = "(//span[text()='Account & Settings'])[2]")
    private WebElement AccSettingButton;
    @FindBy(xpath = "(//button[@class='btn-pink'])[1]")
    private WebElement profileEditButton;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement name;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement phone;
    @FindBy(xpath = "//select[@id='gender']")
    private WebElement gender;
    @FindBy(xpath = "value=MALE")
    private WebElement selectMale;
    @FindBy(xpath = "//input[@id='dob']")
    private WebElement calander;


    @FindBy(xpath = "(//button[@class='btn-pink'])[4]")
    private WebElement saveProfile;


    @FindBy(xpath = "(//button[@class='btn-pink'])[3]")
    private WebElement editPassButton;
    @FindBy(xpath = "(//input[@placeholder='New Password'])[2]")
    private WebElement NewPass;
    @FindBy(xpath = "(//input[@placeholder='Confirm Password'])[2]")
    private WebElement CnfPass;
    @FindBy(xpath = "(//button[@class='btn-pink'])[4]")
    private WebElement savePass;

    @FindBy(xpath = "//button[@class='btn-pink orderHistory']")
    private WebElement OrderHistoryButton;
    @FindBy(xpath = "//span[@class='setting-inner-icon']/i")
    private WebElement BackToAccSetting;

    @FindBy(xpath = "(//button[@class='btn-pink'])[5]")
    private WebElement ManageSubButton;

    @FindBy(xpath = "//button[@id='logoutUser']")
    private WebElement LogoutButton;

    @FindBy(xpath = "//span[text()='delete_outline']")
    private WebElement DelButton;
    @FindBy(xpath = "//button[@class='btn btn-pink back-btn']")
    private WebElement Del;
    @FindBy(xpath = "//button[@class='btn btn-pink cancel-btn']")
    private WebElement DelCancel;

    public AccountSettingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void UserIMG() {
        wait.until(ExpectedConditions.elementToBeClickable(UserIMG)).click();
    }

    public void AccSettingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AccSettingButton)).click();
    }

    public void YourDetailsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileEditButton)).click();
    }

    public WebElement Name() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name;
    }

    public void EditPassButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editPassButton)).click();
    }

    public void ChangePass() {
        wait.until(ExpectedConditions.visibilityOf(NewPass));
        NewPass.sendKeys("1234567");
        wait.until(ExpectedConditions.visibilityOf(CnfPass));
        CnfPass.sendKeys("1234567");
        wait.until(ExpectedConditions.elementToBeClickable(savePass)).click();
    }

    public void OrderHistoryButton() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(OrderHistoryButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ACTIVE']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("BackToAccSetting"))).click();
    }

    public void ManageSubButton() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(ManageSubButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
    }

    public void logout() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(LogoutButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
    }

    public void genLogout() {
        UserIMG();
        AccSettingButton();
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(LogoutButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
    }

    public void DelAccButton() {
        Actions a = new Actions(driver);
        WebElement DelB = wait.until(ExpectedConditions.visibilityOf(DelButton));
        a.moveToElement(DelB);
        a.click(DelB);
        a.build().perform();
        //wait.until(ExpectedConditions.elementToBeClickable(DelCancel)).click();
        Actions a1 = new Actions(driver);
        WebElement del = wait.until(ExpectedConditions.visibilityOf(Del));
        a1.moveToElement(del);
        a1.click(del);
        a1.build().perform();
        ;
    }
}