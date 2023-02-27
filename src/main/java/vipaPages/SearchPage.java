package vipaPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement SearchTextBox;

    @FindBy(css = "//i[@class='material-icons searchicon']")
    private WebElement SearchButton;


    @FindBy(css = "  //div[@class='rail-title col-lg-10']/h2")
    private WebElement pageTitle;

    public SearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }

    public WebElement searchBox() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchTextBox)).click();
        return SearchTextBox;
    }

    public String getSearchPageHeader() {
        String title = wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();
        return title;
    }

    public void popularSearch() {
        Actions ac = new Actions(driver);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(SearchTextBox));
        ac.click(ele);
        ac.sendKeys(Keys.RETURN);
        ac.build().perform();
    }
}