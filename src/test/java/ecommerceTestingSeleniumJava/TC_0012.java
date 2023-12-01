package ecommerceTestingSeleniumJava;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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

public class TC_0012 {

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
						driver.findElement(By.linkText("Home")).click();
						System.out.println("User is in Home Page");
						//driver.navigate().refresh();
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						Thread.sleep(3000);
						WebElement featuredProducts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[3]/div/div/ul/li[1]/a")));
						featuredProducts.click();
						
						WebElement totalProductsDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tab-products-1 > div > ul")));
						List<WebElement> links = totalProductsDisplay.findElements(By.tagName("li")); 
						int size=links.size();
				        for(int i=1; i <= 6; i++)
				        {
				        	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
				            WebElement linkElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/main/div[3]/div/div/div/div[1]/div/ul/li["+i+"]")));
				            System.out.println(linkElement.getText());  
				            boolean element=linkElement.getText().isEmpty();
				            
				            if(element==false) {
				            	 System.out.println("Products displayed");
				            }
				            else {
				            	 System.out.println("Failed");
				            }
				        }
						
						
						
						
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				driver.quit();
	}

}
