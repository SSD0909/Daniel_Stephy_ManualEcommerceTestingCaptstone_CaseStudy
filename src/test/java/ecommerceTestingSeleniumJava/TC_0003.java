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

public class TC_0003 {

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
							EnterUserNameReg.sendKeys("Alexa");
							System.out.println("UserName Entered");
							EnterEMailReg.sendKeys("Alexa@gmail.com");
							System.out.println("Email Address Entered");
							EnterPassReg.sendKeys("Perscholas0909");
							System.out.println("Password Entered");
							Thread.sleep(5000);
							//using actions class page down and perform the next action					
							actions.sendKeys(Keys.PAGE_DOWN).build().perform();
							Thread.sleep(5000);
							//get web element for registration button
							WebElement RegBtnClick=driver.findElement(By.name("register"));
							//RegBtnClick.sendKeys(Keys.ENTER);
							RegBtnClick.click();
							System.out.println("Registered");
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							//testing whether the error message for existing user
							WebElement errormessage = driver.findElement(By.className("woocommerce-error"));
							String actualError = errormessage.getText();
							//using getText method the retrieve the text of the element
							String expectedError = "Error: An account is already registered with that username. Please choose another.";
		if(expectedError.equals(expectedError)) {
			System.out.println(errormessage.getText());
		}
		else {
			System.out.println("Failed");
		}
							Assert.assertEquals(expectedError, actualError);
		
							}
						catch (Exception e)
						{
							e.printStackTrace();
						}
			
						driver.quit();
	
	}

}
