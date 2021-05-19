package com.regression.test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {

private WebDriver driver;
String appURL = "https://www.seleniumeasy.com/test/table-data-download-demo.html";


@BeforeClass
public void testSetUp() {

driver = new ChromeDriver();
}

@Test
public void verifyCountOfOffice() {
driver.navigate().to(appURL);

driver.findElement(By.xpath("//th[text()='Office']")).click();
driver.findElement(By.xpath("//th[text()='Office']")).click();

List<WebElement> count = driver.findElements(By.xpath("//td[@class='sorting_1'][text()='Tokyo']"));
System.out.println("Count of Tokyo : " + count.size());

}


@AfterClass
public void tearDown() {
driver.quit();
}

}