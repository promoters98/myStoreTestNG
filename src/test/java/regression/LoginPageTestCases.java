package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utils.Data;


public class LoginPageTestCases extends Base {
	
	@BeforeTest
	public void userisOnHomePage() {
		chromeSetup();
		navigateToHomePage();
	}
	
	@Test	
	public void userClickOnSignIn() throws InterruptedException {
		WebElement SigninButton = driver.findElement(By.cssSelector(".login"));
		SigninButton.click();
		System.out.println("*** User has clicked sign in button. ***");
	}
	
	@Test
	public void userEntersCredentials() {
		Data d = new Data();
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(d.username);
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys(d.password);
		WebElement SignIn = driver.findElement(By.id("SubmitLogin"));
		SignIn.click();
		tearDown();
	}
	

}
