package seleniumbc23;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
 * 1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
4. Click on the Dropdown icon in the legal Entities tab
5. Click on New Legal Entity
6. Enter Name as 'Salesforce Automation by Your Name'
7.Click save and verify Legal Entity Name                                        
Expected Result:The Legal Entity is created Successfully                                           

 */
public class CreateLegalEntity extends ProjectSpecificationMethod {
	
	@Test
	public void createLegalEntity() throws InterruptedException
	{
		//User name
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		user.sendKeys("kv.kannan369@gmail.com");
		//Password
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("OmS@iram369");
		//Click Login Button
		driver.findElement(By.id("Login")).click();
		//click toggle button
		driver.findElement(By.className("slds-icon-waffle")).click();
		//click view all
		//Thread.sleep(40000);
		WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAll.click();
		//Click Legal Entities
		//WebElement legal =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/p[text()='Legal Entities']")));
		//WebElement legal =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown")));
		WebElement legal =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Legal Entities']")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",legal);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",legal);
		//4. Click on the Dropdown icon in the legal Entities tab
		WebElement legaldd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a[@role='button']//lightning-primitive-icon//*[name()='svg']")));
		//WebElement legaldd = driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a[@role='button']//lightning-primitive-icon//*[name()='svg']"));
		Thread.sleep(3000);
		//js.executeScript("arguments[0].click();", legaldd);
		legaldd.click();
		//5. Click on New Legal Entity
		WebElement newLegal = driver.findElement(By.xpath("//a/span/span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();",newLegal);
		//6. Enter Name as 'Salesforce Automation by Your Name'
		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		String nameTxt = "Salesforce Automation by Kannan K V";
		name.sendKeys(nameTxt);
		System.out.println("Input Message: " +nameTxt);
		//7.Click save and verify Legal Entity Name
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		save.click();
		Thread.sleep(3000);
		//Expected Result:The Legal Entity is created Successfully
		WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]/a/div")));
		String finalMsg = message.getText();
		boolean result = finalMsg.equals(nameTxt);		
		System.out.println("Final Message:"+finalMsg);
		Assert.assertTrue(result);
		Assert.assertEquals(finalMsg, nameTxt);
		System.out.println("Test case passed");
		
		
	}
	

}
