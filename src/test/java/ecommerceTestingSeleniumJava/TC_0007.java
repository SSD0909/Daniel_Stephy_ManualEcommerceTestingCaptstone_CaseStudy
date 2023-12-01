package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC_0007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromeDriver\\chromedriver.exe");
//providing chrome options to set the securities
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("--remote-allow-origins=*");
		//DesiredCapabilities cp= new DesiredCapabilities();
		//cp.setCapability(ChromeOptions.CAPABILITY, options);
		// Open browser
		WebDriver driver=new ChromeDriver(options);
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//remove websocket listner error
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		try {
			//Open url (Home page)
			driver.get("http://demo.perscholastraining.com/");
			//Click on My Account Button from header
			driver.findElement(By.linkText("My Account")).click();
			System.out.println("The My Account button is clicked");
			//Login Email address and Password in the Registration Form
						WebElement username= driver.findElement(By.id("username"));
						WebElement password= driver.findElement(By.id("password"));
						//send values to the login elements and click login
						username.sendKeys("Stu4@gmail.com");
						System.out.println("Email Address Entered");
						password.sendKeys("Psssw0rd@#$123452345sfsff");
						Thread.sleep(5000);											
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();						
						WebElement loginUser=driver.findElement(By.name("login"));
						Thread.sleep(3000);
						loginUser.click();
						System.out.println("Logged in Successfully");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						//Map<String, Object> prefs = new HashMap<String, Object>();
						//prefs.put("credentials_enable_service", false);
						//"1 Select any product (click on any product).
						driver.findElement(By.linkText("Home")).click();
						System.out.println("User Logged in and Landed in Home");
						driver.navigate().refresh();
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						WebElement product=driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[1]/a/div/img"));					
						product.click();
						System.out.println("White Solo 2 Wireless is being selected");
						//2 Navigate to that specific product page"
						
						WebElement productdisplay=driver.findElement(By.linkText("White Solo 2 Wireless"));
						String actualoutput=productdisplay.getText();
						String expectedoutput="White Solo 2 Wireless";
						if(actualoutput.equals(expectedoutput)) {
							System.out.println("The product selected is displayed .Testcase Passed");
							}
						else {
							System.out.println("The product selected is not correct.TestCase failed");
						}
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						WebElement quantity=driver.findElement(By.name("quantity"));
						//Using Java Script Executor to add the quantity of 2 to the selected product
						//The increment and decrement buttons are Browser specific objects and not part of the DOM. 
						//So I can not use the inspector to get the xpath. 
						//Incrementing the input using setAttribute
						//quantity.clear();
						//quantity.sendKeys("2");
						quantity.sendKeys(Keys.ARROW_UP);
					//js.executeScript("arguments[0].setAttribute('value','2')", quantity);
						
						System.out.println("Able to add the quantity");
						driver.findElement(By.name("add-to-cart")).click();
						
						
						//Decrement the quantity 
						//js.executeScript("arguments[0].setAttribute('value','1')", quantity);
						//quantity.sendKeys(Keys.ARROW_DOWN);
						
						//add second product
						
						driver.findElement(By.linkText("Home")).click();
						Thread.sleep(3000);
				    	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				    	 Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[2]/div/div/div[1]/a/div/img")).click();
						//test the second product brand name 
						String productBrandNameDisplayed=driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/h1")).getText();
			        	String actualDisplay ="Tablet Red EliteBook Revolve 810 G2";
				    	Assert.assertEquals( productBrandNameDisplayed,actualDisplay);
						
						boolean productbrand=driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/h1")).isDisplayed();
						if(productbrand) {
							System.out.println("Tablet Red EliteBook  Revolve 810 G2 is added");
						}
						else {
							System.out.println("Wrong display");
						}
						//click on second product to add
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/form/button")).click();
						
						//testing product added message
						String secondproductAddedMessage=driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/a")).getText();
			        	String actualMessageDisplay ="View cart";
				    	
				    	 Assert.assertEquals( secondproductAddedMessage,actualMessageDisplay);
						boolean message=driver.findElement(By.className("woocommerce-notices-wrapper")).isDisplayed();
						if(message) {
							System.out.println(" “Tablet Red EliteBook  Revolve 810 G2” has been added to your cart.“");
						}
						else {
							System.out.println("Failed to display");
						}
						Thread.sleep(3000);
						//testing whether the view cart is enabled or not
						boolean viewcartBtnEnabled=driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/a")).isEnabled();
						 Assert.assertEquals( viewcartBtnEnabled,true);
						if(viewcartBtnEnabled) {
							System.out.println(" View Cart Button is enabled");
						}
						else {
							System.out.println("Failed to enable the button");
						}
						}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				driver.quit();
	}

}
