package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public String baseURL = "http://www.google.com";
	public static WebDriver driver;

	public BaseClass() {
		initialSetUp();
	}

	public void initialSetUp() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

			driver.get(baseURL);
		}
	}
	
	public void tearDown() {
		driver.quit();
	}
}
