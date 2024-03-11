package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class CreateNewContactPage {

	// Declaration
	@FindBy(xpath = "//span[text()='Creating New Contact']")
	private WebElement pageHeader;

	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//img[contains(@onclick,'Accounts')]")
	private WebElement orgPlusButton;

	@FindBy(xpath = "(//input[normalize-space(@value)='Save'])[2]")
	private WebElement saveButton;
	
	private String orgPath = "//input[@name='search_text']";
	//a[text()='%s']
	
	// Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setLastName(String contactName) {
		lastNameTF.sendKeys(contactName);
	}

	public void selectExistingOrg(WebDriverUtility web, String orgName) {
		orgPlusButton.click();
		String parentID=web.getParentWindow();
		web.switchToChildBrowser();
		web.convertPathToWebElement(orgPath, orgName).click();
		web.switchToWindow(parentID);
	}

	public void clickSave() {
		saveButton.click();
	}
}
