package doxzillaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountSettingPage {
    WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//a[@class='userimg-pic']")
    private WebElement UserIMG;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[4]")
    private WebElement AccSettingButton;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    private WebElement MyWatchHistory;
    @FindBy(xpath = "(//button[@class='btn-pink'])[1]")
    private WebElement profileEditButton;
    @FindBy(xpath = "(//input[@class='ng-untouched ng-pristine ng-valid'][@type='text'])[1]")
    private WebElement name;
    @FindBy(xpath = "(//input[@class='ng-untouched ng-pristine ng-valid'])[1]")
    private WebElement phone;
    @FindBy(xpath = "(//button[@class='btn-pink'])[4]")
    private WebElement saveProfile;
    @FindBy(xpath = "(//button[@class='btn-pink'])[3]")
    private WebElement editPassButton;
    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement NewPass;
    @FindBy(xpath = "(//input[@type='password'])[4]")
    private WebElement CnfPass;
    @FindBy(xpath = "(//button[@class='btn-pink'])[4]")
    private WebElement savePass;
    @FindBy(xpath = "//button[@class='btn-pink orderHistory']")
    private WebElement OrderHistoryButton;
    @FindBy(xpath = "(//span[text()='ACTIVE'])[1]")
    private WebElement ActiveStatus;
    @FindBy(xpath = "//span[@class='setting-inner-icon']/i")
    private WebElement BackToAccSetting;
    @FindBy(xpath = "(//button[@class='btn-pink'])[5]")
    private WebElement ManageSubButton;
    @FindBy(xpath = "btn btn-pink back-btn")
    private WebElement cancelSubNo;
    @FindBy(xpath = "btn btn-pink cancel-btn")
    private WebElement cancelSubYes;
    @FindBy(xpath = "//button[@id='logoutUser']")
    private WebElement LogoutButton;
    @FindBy(xpath = "//div[@class='box-righttab delete-righttab']/button")
    private WebElement DelButton;
    @FindBy(xpath = "//button[@class='btn btn-pink back-btn']")
    private WebElement Del;
    @FindBy(xpath = "//button[@class='btn btn-pink cancel-btn']")
    private WebElement DelCancel;
    @FindBy(xpath = "//a[@id='ngb-tab-0']/div")
    private WebElement YourAccount;

    @FindBy(xpath = "//a[@id='ngb-tab-1']/div")
    private WebElement VideoQuality;
    @FindBy(xpath = "//input[@id='f-option-medium']")
    private WebElement MediumQuality;

    @FindBy(xpath = "//a[@id='ngb-tab-2']/div")
    private WebElement ContentPref;

    public AccountSettingPage(WebDriver driver) {
        super();
        wait = new WebDriverWait(driver, 50);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void UserIMG() {
        wait.until(ExpectedConditions.elementToBeClickable(UserIMG)).click();
    }

    public void AccSettingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AccSettingButton)).click();
    }

    public void MyHistory() {
        wait.until(ExpectedConditions.elementToBeClickable((MyWatchHistory))).click();
    }

    public void YourDetailsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileEditButton)).click();
    }

    public WebElement Name() {
        Actions a = new Actions(driver);
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,100)");
        wait.until(ExpectedConditions.elementToBeClickable(phone)).click();
        WebElement name1 = wait.until(ExpectedConditions.visibilityOf(name));
        a.moveToElement(name1);
        a.click(name1);
        a.build().perform();
        return name1;
    }

    public void EditPassButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editPassButton)).click();
    }

    public void ChangePass() {
        wait.until(ExpectedConditions.visibilityOf(NewPass));
        NewPass.sendKeys("NewPass@123");
        wait.until(ExpectedConditions.visibilityOf(CnfPass));
        CnfPass.sendKeys("NewPass@123");
        wait.until(ExpectedConditions.elementToBeClickable(savePass)).click();
    }

    public void ChangePass1() {
        wait.until(ExpectedConditions.visibilityOf(NewPass));
        NewPass.sendKeys("Test@123");
        wait.until(ExpectedConditions.visibilityOf(CnfPass));
        CnfPass.sendKeys("Test@123");
        wait.until(ExpectedConditions.elementToBeClickable(savePass)).click();
    }

    public void verifyOrderHistory() throws InterruptedException {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(OrderHistoryButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
        Thread.sleep(5000);
        String status = wait.until(ExpectedConditions.visibilityOf(ActiveStatus)).getText();
        Assert.assertTrue(status.contains("ACTIVE"));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable((BackToAccSetting))).click();
    }

    public void ManageSubButton() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(ManageSubButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(cancelSubYes));
    }

    public void logout() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(LogoutButton));
        ac.moveToElement(ele);
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,250)");
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

    public void DelAccButton() throws InterruptedException {
        Actions a = new Actions(driver);
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        WebElement DelB = wait.until(ExpectedConditions.elementToBeClickable(DelButton));
        a.moveToElement(DelB);
        a.click();
        a.build().perform();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.elementToBeClickable(DelCancel)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Del)).click();
    }

    public void ChangeVideoQuality() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(VideoQuality)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MediumQuality)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(YourAccount)).click();
    }

    public void ChangeContPref() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ContentPref)).click();
        wait.until(ExpectedConditions.elementToBeClickable(YourAccount)).click();
    }
}