package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC_0006 {

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
		
		//remove websocket listner error
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize the window
		driver.manage().window().maximize();
				try {
					//Open url (Home page)
						driver.get("http://demo.perscholastraining.com/");								
					//Click on My Account Button from header
					driver.findElement(By.linkText("My Account")).click();
					System.out.println("The My Account button is clicked");					
					//Login Email address and Password in the Registration Form.
						WebElement EnterUserEmail= driver.findElement(By.id("username"));
						WebElement EnterPass= driver.findElement(By.id("password"));
						//enter the credentials	& login				
						EnterUserEmail.sendKeys("Stu4@gmail.com");
						System.out.println("Email Address Entered");
						EnterPass.sendKeys("Psssw0rd@#$123452345sfsff");
						Thread.sleep(3000);
					    actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					    Thread.sleep(3000);
						WebElement loginUser=driver.findElement(By.name("login"));
						loginUser.click();
						System.out.println("Logged in Successfully");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						//Verify if hello testcase0004 is displayed or not
						WebElement user=driver.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/div/p[1]/strong[1]"));
						String expectedDisplay="Hello "+user.getText();
						String actualDisplay="Hello testcase0004";
						Assert.assertEquals( expectedDisplay,actualDisplay);
				
				//"1 Select any product (click on any product).
				driver.findElement(By.linkText("Home")).click();
				System.out.println("User Logged in and Landed in Home");
						//driver.navigate().refresh();
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						WebElement product=driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[1]/a/div/img"));
						product.click();
						System.out.println("White Solo 2 Wireless is being selected");
						//2 Navigate to that specific product page and verify if product is displayed
						WebElement productdisplay=driver.findElement(By.linkText("White Solo 2 Wireless"));
						String expectedoutput=productdisplay.getText();
						String actualoutput="White Solo 2 Wireless";
						Assert.assertEquals( expectedoutput,actualoutput);
						if(expectedoutput.equals(actualoutput)) {
							
							System.out.println("The product selected is displayed .Testcase Passed");
							
						}
						else {
							System.out.println("The product selected is not correct.TestCase failed");
						}
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						//increase the quantity of the product selected
						WebElement quantity=driver.findElement(By.name("quantity"));
						//Using Java Script Executor to add the quantity of 2 to the selected product
						//The increment and decrement buttons are Browser specific objects and not part of the DOM. 
						//So I can not use the inspector to get the xpath. 
						//Incrementing the input using setAttribute
						quantity.clear();
						quantity.sendKeys("2");
						//js.executeScript("arguments[0].setAttribute('value','2')", quantity);
						String expectedQuantity=quantity.getAttribute("value");
			        	String actualQuantity="2";
			        	Assert.assertEquals( expectedQuantity,actualQuantity);
			        	if(expectedQuantity.equals(actualQuantity)){
							System.out.println("Quantity of product increased");
							}
						else {
							System.out.println("Quantity of product is not increased");
						}
						//Decrement the quantity 
						//js.executeScript("arguments[0].setAttribute('value','1')", quantity);
						//verify if the item is added in cart
						boolean itemadded=driver.findElement(By.className("woocommerce-message")).isDisplayed();
						if(itemadded) {
						System.out.println("Item is being added in the cart");}
						else {
						System.out.println("Test Failed");
						}	
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
		
	driver.quit();
	}

}
