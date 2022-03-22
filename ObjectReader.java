package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader 
{
	Properties properties;
	
	public ObjectReader() throws IOException 
	{
		// Calling data from object properties
		
		File file = new File("E:\\Zensar\\automation testing\\webTourAutomation\\objectRepositry\\object.properties");
		FileInputStream fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
		
	}
	
	public String getChromeKey() 
	{
		return properties.getProperty("ChromeKey");          //getting Chrome key
				
	}
	
	public String getChromePath()
	{
		return properties.getProperty("ChromePath");		 //getting Chrome Path
	}
	
	public String getBaseUrl()
	{
		return properties.getProperty("BaseUrl");			 //getting BaseURL
	}
	
	public String EdgegetBaseUrl()
	{
		return properties.getProperty("EdgeBaseUrl");
	}
	
	
	public String getEdgeKey()
	{
		return properties.getProperty("Edgekey");		 //getting Edge key
	}
	
	public String getEdgePath()
	{
		return properties.getProperty("EdgePath");		 //getting Edge Key
	}

	

}
