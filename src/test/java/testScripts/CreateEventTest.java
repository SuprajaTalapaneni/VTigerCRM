package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateEventTest extends BaseClass {
	@Test
	public void CreateEventTest() throws InterruptedException {
		Map<String, String> map = excel.readFromExcel("Create New Event", "EventsTestData");
		home.selectFromQuickCreate(web, map.get("Quick Create"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject = map.get("Subject") + jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.setStartDate(map.get("Start Date"));
		createEvent.setEndDate(map.get("Due Date"));
		Thread.sleep(3000);
		createEvent.clickSave();
		soft.assertTrue(newEvent.getPageHeader().contains(subject));
		Thread.sleep(3000);
		if (newEvent.getPageHeader().contains(subject)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create New Event", "Pass", IConstantPath.EXCEL_PATH, "EventsTestData");
		} else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create New Event", "Fail", IConstantPath.EXCEL_PATH, "EventsTestData");
		}
		soft.assertAll();
	}

}
