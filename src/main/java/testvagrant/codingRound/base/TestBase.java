package testvagrant.codingRound.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.PlatformUtil;

public abstract class TestBase {
	public static Properties config = null;
	private static boolean isInitalized = false;
	protected static WebDriver driver = null;
	protected WebDriverWait wait = null;

	protected TestBase() {
		if (!isInitalized) {
			initConfig();

			isInitalized = true;
		}
	}

	private static void initConfig() {
		if (config == null) {
			try {

				// initialize config properties file
				config = new Properties();
				String config_fileName = "config.properties";
				String config_path = System.getProperty("user.dir") + File.separator + "config" + File.separator
						+ config_fileName;
				FileInputStream config_ip = new FileInputStream(config_path);
				config.load(config_ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Initialize Driver.
	 */
	protected void initDriver() {

		if (config.getProperty("browser").equalsIgnoreCase("CHROME")) {
			if (PlatformUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
			} else if (PlatformUtil.isWindows()) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromedriver.exe");
			} else if (PlatformUtil.isLinux()) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromedriver_linux");
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().setPosition(new Point(0, 0));
	}

	protected String getText(WebElement webElement) {
		waitForElementVisibility(5, webElement);
		return webElement.getText();
	}

	protected void waitForElementPresence(int timeout, By by) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void waitForElementVisibility(int timeout, WebElement wbElemnt) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(wbElemnt));
	}

	protected boolean isDisplayed(WebElement webElement) {
		try {
			return webElement.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected void clear(WebElement webElement) {
		webElement.clear();
	}

	protected void click(WebElement element) {
		waitForElementVisibility(3, element);
		element.click();
	}

	protected void sendKeys(WebElement webElement, String keysToSend) {
		waitForElementVisibility(3, webElement);
		webElement.sendKeys(keysToSend);
	}

	public void selectDropDownValue(WebElement webElement, String value) {
		new Select(webElement).selectByVisibleText(value);
	}

	public void switchToFrame(WebElement frameId) {
		driver.switchTo().frame(frameId);
	}

	public static String calPastFutureDate(String format, int noOfDays) {

		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(sdf.format(date)));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, noOfDays);
		// Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days
		return newDate;
	}

}
