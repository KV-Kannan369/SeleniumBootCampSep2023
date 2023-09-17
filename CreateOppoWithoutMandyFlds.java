package seleniumbootcamp2023;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateOppoWithoutMandyFlds extends ProjectSpecificationMethod {
	
	@Test
	public void createNewOpportunity() throws InterruptedException
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
		WebElement viewAll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAll.click();
		//Click Sales
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		//Click Opportunities Tab
		WebElement ele = driver.findElement(By.xpath("//span[text()='Opportunities']/parent::a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		//Click New Button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement closedate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		//Click close date
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String cldate = sdf.format(date)+1;
		closedate.sendKeys(cldate);
		//Click Save Button
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Stage
		String Expected = "Complete this field.";
		WebElement stg = driver.findElement(By.xpath("//div[text()='Complete this field.']/preceding-sibling::label[text()='Stage']/following-sibling::div/following-sibling::div"));
		String actual = stg.getText();
		Assert.assertEquals(actual, Expected);
		WebElement opp = driver.findElement(By.xpath("(//div[@part='help-text'])[2]"));
		String actual1 = opp.getText();
		Assert.assertEquals(actual1, Expected);
		
		Thread.sleep(3000);
		
			}

}
