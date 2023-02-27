package doxzillaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OnboardingPage {
    WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//img[@src='https://d3uz5dkbsevwkn.cloudfront.net/filters:format(webp):quality(60)/https://cdn-nextstep.enveu.tv/web/images/welcome-screen/welcome-logo.png']")
    private WebElement TopLogo;
    @FindBy(xpath = "//img[@src='https://d3uz5dkbsevwkn.cloudfront.net/filters:format(webp):quality(60)/https://cdn-nextstep.enveu.tv/web/images/newonbording-logo.png']")
    private WebElement MainLogo;
    @FindBy(xpath = "(//button[@class='btn btn-success'])[1]")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class='signup']")
    private WebElement signUpButton;
    @FindBy(xpath = "(//button[@class='faq-button'])[1]")
    private WebElement subscribeMain;
    @FindBy(xpath = "(//button[@class='faq-button'])[2]")
    private WebElement subscribeBottom;
    @FindBy(xpath = "//div[@class='signuptop']/h2")
    private WebElement signUpTopHeading;
    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement signUpTextBox;

    public OnboardingPage(WebDriver driver) {
        super();
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public boolean DoxzillaLogo() {
        return TopLogo.isDisplayed();
    }

    public boolean DoxzillaLogo1() {

        return MainLogo.isDisplayed();
    }

    public void clickSignIn() {
        Actions ac = new Actions(driver);
        Assert.assertTrue(signInButton.isDisplayed());
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        ac.moveToElement(ele);
        ac.click(ele);
        ac.build().perform();
    }

    public void signUp() {
        Assert.assertTrue(signUpButton.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void subscribeMain() {

        wait.until(ExpectedConditions.elementToBeClickable(subscribeMain)).click();
    }

    public void subscribeBottom() {
        Actions ac = new Actions(driver);
        try {
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(subscribeBottom));
            ac.moveToElement(ele);
            ac.click(ele);
            ac.build().perform();
        } catch (Exception e) {

        }
    }

    public void subscribeBottomBox() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpTextBox)).sendKeys("mymail@yopmail.com");
    }

    public String getTopHeading() {
        return signUpTopHeading.getText();
    }
}