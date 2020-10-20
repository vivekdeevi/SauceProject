package com.my.scripts;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidSauceLabSampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.5.0/Android.SauceLabs.Mobile.Sample.app.2.5.0.apk");
		cap.setCapability("deviceOrientation", "portrait");
		cap.setCapability("appiumVersion", "1.18.1");
		cap.setCapability("appPackage", "com.swaglabsmobileapp");
		cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
	    WebDriver driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>( 
					new URL("http://deevivivek3131:156e6131-98ea-46b5-88f7-42202116688c@ondemand.saucelabs.com:80/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        username.sendKeys("standard_user");

     
        WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
        password.sendKeys("secret_sauce");
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement login_btn = driver.findElement(By.xpath("	\n" + 
        		"//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
        login_btn.click();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement products = driver.findElement(By.xpath("//*[@text='PRODUCTS']"));
        if(products.isDisplayed()) {
        	System.out.println("Logged into the App");
        }
        driver.quit();
        	
	}
//Comment

}
