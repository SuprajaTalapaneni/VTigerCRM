package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateContactWithExistingOrgTest extends BaseClass {
	@Test

	public void createContactWithOrgTest() throws InterruptedException {
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(), "Contacts");
		Thread.sleep(3000);
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String, String> map = excel.readFromExcel("Create Contact With Organization", "ContactsTestData");
		String contactName = map.get("Last Name") + jutil.generateRandomNum(100);
		createContact.setLastName(contactName);
		createContact.selectExistingOrg(web, map.get("Organzation Name"));
		createContact.clickSave();
		soft.assertTrue(newContact.getPageHeader().contains(contactName));
		Thread.sleep(3000);
		newContact.clickContactsLink();

		if (contact.getNewContactName().equals(contactName)) {
			System.out.println("Test pass");
			excel.updateTestStatus("Create Contact With Organization", "pass", IConstantPath.EXCEL_PATH,
					"ContactsTestData");
		} else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create Contact With Organization", "fail", IConstantPath.EXCEL_PATH,
					"ContactsTestData");
		}
		soft.assertTrue(contact.getNewContactName().contains(contactName));
		soft.assertAll();
	}

}
