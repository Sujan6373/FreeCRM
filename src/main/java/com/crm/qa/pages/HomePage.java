package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//*[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[@href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[@href='/tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement newContact;
	
	//Initializing the Page Objects:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUserNameLabel()
	{
		return userNameLabel.getText();		
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		newContact.click();
	}

}
