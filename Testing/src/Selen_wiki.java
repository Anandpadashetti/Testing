
public class Selen_wiki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
public static  WebDriver driver;
	
	public static void main(String[]args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/Selenium");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement el = driver.findElement(By.xpath("//span[.='External links']"));
		Point loc = el.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		el.click();
		boolean b = el.isDisplayed();
		
		if(b)
		{
			System.out.println("element is present");
		}
		else
		{
			System.out.println("element is not present");
		}
		driver.findElement(By.xpath("//span[.='O']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='//upload.wikimedia.org/wikipedia/en/thumb/e/e7/Cscr-featured.svg/20px-Cscr-featured.svg.png']"));
		boolean c = ele2.isDisplayed();
		if (c)
		{
			System.out.println("It is a featured article");
		}
		else
		{
			System.out.println("its not a featured article");
		}
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("F:\\photo.jpeg");
		FileUtils.copyFile(src, dst);
		WebElement ele1 = driver.findElement(By.xpath("//span[.='References']"));
		Point loc1 = ele1.getLocation();
		int x1 = loc1.getX();
		int y1 = loc1.getY();
		js.executeScript("window.scrollBy("+x1+","+y1+")");
		ele1.click();
		List<WebElement> links = driver.findElements(By.xpath("//span[.='(PDF)']"));
		int count = links.size();
		System.out.println(count);
		driver.findElement(By.id("searchInput")).sendKeys("pluto");
		WebElement ele3 = driver.findElement(By.xpath("//a[@href='/w/index.php?search=Plutonium&title=Special%3ASearch']"));
		boolean d = ele3.isDisplayed();
		if(d)
		{
			System.out.println("It is plutonium");
		}
		else
		{
			System.out.println("It is not plutonium");
		}
	}
	
	}

}
