package doxzillaTest;

import doxzillaPages.AccountSettingPage;
import doxzillaPages.LoginPage;
import doxzillaPages.OnboardingPage;
import doxzillaPages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestData;

public class SearchTest extends BaseTest {
    @DataProvider(name = "search")
    public Object[][] getValidCredentials() {
        return new Object[][]{{TestData.getDataValue("Search", "Movie"), TestData.getDataValue("Search", "Series")}};
    }

    @Test(priority = 0, groups = {"Sanity", "Regression"}, description = "Validating of Popular Search")
    public void PopularSearchTest() throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCredentials(TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass"));
        SearchPage sp = new SearchPage(driver);
        sp.popularSearch();
        String header = sp.getSearchPageHeader();
        Assert.assertEquals(header, "Popular Searches");
        AccountSettingPage lp = new AccountSettingPage(driver);
        lp.genLogout();
    }
/*
    @Test(priority = 1, dataProvider = "search", groups = {"Sanity", "Regression"}, description = "Validation of Series Search Test.")
    public void SeriesSearchTest(String Movie, String Series) throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCredentials(TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass"));
        SearchPage sp = new SearchPage(driver);
        sp.searchBox().sendKeys(Series);
        Thread.sleep(5000);
        AccountSettingPage lp = new AccountSettingPage(driver);
        lp.genLogout();
    }

    @Test(dataProvider = "search", groups = {"Sanity", "Regression"}, description = "Validation of Movies Search.")
    public void MovieSearchTest(String Movie, String Series) throws InterruptedException {
        new OnboardingPage(driver).clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCredentials(TestData.getDataValue("Login", "Email"), TestData.getDataValue("Login", "Pass"));
        SearchPage sp = new SearchPage(driver);
        sp.searchBox().sendKeys(Movie);
        Thread.sleep(5000);
        AccountSettingPage lp = new AccountSettingPage(driver);
        lp.genLogout();
    }

		@Test(groups = {"Sanity", "Regression"}, description = "In this Test we validate  search result is correct or not")
		public void ValidSearchTest2() throws InterruptedException 
		{
			WebElement search = driver.findElement(By.cssSelector("input#search-input-control"));
			search.click();
			Thread.sleep(1000);
			search.clear();
			search.sendKeys("zzzz");
			Thread.sleep(1000);
			search.sendKeys(Keys.RETURN);
			Thread.sleep(5000);
			// Verification code should b written to check on searching zzz we get z result
			driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
			Thread.sleep(5000);
			WebElement logout = driver.findElement(By.xpath("//button[@id='logoutUser']"));
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(1000);
			logout.click();
		}
		@Test(groups = {"Sanity", "Regression"}, description = "In this Test we validate search and check search result")
		public void ValidSearchTest3(String Search) throws InterruptedException 
		{
			WebElement se = driver.findElement(By.cssSelector("input#search-input-control"));
			se.click();
			se.clear();
			se.sendKeys(Data.Search);
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//div[@class='widescreen-landscape-item'])[1]")).click();
			Thread.sleep(5000);
			String header = driver.findElement(By.xpath(".//div[@class='basic-detail']/h2")).getText();
			Assert.assertEquals(header, "re");
			// Title check kro
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
			Thread.sleep(5000);
			WebElement logout = driver.findElement(By.xpath("//button[@id='logoutUser']"));
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(1000);
			logout.click();
		}
		@Test(groups = {"Sanity", "Regression"}, description = "In this Test we validate popular searches are displaying when user not enter any search keywordt")
		public void InvalidSearchTest1() throws InterruptedException 
		{
			WebElement search = driver.findElement(By.cssSelector("input#search-input-control"));
			search.click();
			Thread.sleep(1000);
			search.clear();
			search.sendKeys("#@#$#");
			Thread.sleep(1000);
			search.sendKeys(Keys.RETURN);
			Thread.sleep(5000);
			String header = driver.findElement(By.xpath("//div[@class='rail-title']//h2")).getText();
			Assert.assertEquals(header, "No Results Found");
			Thread.sleep(5000);
			// web elements and get all popular searches
			driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
			Thread.sleep(5000);
			WebElement logout = driver.findElement(By.xpath("//button[@id='logoutUser']"));
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(1000);
			logout.click();
	}*/
}