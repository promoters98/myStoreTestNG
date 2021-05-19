package com.regression.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
public static WebDriver driver;
	
	public static void chromeSetup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void navigateToHomePage() {
		driver.get("http://automationpractice.com/index.php");
	}
	public static void tearDown() {
		System.out.println("*** Closing browser. ***");
		driver.quit();
	}

}
