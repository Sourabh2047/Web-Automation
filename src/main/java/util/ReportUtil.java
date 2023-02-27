package util;

import browser.WebDriverManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import report.ExtentReportManager;

public class ReportUtil {
    public static void addScreenShot(String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message,
                ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
    }

    public static void addScreenShot(LogStatus status, String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ExtentReportManager.getCurrentTest().log(status, message,
                ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
    }

    public static void logMessage(String message, String details) {
        ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
    }

    public static void logMessage(LogStatus status, String message, String details) {
        ExtentReportManager.getCurrentTest().log(status, message, details);
    }
}