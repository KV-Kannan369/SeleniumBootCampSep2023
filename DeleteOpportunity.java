package seleniumbc23;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Opportunity tab 
5. Search the Opportunity 'Salesforce Automation by Your Name'
6. Click on  the Dropdown icon and Select Delete
7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name                                                          

Expected Result: Oppurtunity is Successfully deleted                                                                                                

 */
public class DeleteOpportunity extends ProjectSpecificationMethod {

	@Test
	public void deleteOpportunity() throws InterruptedException {
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		user.sendKeys("kv.kannan369@gmail.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys("OmS@iram369");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		try {
			WebElement viewAll = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
			viewAll.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// driver.findElement(By.xpath("//button[text()='View All']")).click();
		// Thread.sleep(5000);
		WebElement sales = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/p[text()='Sales']")));
		sales.click();
		// driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='Opportunities']/parent::a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		Actions actions = new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		actions.sendKeys(search, "Salesforce Automation by Kannan K V", Keys.ENTER).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));
		int beforesize = list.size();
		System.out.println("Before RowCount:" + beforesize);
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker')]//a[@role='button']/span"))
					.click();
			Thread.sleep(10000);
			WebElement del = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Delete'])[3]//div")));
			Thread.sleep(10000);
			js.executeScript("arguments[0].click();", del);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		int aftersize = list.size();
		System.out.println("After RowCount:" + aftersize);

	}

}
