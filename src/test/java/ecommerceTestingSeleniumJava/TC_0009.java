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

public class TC_0009 {

	public static void main(String[] args) {
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
									
					//Login Email address and Password in the Registration Form.
									
						WebElement username= driver.findElement(By.id("username"));
						WebElement password= driver.findElement(By.id("password"));
						//Login with credentials					
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
						Thread.sleep(3000);
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
						quantity.sendKeys(Keys.ARROW_UP);
					//js.executeScript("arguments[0].setAttribute('value','2')", quantity);
						System.out.println("Able to add the quantity");
						driver.findElement(By.name("add-to-cart")).click();
						
						
						//Decrement the quantity 
						//js.executeScript("arguments[0].setAttribute('value','1')", quantity);
						
						//add another item
						
						driver.findElement(By.linkText("Home")).click();
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[2]/div/div/div[1]/a/div/img")).click();
						boolean productbrand=driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/h1")).isDisplayed();
						if(productbrand) {
							System.out.println("Tablet Red EliteBook  Revolve 810 G2 is added");
						}
						else {
							System.out.println("Wrong display");
						}
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/form/button")).click();
						
						//product added message
						boolean message=driver.findElement(By.className("woocommerce-notices-wrapper")).isDisplayed();
						if(message) {
							System.out.println(" “Tablet Red EliteBook  Revolve 810 G2” has been added to your cart.“");
						}
						else {
							System.out.println("Failed to display");
						}
						Thread.sleep(3000);
						boolean viewcartBtnEnabled=driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/a")).isEnabled();
						
						if(viewcartBtnEnabled) {
							System.out.println(" View Cart Button is enabled");
							driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/a")).click();
							
						}
						System.out.println("Welcome to Cart Page");
						
						//Remove the products in cart
						driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[1]/a")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[1]/a")).click();
						System.out.println("Clicked on All Products in cart");
						Thread.sleep(6000);
					boolean emptycart=	driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/div/div[2]")).isDisplayed();
					if(emptycart) {
						System.out.println("Your cart is currently empty.");
					}
					else {
						System.out.println("The Cart empty is not Displayed");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
//driver.quit();
	}

}
