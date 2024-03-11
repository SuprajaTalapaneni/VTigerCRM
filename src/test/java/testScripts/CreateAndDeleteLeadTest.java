package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import genericLibraries.BaseClass;

public class CreateAndDeleteLeadTest extends BaseClass {
	@Test
	public void CreateLeadTest() throws InterruptedException {
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(), "Leads");
		Thread.sleep(4000);
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		
		Map<String, String> map = excel.readFromExcel("Delete lead", "LeadsTestData");
		String leadName = map.get("Lead Name") + jutil.generateRandomNum(100);
		createLead.setLastName(leadName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();

		Thread.sleep(4000);
		soft.assertTrue(newLead.getPageHeader().contains(leadName));
		Thread.sleep(4000);
		newLead.clickLeadsLink();
		
		Thread.sleep(4000);
		lead.deleteLead(web, leadName);
		web.handleAlert("OK");
		
		Thread.sleep(4000);
		soft.assertTrue(lead.searchLead(leadName));
		soft.assertAll();
	}
}
