package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// Declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement pageHeader;

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement plusButton;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td[4]/a")
	private WebElement newContactLink;

	// Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickPlusButton() {
		plusButton.click();

	}

	public String getNewContactName() {
		return newContactLink.getText();
	}
}
