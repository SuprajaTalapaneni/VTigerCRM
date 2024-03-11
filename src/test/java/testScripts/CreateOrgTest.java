package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrgTest() throws InterruptedException {
		SoftAssert soft= new SoftAssert();
		home.clickOrganizations();
		soft.assertEquals(org.getPageHeader(), "Organizations");
		org.clickPlusButton();
		soft.assertEquals(createOrg.getPageHeader(), "Creating New Organization");
		Map<String, String> map = excel.readFromExcel("Create Organization", "OrganizationsTestData");
		String orgName = map.get("Organization Name") + jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newOrg.getPageHeader().contains(orgName));
		newOrg.clickOrgLink();
		if (org.getNewOrgName().equals(orgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization", "Pass", IConstantPath.EXCEL_PATH, "OrganizationsTestData");
		} else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Organization", "Fail", IConstantPath.EXCEL_PATH, "OrganizationsTestData");
		}
		soft.assertEquals(org.getNewOrgName(), orgName);
		soft.assertAll();
	}

}
