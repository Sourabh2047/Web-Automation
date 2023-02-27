package vipaPages;

import browser.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyList extends BasePage {

    WebDriverWait wait;
    @FindBy(xpath = "//div[text()=' New Releases ']")
    private WebElement new_release;

    @FindBy(xpath = "(//div[@class='slide slick-slide slick-active slick-expand'])[1]")
    private WebElement expand;

    @FindBy(xpath = "(//div[@class='slide slick-slide slick-active slick-expand'])[2]")
    private WebElement expand1;

    @FindBy(xpath = "(//div[@class='slide slick-slide slick-active slick-expand'])[3]")
    private WebElement expand2;

    @FindBy(xpath = "//span[@class='addtolist']")
    private WebElement addToList;

    @FindBy(xpath = "(//img[@class='logo'])[1]")
    private WebElement logo;
    @FindBy(css = "input#search-input-control")
    private WebElement search;

    public MyList(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void addToMyList(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(new_release));
        WebDriverManager.scrollToElement(new_release);
        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToList)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
        wait.until(ExpectedConditions.visibilityOf(new_release));
        WebDriverManager.scrollToElement(new_release);
    }

    public void callAddToMyList() {
        addToMyList(expand);
        addToMyList(expand1);
        addToMyList(expand2);
        wait.until(ExpectedConditions.elementToBeClickable(search)).click();
        search.clear();
        search.sendKeys("World Weirdest Animal Faces");
        search.sendKeys(Keys.RETURN);
    }
}
