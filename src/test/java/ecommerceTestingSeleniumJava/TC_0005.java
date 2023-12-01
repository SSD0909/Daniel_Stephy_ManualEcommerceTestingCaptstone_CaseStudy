package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC_0005 {

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
				//using actions class page down and perform the next action
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
							//Capturing the webelement for the useremail and userpassword												
								WebElement EnterUserEmail= driver.findElement(By.id("username"));
								WebElement EnterPass= driver.findElement(By.id("password"));
								//sending values for user email and password								
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
								
								if(expectedDisplay.equals(actualDisplay)) {
									System.out.println(expectedDisplay);
								}
								else {
									System.out.println("Failed");
								}
								Assert.assertEquals( expectedDisplay,actualDisplay);
						
						//User in home page.
						driver.findElement(By.linkText("Home")).click();
						System.out.println("User Logged in and Landed in Home");
						//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						//verifying whether product price is displayed in home page
						boolean productPriceDisplay=driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[3]/div[1]/span/span/span")).isDisplayed();
						Assert.assertEquals( productPriceDisplay,true);
						if(productPriceDisplay) {
						System.out.println("The product price is displayed");
						}
						else {
						System.out.println("The product price is not displayed");
						}
						Thread.sleep(3000);
				    	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				    	Thread.sleep(3000);
				    	//find product 
						WebElement product=driver.findElement(By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[1]/a/div/img"));
						product.click();
						System.out.println("White Solo 2 Wireless is being selected");
						//2 Navigate to that specific product page"
						
						WebElement productdisplay=driver.findElement(By.linkText("White Solo 2 Wireless"));
						String expectedProductName=productdisplay.getText();
						String actualpdtDisplay="White Solo 2 Wireless";
						Assert.assertEquals( expectedProductName,actualpdtDisplay);
						
						if(expectedProductName.equals(actualpdtDisplay)) {
							
							System.out.println("The product selected is displayed .Testcase Passed");
							
						}
						else {
							System.out.println("The product selected is not correct.TestCase failed");
						}
						
						
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
		
		driver.quit();
		
		
		
		
		
	}

}
