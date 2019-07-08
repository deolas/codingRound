package testvagrant.codingRound.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testvagrant.codingRound.base.Setup;


public class HotelPage extends Setup{

	public HotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    public void navigateToHotelPage(){
    	click(hotelLink);
    }
    
    public void enterLocation(String location){
    	sendKeys(localityTextBox, location);
    }
    
    public void selectTravellers(String travellersDetails){
    	selectDropDownValue(travellerSelection, travellersDetails);
    }
    
    public void clickSearch(){
    	click(searchButton);
    }

}
