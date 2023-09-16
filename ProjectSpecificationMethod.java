package seleniumbootcamp2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificationMethod {
	
	public WebDriver driver = null;
	public WebDriverWait wait;
	

	@BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("-start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	}
	@AfterMethod
	public void postCondition()
	{
		if(driver!=null)
			driver.quit();
	}
}
