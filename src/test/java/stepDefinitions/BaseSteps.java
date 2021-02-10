package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageObjectManager;

public class BaseSteps {

	protected PageObjectManager pageObjectManager;
	protected WebDriver driver;

	Logger log = Logger.getLogger(BaseSteps.class.getName());

	/**
	 * 
	 */
	public BaseSteps() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pageObjectManager = new PageObjectManager(driver);
		Runtime.set(driver);
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriverObject() {
		return Runtime.get().getDriver();
	}


}
