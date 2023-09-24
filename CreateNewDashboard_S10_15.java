package seleniumbc23;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/*
 * Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the New Dashboard option
5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
6.Click on Save and Verify Dashboard name.                                                                                                 
Expected Result:The New Dashboard is created Successfully                                                                                          

 */

public class CreateNewDashboard_S10_15 extends ProjectSpecificationMethod{
	
	@Test
	public void createNewDashboard() throws InterruptedException
	{
		//User name
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		//
		user.sendKeys("hari.radhakrishnan@qeagle.com");
		
		//Password
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		//pwd.sendKeys("OmS@iram369");
		pwd.sendKeys("Leaf$1234");
		
		//Click Login Button
		driver.findElement(By.id("Login")).click();
		//click toggle button
		driver.findElement(By.className("slds-icon-waffle")).click();
		//click view all
		WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAll.click();
		//Click DashBoard
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//js.executeScript("window.scrollTo(0,1000)");
		WebElement dashBoard =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/p[text()='Dashboards']")));
		js.executeScript("arguments[0].scrollIntoView(true);",dashBoard);
		js.executeScript("arguments[0].click();",dashBoard);
		driver.findElement(By.xpath("//a//div[text()='New Dashboard']")).click();
		Thread.sleep(10000);
		//WebElement name = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		//WebElement name = driver.findElement(By.cssSelector("input#dashboardNameInput"));
		//WebElement name = driver.findElement(By.id("dashboardNameInput"));
		//Switch to Iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardNameInput")));
		Thread.sleep(10000);
		name.sendKeys("Salesforce Automation by Kannan K V");
		Thread.sleep(7000);
		driver.findElement(By.cssSelector("button#submitBtn")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(7000);
		//WebElement saved = driver.findElement(By.xpath("//span[text()='Dashboard saved']"));
		WebElement saved = driver.findElement(By.xpath("//span[text()='Dashboard saved']//parent::div"));
		
	}


}
