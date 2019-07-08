package testvagrant.codingRound.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testvagrant.codingRound.base.Setup;

public class SignInPage extends Setup {

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Your trips")
	private WebElement linkYourTrips;

	@FindBy(id = "SignIn")
	private WebElement tabSignIn;

	@FindBy(id = "modal_window")
	private WebElement frameSignInForm;

	@FindBy(id = "email")
	private WebElement txtUserName;
	
	@FindBy(id = "signInButton")
	private WebElement btnSignIn;

    @FindBy(id = "errors1")
    private WebElement errorText;


	public void navigateToSignInPage(){
		click(linkYourTrips);
		click(tabSignIn);
		switchToFrame(frameSignInForm);
		waitForElementVisibility(5, txtUserName);
	}
	
	public void clickSignInButton(){
		click(btnSignIn);
	}

	public String getSignInErrors(){
		return getText(errorText);
	}

}