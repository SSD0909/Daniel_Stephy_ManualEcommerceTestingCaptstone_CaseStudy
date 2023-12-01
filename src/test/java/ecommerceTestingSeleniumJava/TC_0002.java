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
import org.testng.Assert;

public class TC_0002 {
	
	//Enter Weak password for New User Registration	Negative testing for Registration.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set Chromedriver path
				System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromeDriver\\chromedriver.exe");
				//providing chrome options to set the securities
				ChromeOptions options= new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
				options.addArguments("--remote-allow-origins=*");
				// Open browser
				WebDriver driver=new ChromeDriver(options);
				//Actions and javascript executor class objects are created for performing actions on the html page
				Actions actions = new Actions(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				//remove websocket listner error
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				//maximize the window
				driver.manage().window().maximize();
								
				try {
				//Open url (Home page)
					driver.get("http://demo.perscholastraining.com/");
				//Click on My Account Button from header
				driver.findElement(By.linkText("My Account")).click();
				System.out.println("The My Account button is clicked");
				//get elements from html page for  Username, Email address and Password in the Registration Form.
				WebElement EnterUserNameReg=driver.findElement(By.id("reg_username"));							
				WebElement EnterEMailReg=driver.findElement(By.id("reg_email"));				
				WebElement EnterPassReg=driver.findElement(By.xpath("//*[@id=\"reg_password\"]"));
				//Using clear method clearing the existing data if any present
					EnterUserNameReg.clear();
					EnterEMailReg.clear();
					EnterPassReg.clear();
					//sending values to the web elements captured
					EnterUserNameReg.sendKeys("stephy1");
					System.out.println("UserName Entered");
					EnterEMailReg.sendKeys("stephy1@gmail.com");
					System.out.println("Email Address Entered");
					EnterPassReg.sendKeys("P@ssper");
					System.out.println("Password Entered");
					Thread.sleep(5000);
					//using actions class page down and perform the next action	
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					//Testing whether weak password message is highlighted for the value entered
					String weakpasswordMessageDisplay = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/span/div")).getText();
					Thread.sleep(4000);
					System.out.println(weakpasswordMessageDisplay);
					String weakpass = "Weak - Please enter a stronger password.";
					//checking the equality of the string for weak password
					if(weakpasswordMessageDisplay.equals(weakpass)) {
						System.out.println(weakpasswordMessageDisplay);
					}
					else {
						System.out.println("Failed");
					}
					Assert.assertEquals(weakpass, weakpasswordMessageDisplay);
		
		
		
	
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
		driver.quit();
		



		
	}

}
