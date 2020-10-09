package com.my.scripts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebSauceLabsSampleTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver;
	
		//https://deevivivek3131:156e6131-98ea-46b5-88f7-42202116688c@ondemand.us-west-1.saucelabs.com:443/wd/hub

			MutableCapabilities sauceOpts = new MutableCapabilities();
			
			sauceOpts.setCapability("name", "Test1");
			sauceOpts.setCapability("build", "Java-W3C-Examples");
			sauceOpts.setCapability("seleniumVersion", "3.141.59");
			sauceOpts.setCapability("username", "deevivivek3131");
			sauceOpts.setCapability("accessKey", "156e6131-98ea-46b5-88f7-42202116688c");
			sauceOpts.setCapability("tags", "w3c-chrome-tests");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", "windows 10");
			cap.setCapability("browserName", "chrome");
			
				driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			
				
//				WebDriverManager.chromedriver().setup();
//				
//				//Creating WebDriver instance
//				WebDriver driver = new ChromeDriver();
				
				//Navigate to web page
				driver.get("https://demoqa.com/login");
				
				//Maximizing window
				driver.manage().window().maximize();
				
				//Retrieving web page title
				String title = driver.getTitle();
				System.out.println("The page title is : " +title);
				
				//Locating web element
				WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
				WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
				WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
				
				
				//Peforming actions on web elements
				uName.sendKeys("testuser");
				pswd.sendKeys("Password@123");
				loginBtn.click();
				
				//Putting implicit wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				try {
					
					//Locating web element
					WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
					//Validating presence of element				
					if(logoutBtn.isDisplayed()){
						
						//Performing action on web element
						logoutBtn.click();
						System.out.println("LogOut Successful!");
					}
				} 
				catch (Exception e) {
					System.out.println("Incorrect login....");
				}
				
				//Closing browser session
				driver.quit();
				
			}

		}

