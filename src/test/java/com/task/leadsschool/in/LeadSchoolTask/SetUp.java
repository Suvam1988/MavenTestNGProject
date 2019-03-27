package com.task.leadsschool.in.LeadSchoolTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
	
	  WebDriver driver;
		public SetUp( WebDriver ldriver){
			this.driver=ldriver;
		}
		
		public  WebDriver setUpMethod() throws Exception{
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ReadData.ReadDataSource("URL"));
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		}

}
