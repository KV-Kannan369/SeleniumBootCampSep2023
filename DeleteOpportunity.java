package seleniumbootcamp2023;

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

public class DeleteOpportunity extends ProjectSpecificationMethod {

	@Test
	public void createNewOpportunity() throws InterruptedException {
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
		//Thread.sleep(5000);
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
		// actions.sendKeys("Salesforce Automation by Kannan K V").build().perform();
		// actions.sendKeys(search, Keys.ENTER).build().perform();
		// search.sendKeys("Salesforce Automation by Kannan K V");
		// search.click();
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));
		int beforesize = list.size();
		System.out.println("Before RowCount:" + beforesize);
		// WebElement dd =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Show
		// 3 more actions']")));
		// WebElement dd =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-aura-rendered-by='1096:0']//span")));
		try {
			WebElement dd = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[8]/span[1]/div[1]/a[1]/span[1]/span[1]")));

			// driver.findElement(By.xpath("//span[@data-aura-rendered-by='1096:0']//span")).click();
			// WebElement dd = driver.findElement(By.xpath("//a[@title='Show 3 more
			// actions']"));
			// dd.click();
			js.executeScript("arguments[0].click();", dd);
			WebElement del = driver.findElement(By.xpath("//a[@title='Delete']"));
			//// a[@title='Delete']
			// del.click();
			js.executeScript("arguments[0].click();", del);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		int aftersize = list.size();
		System.out.println("After RowCount:" + aftersize);

	}

}
