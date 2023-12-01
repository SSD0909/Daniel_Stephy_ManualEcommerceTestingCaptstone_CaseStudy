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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TC_0008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		 SoftAssert softassert= new SoftAssert();		
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
						WebElement product=driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[1]/a/div/img"));
						Thread.sleep(3000);
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
						driver.findElement(By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/form/button")).click();
						Thread.sleep(3000);
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
						
						//Pdts image displayed
						
						List<WebElement> listOfProductsImages = driver.findElements(By.className("product-thumbnail"));
						System.out.println("The total Number of Product Images displayed is :");
						System.out.println(listOfProductsImages.size()-1);
						int expectedValue=listOfProductsImages.size()-1;
				        Assert.assertEquals(expectedValue, 2);
				        /*
				         * if(expectedValue==3){
				         * System.out.println("The images are displayed");
				         * }
				         * else{
				         * System.out.println("The images are not displayed");
				         * }
				         * 
				         */
						
						//Product names displayed
						List<WebElement> listOfProductName = driver.findElements(By.className("product-name"));
						System.out.println("The Total products added in cart are");

						System.out.println(listOfProductName.size()-1);
						 System.out.println("The added product names are");
						for (WebElement webElement : listOfProductName) {
				            String name = webElement.getText();
				           
				            System.out.println(name);
				           
				             System.out.println(name);
				             String expectedName=name;
					            String actualName1="White Solo 2 Wireless";
					            String actualName2="Tablet Red EliteBook Revolve 810 G2";
					            if (actualName1==expectedName) {
					            
						          Assert.assertEquals(expectedName,actualName1 );}
					            else if(actualName2==expectedName) {
					            	Assert.assertEquals(expectedName,actualName2 );
					            }
				        }
						
				        
						
						Thread.sleep(3000);
						//Product Quantity List
						List<WebElement> productquantity = driver.findElements(By.className("product-quantity"));
						int size=productquantity.size();
						for(int i=1; i < size; i++)
				        {
							WebElement linkElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/main/article/div/div/form/table/tbody/tr["+i+"]/td[5]/div/input"));
				            System.out.println(linkElement.getAttribute("value"));      
				            String expectedQuantity=linkElement.getAttribute("value");
				            //The code below uses assertNotNull() to validate if the expected output is not null
				            softassert.assertNotNull(expectedQuantity);
				
				        }
						
						Thread.sleep(3000);
						//Product Price List
						List<WebElement> productprice = driver.findElements(By.className("product-price"));
						
						System.out.println("Product price for individual product are:");
						for (WebElement webElement : productprice) {
							String price = webElement.getText();
					           
				            System.out.println(price);
				            softassert.assertNotNull(price);
				        }
			         //product subtotal
						List<WebElement> productTotalPrice = driver.findElements(By.className("product-subtotal"));
						System.out.println("SubTotal of each product added are:");
						for (WebElement webElement : productTotalPrice) {
							 String subTotal = webElement.getText();
					           
					            System.out.println(subTotal);
					            softassert.assertNotNull(subTotal);
				        }
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				driver.quit();
	}

}
