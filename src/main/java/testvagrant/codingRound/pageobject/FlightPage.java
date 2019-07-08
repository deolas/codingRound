package testvagrant.codingRound.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testvagrant.codingRound.base.Setup;


public class FlightPage extends Setup {

	public FlightPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "OneWay")
    private WebElement radioOneWay;

    @FindBy(id = "FromTag")
    private WebElement txtBoxFrom;
    
    @FindBy(id = "ToTag")
    private WebElement txtBoxTo;
    
    @FindBy(css = "#ui-id-1>li") 
    private WebElement dropDownFromCity;
    
    @FindBy(css = "#ui-id-1>li") 
    private List<WebElement> optionsFromCity;
    
    @FindBy(css = "#ui-id-2>li") 
    private WebElement dropDownToCity;
    
    @FindBy(css = "#ui-id-2>li") 
    private List<WebElement> optionsToCity;
    
    @FindBy(css = "input#DepartDate") 
    private WebElement departOnDate;
    
    @FindBy(id = "SearchBtn")
    private WebElement btnSearch;
    
    @FindBy(className = "searchSummary")
    private WebElement searchSummary;
    
	public void clickOneWay() {
		click(radioOneWay);
	}
    
    public void enterFrom(String fromCity){
    	clear(txtBoxFrom);
    	sendKeys(txtBoxFrom, fromCity);
    	waitForElementVisibility(10, dropDownFromCity);
    	click(optionsFromCity.get(0));
    }
    
    public void enterTo(String toCity){
    	clear(txtBoxTo);
    	sendKeys(txtBoxTo, toCity);
    	waitForElementVisibility(10, dropDownToCity);
    	click(optionsToCity.get(0));
    }
    
    public void setOnDate(String onDate){
    	sendKeys(departOnDate, onDate);
    }
    
    public void clickSearchButton(){
    	click(btnSearch);
    }
    
    public boolean isSearchSummaryPresent(){
    	return isDisplayed(searchSummary);
    }
    
}