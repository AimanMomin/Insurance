package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;
import com.pom.Login_Page;

public class Login_Test extends Base
{
Login_Page login;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		LaunchTheWeb();
		login=new Login_Page();
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	@Test
	public void LoginWithValidCredential() throws InterruptedException
	{
		
		login.setInputusername(login.getUsername());
		Thread.sleep(2000);
		System.out.println(login.getPassword());
		login.setInputpassword(login.getPassword());
		Thread.sleep(2000);
		login.ClickOnLoginButton();
		Thread.sleep(2000);
		
		String actual = driver.getTitle();
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected); 
	}
	
	public void LoginWithBlanckCredential()
	{
		login.setInputusername(" ");
		login.setInputpassword(" ");
		login.ClickOnLoginButton();
		
		
		
		
		
	}
	
	@Test 
	public void ValidateTitle()
	{
		String actual = driver.getTitle();
		String expected=prop.getProperty("Logintitle");
		
		Assert.assertEquals(actual,expected);
	}

}
