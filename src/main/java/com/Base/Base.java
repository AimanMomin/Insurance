package com.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
FileInputStream fileinputstream;
	
	public static WebDriver driver;
	
	public Properties prop;
	
	public static String projectpath= System.getProperty("user.dir"); 
	
	 public void LaunchTheWeb() throws IOException
	 {
		 fileinputstream = new FileInputStream(".\\src\\main\\resources\\Properties\\config.properties");
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		prop= new Properties();
		 
		 prop.load(fileinputstream);
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get(prop.getProperty("WebUrl"));
		 

}
}