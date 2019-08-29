package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	String sheetName = "Contacts";
	
	//testcases should be separated -- independent to avoid dependency
	//before each test case -- launch the browser and login
	//@Test -- execute test cases
	//after each test case -- close the browser
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		contactPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test (priority = 2)
	public void selectContactsByNameTest() throws InterruptedException
	{
		contactPage.selectContactsByName("Sarah Feng");
		Thread.sleep(10000);
	}
	
	@DataProvider
	public Object [][] getCRMTestData()
	{
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 3, dataProvider = "getCRMTestData")
	public void createNewContactTest(String fName, String lName) throws InterruptedException
	{
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
		contactPage.createNewContact(fName, lName);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
