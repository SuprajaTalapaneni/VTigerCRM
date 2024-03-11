package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class HomePage {
	// Declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()='Leads' and contains(@href,'Leads&action')]")
	private WebElement leadsTab;

	@FindBy(xpath = "//a[text()='Organizations' and contains(@href,'Accounts&action')]")
	private WebElement organizationsTab;

	@FindBy(xpath = "//a[text()='Contacts' and contains(@href,'Contacts&action')]")
	private WebElement contactsTab;

	@FindBy(id = "qccombo")
	private WebElement quickCreateDropdown;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickOrganizations() {
		organizationsTab.click();
	}

	public void clickContacts() {
		contactsTab.click();
	}

	public void clickLeads() {
		leadsTab.click();
	}

	public void selectFromQuickCreate(WebDriverUtility web, String value) {
		web.selectFromDropdown(quickCreateDropdown, value);
	}

	public void signOutOfApp(WebDriverUtility web) {
		web.mouseHoverToElement(adminIcon);
		signOutLink.click();
	}
}
