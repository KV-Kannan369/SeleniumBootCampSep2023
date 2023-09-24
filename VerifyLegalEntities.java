package seleniumbc23;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
4. Click on the legal Entities tab
5. Click the sort arrow in the Last Modified Date.
6. Verify the Legal Entities displayed in ascending order by Last Modified Date.

Expected Result:Legal Entities Should be displayed in ascending order by Last Modified Date. 

 */


public class VerifyLegalEntities extends ProjectSpecificationMethod {
	
	@Test
	public void verifyLegalEntities() throws InterruptedException
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
		WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAll.click();
		//Click Legal Entities
		WebElement legal =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/p[text()='Legal Entities']")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",legal);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",legal);
		//WebElement lmdate = driver.findElement(By.xpath("//div[@class='slds-cell-fixed']/a[@role='button']/span[@title='Last Modified Date']"));
		Thread.sleep(10000);
		//List<WebElement> lstName = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/th/span/a"));
		List<WebElement> lmdate = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]"));
		List<String> listBefore = new ArrayList<String>();
		for (WebElement webElement : lmdate) {
			String dt = webElement.getText();
			listBefore.add(dt);
			System.out.println(dt);
		}
		System.out.println(listBefore.size());
		Collections.sort(listBefore);
		System.out.println(listBefore);
		WebElement lastMdate = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
		js.executeScript("arguments[0].click();", lastMdate);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", lastMdate);
		//lmdate.click();
		Thread.sleep(10000);
		List<WebElement> lmdates2 = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]"));
		List<String> listAfter = new ArrayList<String>();
		for (WebElement webElement : lmdates2) {
			String dt2 = webElement.getText();
			listAfter.add(dt2);
			System.out.println(dt2);
		}
		System.out.println(listAfter.size());
		System.out.println(listAfter);
		boolean result = listBefore.equals(listAfter);
		Assert.assertTrue(result);
		System.out.println("Test case passed");

		
		
		
	}
	

}
