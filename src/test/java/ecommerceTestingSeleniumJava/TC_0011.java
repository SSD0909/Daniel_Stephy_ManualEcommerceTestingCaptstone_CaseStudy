package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class TC_0011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromeDriver\\chromedriver.exe");
		
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
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				try {
					//Open url (Home page)
						driver.get("http://demo.perscholastraining.com/");
					
				
					//Click on My Account Button from header
					driver.findElement(By.linkText("My Account")).click();
					System.out.println("The My Account button is clicked");
					
					
					//Login Email address and Password in the Registration Form.
					
					
						WebElement username= driver.findElement(By.id("username"));
						WebElement password= driver.findElement(By.id("password"));
						
						
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
						//driver.navigate().refresh();
						
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
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[2]/div/div/div[1]/a/div/img")).click();
						
						boolean productbrand=driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/h1")).isDisplayed();
						if(productbrand) {
							System.out.println("Tablet Red EliteBook  Revolve 810 G2 is added");
						}
						else {
							System.out.println("Wrong display");
						}
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						Thread.sleep(5000);
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
						
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						Thread.sleep(6000);
						driver.findElement(By.linkText("Proceed to checkout")).click();
						
						boolean checkoutPage=driver.findElement(By.className("entry-title")).isDisplayed();
						if(checkoutPage) {
							System.out.println("You are in checkout page");
						}
						else {
							System.out.println("Failed to land in checkout page");
						}
						//Thread.sleep(2000);
						//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					
					//Payment details
					Thread.sleep(6000);
					driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div/h3"));
					System.out.println("Billing details header visible");
					WebElement firstName=driver.findElement(By.cssSelector("#billing_first_name"));
					firstName.clear();		
					firstName.sendKeys("Sam");
					System.out.println("FirstName Entered");
					//Thread.sleep(6000);
					WebElement lastName=driver.findElement(By.cssSelector("#billing_last_name"));
					lastName.clear();
					lastName.sendKeys("Sammy");
					System.out.println("LastName Entered");
					//Thread.sleep(6000);
					//driver.findElement(By.xpath("//*[@id=\"billing_country_field\"]/span/span/span[1]/span/span[2]")).click();
					//WebElement country=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
					//country.sendKeys("United States (US)");
					//System.out.println("Country Selected");
				//Thread.sleep(6000);
				//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					WebElement address=driver.findElement(By.cssSelector("#billing_address_1"));
					address.clear();
					address.sendKeys("123 SamStreet");
					System.out.println("Address Entered");
					//Thread.sleep(6000);
					WebElement city=driver.findElement(By.cssSelector("#billing_city"));
					city.clear();
					city.sendKeys("Leander");
					System.out.println("City Entered");
					Select state = new Select(driver.findElement(By.id("billing_state")));
					state.selectByVisibleText("Texas");
					System.out.println("State Selected");	
					//Thread.sleep(9000);
					//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					
				WebElement postCode=driver.findElement(By.cssSelector("#billing_postcode"));
					postCode.clear();
					postCode.sendKeys("78641");
					System.out.println("PinCode Entered");
					//Thread.sleep(3000);
					WebElement phone=driver.findElement(By.cssSelector("#billing_phone"));
					phone.clear();
					phone.sendKeys("5125370303");
					System.out.println("Phone Entered");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					WebElement stripeIFrameElementContainer = driver.findElement(By.className("__PrivateStripeElement"));
					
					driver.switchTo().frame(stripeIFrameElementContainer.findElement(By.tagName("iframe")));
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				WebElement cardNumber=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Field-numberInput")));
				cardNumber.sendKeys("4242424242424242");
				System.out.println("Card number Entered");
				WebElement cardExpiry = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Field-expiryInput")));
				cardExpiry.sendKeys("05/26");
				System.out.println("Card Expiry Entered");
				WebElement cardCVC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Field-cvcInput")));
				cardCVC.sendKeys("325");
				System.out.println("Card CVC Entered");
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				WebElement terms = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("terms")));
				terms.click();
				System.out.println("Terms Accepted");
				WebElement placeOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("woocommerce_checkout_place_order")));
				js.executeScript("arguments[0].click();", placeOrder);
				System.out.println("Order Placed");
				//actions.moveToElement(placeOrder).click().perform();
				//placeOrder.click();
				
				boolean orderdisplay=driver.findElement(By.cssSelector("h1.entry-title")).isDisplayed();
				if(orderdisplay==true) {
					System.out.println("You are in order page");
				}
				else {
					System.out.println("Failed");
				}
				
				String orderdisplayname=driver.findElement(By.cssSelector("h1.entry-title")).getText();
				System.out.println(orderdisplayname);
											
				Thread.sleep(3000);
				String expectedurl = driver.getCurrentUrl();
				//System.out.println(expectedurl);
				//customized css selector to capture the h1 text for the current url
				WebElement orderReceived = driver.findElement(By.cssSelector("header.entry-header h1.entry-title"));
				String expectedDisplay = orderReceived.getText(); 
				String actualOrder="Order received";
				System.out.println(expectedDisplay);
				/*if(expectedDisplay.equals(actualOrder)) {
					System.out.println("Order received is displayed");
				}
				else {
					System.out.println("Failed");
				}*/
				Assert.assertEquals(expectedDisplay,actualOrder);
				
				/*WebElement orderReceived=driver.findElement(By.className("entry-title"));
				System.out.println(driver.findElement(By.cssSelector("h1.entry-title")).getText());
				String actualOrder="Thank you. Your order has been received.";
				//Assert.assertEquals(expectedOrder,actualOrder);
				
		*/
		/*boolean orderReceivedDisplay=orderReceived.isDisplayed();
				
				if(orderReceivedDisplay) {
					
				
				System.out.println("Order Received is Displayed");
				}
				else {
					System.out.println("Order Received is not Displayed");
				}*/
				
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			driver.quit();
				
	}

}
