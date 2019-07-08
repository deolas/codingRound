# TestVagrant hiring challenge for applicants 

Tasks: 1) Test are failing which needs your expertise to fix it.:
---------------------------------
Fixes: I have fixed these test scripts for Ubuntu OS.

**FlightBookingTest**: 
	
	1) Updated compatible chromedriver_linux driver for chrome 74 version.
	2) On line 15, ChromeDriver instance is created without setting system property for chromedriver.
	   This instance should be created after setting system property.
	3) On line 35, element id is incorrect for "To" textbax. Id should be "ToTag" instead of "toTag".
	4) On lines 23,31,40,50, waitFor function using Thread.sleep to wait. We should use implicit 
	   or explicit wait to wait for element visibility.

**HotelBookingTest**

	1) Updated compatible chromedriver_linux for chrome 74 version.
	2) On line 11, ChromeDriver instance is created without setting system property for chromedriver.
	   This instance should be created after setting system property.
	3) Locators aren't instantiated, we need to initialise the PageObject.
	
**SignInTest**:

	1) On line 10, ChromeDriver instance is created without setting system property for chromedriver. 
	   This instance should be created after setting system property.
	2) On line 23, to access signInButton element, we need to switch the frame as this element is 
	   available in frame.

Task 2) Review and point out design issues with the current codebase/framework, if any.
----------------------------------
In given project, there is no proper framework in place. I have below suggestions.

	1) In given project, locators are placed in test script. In this case if any element locator get change, 
      we have to change in each test script. To avoid this, we have to create page object for each screen with all 
      element locators and methods. This will reduce the maintainance effort. 
	2) We can define actions that can be performed on page as methods in page object classes and these methods are called 
      from test scripts classes as and when needed. So in this way we can reuse the code and it provides abstraction 
      as test classes need to know only the methods name and not the implementation of methods.
	3) Waitfor(), isElementPresent(), setDriverPath() are common function used in all scripts. We can have base class 
      that will have all the common actions that might be require to perform on all the page object classes such as 
      clicking on button, entering any verifying the title, verifying the presence of an element, waiting for elemnet 
      to be visible etc. Classes that need to use these methods, have to extend this Base class. In this way we can 
      acquires the property of the base class and this reduce the code duplicacy.
	4) In given project, test scripts are having some common steps like launching browser, opening application, 
      closing browser etc. We can use TestNG annotations like @BeforeClass, @BeforeMethod, @AfterClass etc to remove 
      duplicacy of these common steps.
	5) In scripts, there were some hard code values like application URL, FromCity, ToCity etc. We should pass these 
      values from properties file or from database. So in the future if there is any change we should have to just 
      change in properties/database and we dont have to change in any scripts class.
	6) In given projects, waitFor is using Thread.sleep to stop the execution when any element is taking time to 
      appear/visible on screen. Instead-of using hard sleep, we should use implicit/explicit wait.
	7) We should use testng.xml file to run multiple classes at a time instead-of using single class at a time.
	8) All browser drivers need to be in one folder.
	9) We should have TestNG listeners to customize the report,create the logs, rerun if any test scripts get fails etc. 
      This helps us to find out/debug any failures with accuracy. 

Task 3) Improve/refactor the code to implement your suggestions.
----------------------------------

I have refactored the code by placing Page Object Model Framework using Maven,TestNG, Java. Below are specification of this framework.

1) It has 3 packages
 	> base : This package has classes related to common methods, listeners, setup.
  
	> pageobjects : All page objects are kept here.
  
	> testscripts : All test scripts are kept here.
2) Created a driver folder to keep all browsers driver.
3) config folder is having property file that has values for test scripts.
4) test_suites folder is having testng xmls to run the test classes.
