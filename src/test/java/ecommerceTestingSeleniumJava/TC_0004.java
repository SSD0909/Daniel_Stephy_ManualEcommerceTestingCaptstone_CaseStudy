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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class TC_0004 {

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
					//Getting Webelements from the webpage for login useremail and password
					 WebElement EnterUserEmail= driver.findElement(By.id("username"));
					 WebElement EnterPass= driver.findElement(By.id("password"));
						//sending values to the username and password
						EnterUserEmail.sendKeys("Stu4@gmail.com");
						System.out.println("Email Address Entered");
						EnterPass.sendKeys("Psssw0rd@#$123452345sfsff");
						Thread.sleep(3000);
						//using actions class page down and perform the next action
					    actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					    Thread.sleep(3000);
					    //getting web element for the login button
						WebElement loginUser=driver.findElement(By.name("login"));
						//click method to login 
						loginUser.click();
						System.out.println("Logged in Successfully");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
									
						//Verify if hello testcase0004 is displayed or not
						WebElement user=driver.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/div/p[1]/strong[1]"));
						String expectedDisplay="Hello "+user.getText();
						
						String actualDisplay="Hello testcase0004";
						
				        Assert.assertEquals( expectedDisplay,actualDisplay);
						if(expectedDisplay.equals(actualDisplay)){
							System.out.println("Displayed User is correct");
							
						}
						
						else {
							System.out.println("Wrong data is being displayed");
						}
					
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				
				//As I was facing issues in websocket error replaced it with .close with .quit
					driver.quit();
	}

}
