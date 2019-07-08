package testvagrant.codingRound.testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;

import testvagrant.codingRound.base.Setup;
import testvagrant.codingRound.pageobject.SignInPage;

public class SignInTest extends Setup{

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	SignInPage signInPage = new SignInPage();
    	signInPage.navigateToSignInPage();
		signInPage.clickSignInButton();
		String errorText = signInPage.getSignInErrors();
		Assert.assertTrue(errorText.contains("There were errors in your submission"), "There were NOT any errors in your submission");
    }
}
