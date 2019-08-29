package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath = "//a/span[contains(text(), 'Log In')]")
	WebElement loginBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(), 'Login')][1]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@title='app for freecrm android']")
	WebElement androidLogo;
	
	//Initializing the Page Objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAndroidLogo()
	{
		return androidLogo.isDisplayed();
	}

	public void clickLogin() throws InterruptedException
	{
		loginBtn.click();
		Thread.sleep(3000);
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException

	{	 
		clickLogin();
		email.sendKeys(un); password.sendKeys(pwd);
		submitBtn.click();
		Thread.sleep(4000);
		  
		return new HomePage();
		 
	}
}
