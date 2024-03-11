package mvnPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mavenParameterization {
	@Test
	public void loginTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		
		Long time=Long.parseLong(System.getProperty("time"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
		String user=System.getProperty("un");
		String pwd=System.getProperty("pwd");
		
		driver.findElement(By.id("email")).sendKeys(user+Keys.TAB+pwd+Keys.ENTER);
		Thread.sleep(4000);
		driver.close();
	}
}
