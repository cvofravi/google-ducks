package stepDefinitions;

import org.openqa.selenium.WebDriver;

public class Runtime {
	private WebDriver driver;

	private static ThreadLocal<Runtime> runInstance = new ThreadLocal<Runtime>();

	public Runtime() {

	}

	public Runtime(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the runInstance
	 */
	public static synchronized Runtime get() {
		return runInstance.get();
	}

	public static synchronized void set(WebDriver driver) {
		runInstance.set(new Runtime(driver));
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
