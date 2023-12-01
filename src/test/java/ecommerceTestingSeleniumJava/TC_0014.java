package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_0014 {

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
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				try {
					//Open url (Home page)
						driver.get("http://demo.perscholastraining.com/");
						
						WebElement search=driver.findElement(By.id("search"));
						search.clear();
						
						search.sendKeys("Smartphone 6S 64GB LTE");
						
						WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[1]/form/div/div[3]/button/i"));
						searchButton.click();
						
						String pdtDisplayed=driver.findElement(By.xpath("//*[@id=\"product-2926\"]/div[1]/div[2]/h1")).getText();
						String actualProduct="Smartphone 6S 64GB LTE";
						if(pdtDisplayed.equals(actualProduct)) {
							
							System.out.println("The product displayed is correct");
							
						}
						
						else {
							System.out.println("The product displayed is wrong");
						}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
		
		
		driver.quit();
		
	}

}
