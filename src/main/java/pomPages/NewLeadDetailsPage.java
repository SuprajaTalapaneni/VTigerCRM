package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeadDetailsPage {
	// Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement leadsLink;
	
	@FindBy(name="Duplicate")
	private WebElement duplicateButton;

	// Initialization
	public NewLeadDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickLeadsLink() {
		leadsLink.click();
	}
	
	public void clickDuplicate() {
		duplicateButton.click();
	}
}
