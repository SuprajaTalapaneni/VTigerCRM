package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateContactTest extends BaseClass {
	@Test
	public void createNewContactTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(), "Contacts");
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String, String> map = excel.readFromExcel("Create Contact", "ContactsTestData");
		String lastName = map.get("Last Name") + jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newContact.getPageHeader().contains(lastName));
		newContact.clickContactsLink();
		if (contact.getNewContactName().equals(lastName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Contact", "pass", IConstantPath.EXCEL_PATH, "ContactsTestData");
		} else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Contact", "Fail", IConstantPath.EXCEL_PATH, "ContactsTestData");
		}
		soft.assertAll();
	}
}
