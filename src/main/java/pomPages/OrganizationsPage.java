package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	// declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusButton;
	
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement newOrgLink;

	// Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickPlusButton() {
		plusButton.click();
	}

	public String getNewOrgName() {
		return newOrgLink.getText();
	}
}
