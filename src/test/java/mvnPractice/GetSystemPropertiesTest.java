package mvnPractice;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetSystemPropertiesTest {
	@Test
	public void demo() {
		System.getProperties().list(System.out);
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver rdriver = new ChromeDriver();
		
		Capabilities cap = rdriver.getCapabilities();
		System.out.println(cap.getBrowserName());
		System.out.println(cap.getVersion());
		
		rdriver.close();
	}
}
