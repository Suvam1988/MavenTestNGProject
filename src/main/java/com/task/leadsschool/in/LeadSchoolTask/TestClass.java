package com.task.leadsschool.in.LeadSchoolTask;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestClass {
	public  WebDriver driver;
	
	
	
	SetUp setup=new SetUp(driver);
	MainPage mainpage;
	SignInPage signin;
	
	@BeforeMethod
	
	public void launchBrowserAndNavigation() throws Exception{
		driver=setup.setUpMethod();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	@Test(priority=0)
	public void test_SigninLinkIsWorking() throws Exception{
		mainpage=PageFactory.initElements(driver, MainPage.class);
		signin=mainpage.sign_in_to_the_application();
		Assert.assertTrue(driver.getTitle().equals("Amazon Sign In"));
		mainpage=signin.navigate_to_mainpage();
		
		
	}
	
	@Test(priority=1)
	public void count_number_of_banners(){
		mainpage=PageFactory.initElements(driver, MainPage.class);
		mainpage.number_of_banners();
	}
	
	@Test(priority=2)
	
	public void login_flow_with_correct_details() throws Exception{
		mainpage=PageFactory.initElements(driver, MainPage.class);
		signin=mainpage.sign_in_to_the_application();
		
		mainpage=signin.log_in("UserName", "Password");
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.in/?ref_=nav_signin&"));
	}
	
	@Test(priority=3)
	public void change_to_new_pin_code() throws Exception{
		mainpage=PageFactory.initElements(driver, MainPage.class);
		mainpage.change_pin_code(ReadData.ReadDataSource("NewPin"));
		Thread.sleep(2000);
		System.out.println(mainpage.pin_code_value.getText());
		
		Assert.assertTrue(mainpage.pin_code_value.getText().contains(ReadData.ReadDataSource("NewPin")));
	}
 
	

}
