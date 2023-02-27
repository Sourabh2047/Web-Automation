package doxzillaTest;

public class MyListTest extends BaseTest {
/*
	@Test (groups = {"Sanity", "Regression"}, description="In this Test we validate Contents Adding in MyList.")
	public void MyListTest1(){

		MyList listObj = new MyList(driver);
		listObj.callAddToMyList();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='widescreen-landscape-item'])[1]"))).click();
		WebElement move=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button']/h3")));
		JavascriptExecutor je4 = (JavascriptExecutor) driver;
		je4.executeScript("arguments[0].scrollIntoView(true);",move);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='addtolist']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/en/user/mywatchlist'])[1]"))).click();

		//logout
		driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
		driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='logoutUser']")));
		WebElement logout=driver.findElement(By.xpath("//button[@id='logoutUser']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout);
		action.click();
	}
	
	/*  @Test (groups = {"Sanity", "Regression"}, description="In this Test we validate User is able to remove contents from MyList or not.")
	  public void MyListTest2() 
	  {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/en/user/mywatchlist'])[1]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='img'])[1]")));
		  //WebElement ele = driver.findElement(By.xpath("(//img[@class='img'])[4]"));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='icon-list']/span"))).click();
		  //WebElement ele1 = driver.findElement(By.xpath("(//img[@class='img'])[3]"));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Remove from watchlist']"))).click();
		  //remove my list content not working
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Remove from watchlist']"))).click();
		  
		  //logout
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='userimg-pic']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Account & Settings'])[2]"))).click();
		  WebElement logout=driver.findElement(By.xpath("//button[@id='logoutUser']"));
		  JavascriptExecutor js11 = (JavascriptExecutor) driver;
		  js11.executeScript("window.scrollBy(0,100)", "");
		  logout.click();
	  }
	  @Test (groups = {"Sanity", "Regression"}, description="In this Test we validate Content Adding in MyList and remove or not.")
	  public void MyListTest3() throws InterruptedException 
	  {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		  WebElement rail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' New Releases ']")));
		  JavascriptExecutor je = (JavascriptExecutor) driver;
		  je.executeScript("arguments[0].scrollIntoView(true);",rail);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='slide slick-slide slick-active slick-expand'])[3]"))).click();
		  String header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='basic-detail']/h2"))).getText();
		  Assert.assertEquals(header, "Speed Kills - Ocean");
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='addtolist']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/en/user/mywatchlist'])[1]"))).click();
		  WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//div[@class='card text-white'])[1]")));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele);
		  action.click();
		  action.build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='card-img'])[1]"))).click();
		  ///////////////////////////////////////////////////////
		  String header1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='basic-detail']/h2"))).getText();
		  Assert.assertEquals(header1, "Speed Kills - Ocean");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//span[@class='addtolist hover']")).click();
		  Thread.sleep(8000);
		  //logout
		  driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
		  Thread.sleep(5000);
		  JavascriptExecutor js11 = (JavascriptExecutor) driver;
		  js11.executeScript("window.scrollBy(0,100)", "");
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='logoutUser']"))).click();
	  }
	  @Test (groups = {"Sanity", "Regression"}, description="In this Test we validate Content Adding in MyList and remove or not.")
	  public void MyListTest4() throws InterruptedException 
	  {
		  WebElement rail=driver.findElement(By.xpath("//div[text()=' New Releases ']"));
		  JavascriptExecutor je = (JavascriptExecutor) driver;
		  je.executeScript("arguments[0].scrollIntoView(true);",rail);
		  Thread.sleep(5000);
		  WebElement el=driver.findElement(By.xpath("(//div[@class='slide slick-slide slick-active slick-expand'])[3]"));
		  el.click();
		  Thread.sleep(8000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		  String header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='basic-detail']/h2"))).getText();
		  Assert.assertEquals(header, "Speed Kills - Ocean");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//span[@class='addtolist']")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("(//a[@href='/en/user/mywatchlist'])[1]")).click();
		  Thread.sleep(5000);
		  WebElement ele = driver.findElement(By.xpath("(//img[@class='img'])[1]"));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele);
		  action.click();
		  action.build().perform();
		  driver.findElement(By.xpath("//span[text()='Remove from watchlist']")).click();
		  Thread.sleep(8000);
		  //logout
		  driver.findElement(By.xpath(".//a[@class='userimg-pic']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("(//span[text()='Account & Settings'])[2]")).click();
		  Thread.sleep(5000);
		  WebElement logout=driver.findElement(By.xpath("//button[@id='logoutUser']"));
		  JavascriptExecutor js11 = (JavascriptExecutor) driver;
		  js11.executeScript("window.scrollBy(0,100)", "");
		  Thread.sleep(1000);
		  logout.click();
	  }*/
}
