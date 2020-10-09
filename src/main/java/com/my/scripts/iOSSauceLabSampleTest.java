package com.my.scripts;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSSauceLabSampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("appiumVersion", "1.13.0");
		cap.setCapability("deviceName","iPhone 8 Simulator");
		cap.setCapability("deviceOrientation", "portrait");
		cap.setCapability("platformVersion","13.4");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("appiumVersion", "1.17.1");
		cap.setCapability("name", "iOSTest");
		cap.setCapability("build","Java-TestNG-Appium-iOS"); // Optional
		
		cap.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.5.0/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.5.0.zip");
	//https://github.com/vivekdeevi/saucelabs/blob/main/demo/appium/iOS/iOSMobileSample.app.zip
	    WebDriver driver = null;
	    
		try {
			driver = new IOSDriver<IOSElement>(
					new URL("http://deevivivek3131:156e6131-98ea-46b5-88f7-42202116688c@ondemand.saucelabs.com:80/wd/hub"), cap);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			driver = new AndroidDriver<AndroidElement>( 
//					new URL("http://deevivivek3131:156e6131-98ea-46b5-88f7-42202116688c@ondemand.saucelabs.com:80/wd/hub"), cap);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement username = driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"test-Username\"]"));
        username.sendKeys("standard_user");

     
        WebElement password = driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"test-Password\"]"));
        password.sendKeys("secret_sauce");
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement login_btn = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"test-LOGIN\"]"));
        login_btn.click();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement products = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]"));
        if(products.isDisplayed()) {
        	System.out.println("Logged into the App");
        }
        driver.quit();
        	
	}

}
