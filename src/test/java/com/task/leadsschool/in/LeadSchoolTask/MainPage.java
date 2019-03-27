package com.task.leadsschool.in.LeadSchoolTask;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class MainPage {
	WebDriver driver;
	public MainPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]//parent::a//descendant::span[@class='nav-icon nav-arrow']")
	public WebElement sign_in_area;
	@FindBy(xpath="//a[@rel='nofollow']//descendant::span[contains(text(),'Sign in')]")
	public WebElement sign_in_button;
	@FindBy(xpath="//ol[@class='a-carousel']/li")
	public List<WebElement> all_banners;
	@FindBy(xpath="//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative']")
	public WebElement pincode_change;
	@FindBy(id="GLUXChangePostalCodeLink")
	public WebElement change_button;
	@FindBy(id="GLUXZipUpdateInput")
	public WebElement change_pin_field;
	@FindBy(xpath="//span[@id='GLUXZipUpdate']")
	public WebElement applybutton;
	@FindBy(xpath="//button[contains(text(),'Done')]")
	public WebElement done_button;
	@FindBy(xpath="//span[@id='glow-ingress-line2']")
	public WebElement pin_code_value;
	
	public SignInPage sign_in_to_the_application() throws Exception{
		Actions ac=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(sign_in_area));
		ac.moveToElement(sign_in_area).build().perform();
		sign_in_button.click();
		
		return PageFactory.initElements(driver, SignInPage.class);
		
		
	}
	
	public void number_of_banners(){
		System.out.println(all_banners.size());
	}
	
	public void change_pin_code(String newpin) throws Exception{
		pincode_change.click();
		change_button.click();
		change_pin_field.clear();
		change_pin_field.sendKeys(newpin);
		ClickOnApply cl=new ClickOnApply();
		cl.click();
		
		Thread.sleep(2000);

		done_button.click();
	}

}
