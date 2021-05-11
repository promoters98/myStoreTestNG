package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utils.Data;


public class LoginPage extends Base {
	
	Data d = new Data();
	
	@BeforeTest 
	public void userisOnHomePage() {
		chromeSetup();
		navigateToHomePage();
	}
	
	@Test (priority = 0)	
	public void userClicksOnSignIn() throws InterruptedException {
		WebElement SigninButton = driver.findElement(By.cssSelector(".login"));
		SigninButton.click();
		System.out.println("*** User has clicked sign in button. ***");
	}
	
	@Test (priority = 1)
	public void userEntersCredentials() throws InterruptedException {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(d.username);
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys(d.password);
		WebElement SignIn = driver.findElement(By.id("SubmitLogin"));
		SignIn.click();
		System.out.println("*** User has entered credentials. ***");
	}
	
	@Test (priority = 2)
	public void verifyHomePage() {
		String homeUrl = driver.getCurrentUrl();
		Assert.assertEquals(homeUrl, d.myAccountUrl);
		System.out.println("*** User has signed in successfully. ***");
	}
	
	@Test (priority = 3)
	public void userSignsOut() {
		WebElement signOutBtn = driver.findElement(By.className("logout"));
		signOutBtn.click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, d.logOutUrl);
		System.out.println("*** User is on Log Out page. ***");
	}
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}

}
