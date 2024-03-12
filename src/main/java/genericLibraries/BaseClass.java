package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pomPages.ContactsPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.LoginPage;
import pomPages.NewContactsDetailsPage;
import pomPages.NewEventDetailsPage;
import pomPages.NewLeadDetailsPage;
import pomPages.NewOrgDetailsPage;
import pomPages.OrganizationsPage;
//This is base class
public class BaseClass {

	// @BeforeSuite
	// @BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;

	protected WebDriver driver;
    protected SoftAssert soft;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contact;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewLeadPage createLead;
	protected CreateNewEventPage createEvent;
	protected DuplicatingLeadPage duplicateLead;
	protected NewOrgDetailsPage newOrg;
	protected NewContactsDetailsPage newContact;
	protected NewLeadDetailsPage newLead;
	protected NewEventDetailsPage newEvent;

	@BeforeClass
	public void classSetup() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();

		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		driver = web.launchBrowser(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));

	}

	@BeforeMethod
	public void methodSetup() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		org = new OrganizationsPage(driver);
		contact = new ContactsPage(driver);
		lead = new LeadsPage(driver);
		createOrg = new CreateNewOrganizationPage(driver);
		createContact = new CreateNewContactPage(driver);
		createLead = new CreateNewLeadPage(driver);
		createEvent = new CreateNewEventPage(driver);
		newOrg = new NewOrgDetailsPage(driver);
		newContact = new NewContactsDetailsPage(driver);
		newLead = new NewLeadDetailsPage(driver);
		newEvent = new NewEventDetailsPage(driver);
		duplicateLead = new DuplicatingLeadPage(driver);
        soft=new SoftAssert();
		excel.excelInit(IConstantPath.EXCEL_PATH);
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(),"vtiger" );
		login.loginVtiger(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertTrue(home.getPageHeader().contains("Home"));
	}

	@AfterMethod
	public void methodTeardown() {
		home.signOutOfApp(web);
		excel.closeExcel();
	}
	@AfterClass
	public void classTeardown() {
		web.quitAllWindows();

	}
	// @AfterTest
	// @AfterSuite

}
