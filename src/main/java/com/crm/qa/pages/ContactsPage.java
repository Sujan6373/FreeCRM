package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[(text()='Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//td[text()='Sarah Feng']//parent::tr//td//div//input[@name='id']")
	WebElement userLabel;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr//td//div//input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String fName, String lName) throws InterruptedException
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		//company.sendKeys(compName);
		saveBtn.click();
		Thread.sleep(3000);
	}
}
