package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserImplementation.BrowserImplementations;
import pages.FlightBooking;

import pages.LoginPage;

import pages.SignUpPage;
import utility.ObjectReader;

public class VerifyAllTestCase
{
	WebDriver driver;
	LoginPage loginPage;
	BrowserImplementations br;
	ObjectReader reader;
	SignUpPage signup;
	FlightBooking flightbooking;
	
	
	@BeforeTest   //Run before the test-case start
	
	public void LaunchBrowser() throws Exception 
	{
		// Calling which browser we should use
		
		reader = new ObjectReader();
		br = new BrowserImplementations();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CHROME OR EDGE Browser to Use");
		String browser = sc.next();
		
		if(browser.equalsIgnoreCase("CHROME"))    // Chrome Browser
		{
			driver = br.chromeDriver();
			String url = reader.getBaseUrl();
			driver.get(url);
			Thread.sleep(3000);
		
		}
		else if(browser.equalsIgnoreCase("EDGE"))     //Edge Browser
		{
			System.setProperty("webdriver.edge.driver","E:\\Zensar\\automation testing\\webTourAutomation\\BrowserDriver\\msedgedriver.exe");
			driver = br.edgeDriver();
			String url = reader.getBaseUrl();
			driver.get(url);
			Thread.sleep(3000);
			//loginPage.loginToApp();
		}
		else
		{
			throw new Exception("Incorrect Browser");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("-------Before Test is called....-------");
	}
	
	// Verification of the Login 
	
	@Test(priority=1)
	public void verifyLogin() throws InterruptedException, IOException 
	{
		
		String url = reader.getBaseUrl();
		driver.get(url);
		loginPage = new LoginPage(driver);
		loginPage.getTitle();
		loginPage.getCurrentUrl();
		loginPage.loginToApp();
	}
	
	// Verification of Flight Booking , Itinerary ,Sign off  
	
	@Test(priority=2)
	public void flightBooking() throws InterruptedException, IOException
	{
		String url = reader.getBaseUrl();
		driver.get(url);
		flightbooking = new FlightBooking(driver);
		flightbooking.loginToApp();
		flightbooking.clickOnFlightbooking();
		flightbooking.getCurrentUrl();
		flightbooking.BookFlight();
		flightbooking.findFlight();
		flightbooking.paymenthOption();
		flightbooking.confirmationMsg();
		flightbooking.clickOnItinerary();
		flightbooking.clickOnSignOff();
	}
	
	// Verification of the sign up
	
		@Test(priority=3)
		public void verifySignUp() throws IOException, InterruptedException
		{
			signup = new SignUpPage(driver);
			signup.Click_SignIn();
			signup.details();
		}
	
	// After test TestCase quit method calling
	
	@AfterMethod
	public void cleanUpTestAfterexec(ITestResult result) throws IOException
	{
	
		
		if (ITestResult.FAILURE == result.getStatus())
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("E:\\Zensar\\automation testing\\webTourAutomation\\ScreenShots\\" + result.getName() + ".png"));
		}
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
