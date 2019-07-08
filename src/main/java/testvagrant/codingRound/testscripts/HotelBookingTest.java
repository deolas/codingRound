package testvagrant.codingRound.testscripts;
import org.testng.annotations.Test;

import testvagrant.codingRound.base.Setup;
import testvagrant.codingRound.pageobject.HotelPage;

public class HotelBookingTest extends Setup{
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	HotelPage hotels = new HotelPage();
		hotels.navigateToHotelPage();
		hotels.enterLocation(config.getProperty("hotel_location"));
		hotels.clickSearch();
    }
}
