package com.task.leadsschool.in.LeadSchoolTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	 WebDriver driver;
	public SignInPage( WebDriver ldriver){
		this.driver=ldriver;
	}
	@FindBy(name="email")
	public WebElement email_or_phonenumber;
	@FindBy(id="continue")
	public WebElement continue_button;
	@FindBy(name="password")
	public WebElement password_field;
	@FindBy(id="signInSubmit")
	public WebElement login_button;
	

	public  MainPage navigate_to_mainpage(){
		driver.navigate().back();
		
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public MainPage log_in(String username, String password) throws Exception{
		
		email_or_phonenumber.sendKeys(ReadData.ReadDataSource(username));
		continue_button.click();
		password_field.sendKeys(ReadData.ReadDataSource(password));
		login_button.click();
		
		return PageFactory.initElements(driver, MainPage.class);
		
	}
	
 
	
}
