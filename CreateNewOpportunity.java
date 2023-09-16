package seleniumbootcamp2023;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateNewOpportunity extends ProjectSpecificationMethod {
	
	@Test
	public void createNewOpportunity() throws InterruptedException
	{
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		user.sendKeys("kv.kannan369@gmail.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("OmS@iram369");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		WebElement viewAll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAll.click();
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='Opportunities']/parent::a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		//WebElement opportunity = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Name")));
		WebElement opportunity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='Name']")));
		//WebElement opportunity = driver.findElement(By.name("Name"));
		// --  //input[@name='Name']
		opportunity.sendKeys("Salesforce Automation by Kannan K V");
		//String storedOpportunity = opportunity.getText();
		String storedOpportunity = "Salesforce Automation by Kannan K V";
		
		System.out.println("Text Value: "+storedOpportunity);
		WebElement closedate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String cldate = sdf.format(date);
		closedate.sendKeys(cldate);
		WebElement stage = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		stage.click();
		//driver.findElement(By.xpath("//span[text()='Needs Analysis']//parent::span//parent::button"));
		Thread.sleep(10000);
		WebElement need = driver.findElement(By.xpath("(//span[@class='slds-media__body']//following::span[@class='slds-truncate'])[3]"));
		need.click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement output = driver.findElement(By.xpath("//div[contains(text(),'Kannan')]"));
		String str = output.getText();
		System.out.println("Output Value: "+str);
		Assert.assertEquals(storedOpportunity, str);
	}

}
