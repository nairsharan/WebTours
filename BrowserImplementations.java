package browserImplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utility.ObjectReader;


public class BrowserImplementations
{
	ObjectReader reader;
	String ChromeKey, ChromePath;
	//String EdgeKey, EdgePath;
	String BaseUrl;

	public BrowserImplementations() throws IOException 
	{
		reader = new ObjectReader();    //Creating object
		
		 
		ChromeKey = reader.getChromeKey();                
		 ChromePath = reader.getChromePath();
		 System.setProperty(ChromeKey, ChromePath);
		 
		 BaseUrl = reader.getBaseUrl();		 
		 
		
	}
	
	public WebDriver chromeDriver() 
	{
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
	
	
	
	public WebDriver edgeDriver() 
	{
		
		WebDriver driver = new EdgeDriver();
		
		return driver;
	}

}
