package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import excelUtilities.ExcelReader;

public class SignUpPage 
{
WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	// SignIn option
	
	public void Click_SignIn()
	{
		driver.get("http://localhost:1080/WebTours/home.html");
		driver.findElement(By.linkText("sign up now")).click();
		driver.switchTo().defaultContent();
	}
	
	// SignIn Details
	
	public void details() throws IOException, InterruptedException
	{
		//driver.switchTo().frame("body");
		//driver.switchTo().frame("info");
		
		
		//Calling the Data from the Excel sheet
		
		ExcelReader obj = new ExcelReader ("E:\\Zensar\\automation testing\\webTourAutomation\\DataSource\\data1.xlsx");
		int RowCount = obj.getRow(0);
		
		for(int i=0; i<=RowCount;i++)
		{
			
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys(obj.getData(0, i, 0));
			
			
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(obj.getData(0, i, 1));
			
			
			driver.findElement(By.name("passwordConfirm")).click();
			driver.findElement(By.name("passwordConfirm")).sendKeys(obj.getData(0, i, 1));
			
			
			driver.findElement(By.name("firstName")).click();
			driver.findElement(By.name("firstName")).sendKeys(obj.getData(0,i, 2));
			
			
			driver.findElement(By.name("lastName")).click();
			driver.findElement(By.name("lastName")).sendKeys(obj.getData(0,i, 3));
			
			
			driver.findElement(By.name("address1")).click();
			driver.findElement(By.name("address1")).sendKeys(obj.getData(0,i, 4));
			
			
			driver.findElement(By.name("address2")).click();
			driver.findElement(By.name("address2")).sendKeys(obj.getData(0,i, 5));
				
			
			//Clearing details after register one user
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("firstName")).clear();
			driver.findElement(By.name("lastName")).clear();
			driver.findElement(By.name("address1")).clear();
			driver.findElement(By.name("address2")).clear();
			driver.findElement(By.name("passwordConfirm")).clear();
			
			
		    System.out.println("Registration Successfully done..." );
			Reporter.log("Registration Successfully done..." +i );
			driver.switchTo().defaultContent();
			
	}
		driver.findElement(By.name("register")).click();
		
	}
}
