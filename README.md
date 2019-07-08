# TestVagrant hiring challenge for applicants 

Tasks: 1) Test are failing which needs your expertise to fix it.:
---------------------------------
*Fixes: I have fixed these test scripts for Ubuntu OS.

**FlightBookingTest**: 
	1) Updated compatible chromedriver_linux driver for chrome 74 version.
	2) On line 15, ChromeDriver instance is created without setting system property for chromedriver. This instance should be created after setting system property.
	3) On line 35, element id is incorrect for "To" textbax. Id should be "ToTag" instead of "toTag".
	4) On lines 23,31,40,50, waitFor function using Thread.sleep to wait. We should use implicit or explicit wait to wait for element visibility.

**HotelBookingTest**
	1) Updated compatible chromedriver_linux for chrome 74 version.
	2) On line 11, ChromeDriver instance is created without setting system property for chromedriver. This instance should be created after setting system property.
	3) Locators aren't instantiated, we need to initialise the PageObject.
	
**SignInTest**:
	1) On line 10, ChromeDriver instance is created without setting system property for chromedriver. This instance should be created after setting system property.
	2) On line 23, to access signInButton element, we need to switch the frame as this element is available in frame.*

**Tech Stack:** *Java*  *Selenium* *TestNG*  *Gradle/Maven*

**The parameters of evaluation**
----------------------------------
1. Naming Conventions & readability of code
2. Modularization & Abstraction
3. Demonstration of OO concepts & Design Patterns
4. Etiquette of Version control

Problem Statemen
----------------------------------
**Tasks:**

1. Test are failing which needs your expertise to fix it.
2. Review and point out design issues with the current codebase/framework, if any.
3. Improve/refactor the code to implement your suggestions.

**Expectation:**
1. Create a GitHub account if not existing already.
2. Fork this repo (DO NOT CLONE).
3. Fix the errors and refactor the code, consider **abstractions, reusability and maintenance.**
4. Make sure you make multiple check-ins in the process, we would love to see your progress bit by bit.
5. Also check-in a separate file where you should list all your code review comments.
6. Send us the link of your GitHub repo to **careers@testvagrant.com**. Also attach your **resume**.
