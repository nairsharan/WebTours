package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import excelUtilities.ExcelReader;

public class FlightBooking
{
	public WebDriver driver;
	
	public FlightBooking(WebDriver driver) 
	{
		this.driver = driver;
	}

	// Checking the Title Of the page 
	
	public void getTitle() 
	{

		String expTitle = "Web Tours";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("Title Matched.....");
		Reporter.log("Title Matched.....");

	}


	// Providing details to login  
	
	public void loginToApp() throws InterruptedException 
	{
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		driver.findElement(By.name("username")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("xyz");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz");
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.switchTo().defaultContent();
		System.out.println("Login Successfully done...");
		Reporter.log("Login Successfully done...");
		Thread.sleep(2000);
	}
	
	// Checking flight button is working 
	
	public void clickOnFlightbooking()
	{
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		driver.findElement(By.xpath("//img[@alt='Search Flights Button']")).click();
		driver.switchTo().defaultContent();
		
		Reporter.log("Click button is working");

	}
	
	// Verifying the current url 
	
	public void getCurrentUrl() throws InterruptedException
	{
		String title = "http://localhost:1080/WebTours/index.htm";
		String acttitle = driver.getCurrentUrl();
		Assert.assertEquals(title, acttitle);
		Thread.sleep(2000);
		Reporter.log("URL Matched.....");
		
	}
	
	// Booking the flight 
	
	public void BookFlight()
	{

		driver.switchTo().frame("body");
		//driver.switchTo().frame("navbar");
		driver.switchTo().frame("info");
		
		Select departureCity=new Select(driver.findElement(By.name("depart")));
		departureCity.selectByValue("London");
		
		driver.findElement(By.xpath("//input[@name='departDate']")).clear();
		driver.findElement(By.name("departDate")).sendKeys("03/11/2022");
		
		Select aarivalCity=new Select(driver.findElement(By.name("arrive")));
		aarivalCity.selectByValue("Paris");
		
		driver.findElement(By.xpath("//input[@name='returnDate']")).clear();
		driver.findElement(By.name("returnDate")).sendKeys("03/15/2022");
		
		driver.findElement(By.xpath("//input[@name='numPassengers']")).clear();
		driver.findElement(By.name("numPassengers")).sendKeys("2");
		
		driver.findElement(By.xpath("//input[@value='Window']")).click();
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		
		driver.findElement(By.name("roundtrip")).click();
		driver.findElement(By.xpath("//input[@value='Window']")).click();
		
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		
		driver.switchTo().defaultContent();
		
		System.out.println("Flight Booked Successfully....");
		Reporter.log("Flight Booked Successfully....");


	}
	
	// Class of the flight 
	
	public void findFlight() 
		{
		
		driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        
        driver.findElement(By.name("outboundFlight")).click(); ////input[@value='121;343;03/11/2022']\"
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
        driver.switchTo().defaultContent();
        
		}
		
	// Flight booked confirmation 
	
	public void confirmationMsg() throws InterruptedException 
		{
			

			driver.switchTo().frame("body");
	        driver.switchTo().frame("info");
	        
	        String actMessage = "Thank you for booking through Web Tours.";
	        String expMessage = driver.findElement(By.xpath("/html/body/blockquote/center/small/b")).getText();
	        
	        Assert.assertEquals(actMessage, expMessage);
	        Reporter.log(" Confirmation Message Verified");
	        
	        Thread.sleep(2000);

		}
		
	// Payment details 
	
	public void paymenthOption() throws IOException
		{
		//Read data from excel sheet	
		
		
			driver.switchTo().frame("body");
			driver.switchTo().frame("info");
			driver.findElement(By.name("creditCard")).sendKeys("537934939996");
			driver.findElement(By.name("expDate")).sendKeys("04/25");
			driver.findElement(By.name("buyFlights")).click();
			
			driver.switchTo().defaultContent();
			Reporter.log("Payment Details Verified");
		}
		
	// Checking the Itinerary 
	
	public void clickOnItinerary() throws InterruptedException
		{
		driver.switchTo().defaultContent();
		
		//switch to the frame that has itinerary input fields
		
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//img[@alt=\'Itinerary Button\']")).click();   // clicking on the itinerary
		Thread.sleep(1000);
		
		// booked flights
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.findElement(By.name("removeAllFlights")).click();     // removing all booked flights
		
		// Assert.assertTrue(false);
		
		Assert.assertTrue(
		driver.findElement(By.cssSelector("h3")).getText().contains("No flights have been reserved."));
		
		System.out.println("Compleated with user Itinerary activity");
		Reporter.log("Compleated with user Itinerary activity");
		}
	
	// Checking signoff 
	
		public void clickOnSignOff()
		{
		driver.switchTo().defaultContent();
		// switch to the frame that has Signout input fields
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		driver.findElement(By.xpath("/html/body/center/center/a[4]/img")).click();
		
		System.out.println("Successfully SignedOff");
		Reporter.log("Successfully SignedOff");
		driver.switchTo().defaultContent();
		}
		

}
