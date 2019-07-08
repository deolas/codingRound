package testvagrant.codingRound.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Setup extends TestBase {

	@BeforeClass
	public void assignDriver() {
		initDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("baseURL"));
	}

	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
