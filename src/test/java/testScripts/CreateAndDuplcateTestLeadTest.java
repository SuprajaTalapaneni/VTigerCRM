package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateAndDuplcateTestLeadTest extends BaseClass {
	@Test
	public void CreateAndDuplcateTestLeadTest() throws InterruptedException {
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(), "Leads");
		Thread.sleep(3000);
		lead.clickPlusButton();
		Thread.sleep(3000);
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		
		Map<String, String> map = excel.readFromExcel("Create and Duplicate Lead", "LeadsTestData");
		String leadName = map.get("Last Name") + jutil.generateRandomNum(100);
		String companyName=map.get("Comapany");
		createLead.setLastName(leadName);
		createLead.setCompany(companyName);
		createLead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(leadName));
		
		newLead.clickDuplicate();
		soft.assertTrue(duplicateLead.getPageHeader().contains("Duplicating"));
		String newLastName = map.get("New last Name") + jutil.generateRandomNum(100);
		duplicateLead.setNewLastName(newLastName);
		duplicateLead.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(newLastName));
		newLead.clickLeadsLink();
		
		if (lead.getNewLeadName().equals(newLastName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create and Duplicate Lead", "pass", IConstantPath.EXCEL_PATH, "LeadsTestData");
		} else {
			System.out.println("test fail");
			excel.updateTestStatus("Create and Duplicate Lead", "Fail", IConstantPath.EXCEL_PATH, "LeadsTestData");
		}
		Thread.sleep(3000);
		soft.assertTrue(lead.getNewLeadName().contains(newLastName));
		soft.assertAll();
	}

}
