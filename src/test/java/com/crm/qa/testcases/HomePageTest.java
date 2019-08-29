package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	//testcases should be separated -- independent to avoid dependency
	//before each test case -- launch the browser and login
	//@Test -- execute test cases
	//after each test case -- close the browser
	
	public HomePageTest()
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
		
	}
	
	@Test(priority =1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRM", "Home page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameLabelTest()
	{
		String userNameLabel = homePage.verifyUserNameLabel();
		Assert.assertEquals(userNameLabel, "Sujan Shrestha", "Username label not found");
	}
	
	@Test(priority = 3)
	public void clickOnContactsLinkTest() throws InterruptedException
	{
		contactPage = homePage.clickOnContactsLink();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 4)
	public void clickOnDealsLinkTest() throws InterruptedException
	{
		dealsPage = homePage.clickOnDealsLink();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void clickOnTaskLinkTest() throws InterruptedException
	{
		tasksPage = homePage.clickOnTaskLink();
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
