package testvagrant.codingRound.testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;

import testvagrant.codingRound.base.Setup;
import testvagrant.codingRound.pageobject.FlightPage;

public class FlightBookingTest extends Setup{

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

    	FlightPage fltpage = new FlightPage();
    	fltpage.clickOneWay();
		
		fltpage.enterFrom(config.getProperty("fromcity"));
		fltpage.enterTo(config.getProperty("tocity"));

		//Passing 7 days future date
		String onDate = calPastFutureDate("dd/MM/yyyy", 7);
		fltpage.setOnDate(onDate);
		fltpage.clickSearchButton();
		boolean flagSummaryAvailable = fltpage.isSearchSummaryPresent();
		Assert.assertTrue(flagSummaryAvailable, "Search Summary is not available");
    }
}
