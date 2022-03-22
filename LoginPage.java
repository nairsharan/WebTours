package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import excelUtilities.ExcelReader;
public class LoginPage
{
	public WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	// Checks the title
	
	public void getTitle() 
	{

		String expTitle = "Web Tours";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title Matched.....");

	}

	// checks the current url
	
	public void getCurrentUrl() throws InterruptedException
	{
		String title = "http://localhost:1080/WebTours/index.htm";
		String acttitle = driver.getCurrentUrl();
		Assert.assertEquals(title, acttitle);
		Thread.sleep(1000);
		Reporter.log("URL Matched.....");
		
	}
	
	// providing details
	
	public void loginToApp() throws InterruptedException, IOException 
	{
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		// Read data from excel
		
		ExcelReader obj = new ExcelReader ("E:\\Zensar\\automation testing\\webTourAutomation\\DataSource\\loginDetals.xlsx");
		int RowCount = obj.getRow(0);
		{
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys(obj.getData(0, 0, 0));
		Thread.sleep(2000);
		
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(obj.getData(0, 0, 1));
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Reporter.log("Login Successfully done...");
		Thread.sleep(2000);
		}
	}

}
