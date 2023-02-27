package browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverManager {
    private static final InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverinstance.get() == null) {
            throw new IllegalStateException("WebDriver has not been set, Please set WebDriver instance by WebDriverManager.setDriver...");
        } else {
            return driverinstance.get();
        }
    }

    public static void setDriver(WebDriver driver) {
        driverinstance.set(driver);
    }

    public static void removeDriver() {
        driverinstance.remove();
    }

    public static void scrollToElement(WebElement script) {
        JavascriptExecutor je = (JavascriptExecutor) driverinstance;
        je.executeScript("arguments[0].scrollIntoView(true);", script);
    }

    public static void executeJS(String command, WebElement ele) {
        scrollToElement(ele);
        JavascriptExecutor je = (JavascriptExecutor) driverinstance;
        je.executeScript(command, ele);
    }
}