package stepsDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalPage;
import resources.base;

public class MyStepDefinitions extends base{

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
		
	}
	
	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);
	}



	@Given("^Click on Login button in home page to land on Secure sign in page$")
	public void click_on_Login_button_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
		LandingPage landPg = new LandingPage(driver);
		if(landPg.getPopUpSize() > 0) 
		{
		
			landPg.getPopUp().click();
		}
		landPg.getLogin().click();
		
	}

	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPage lognPg = new LoginPage(driver);
			lognPg.getEmail().sendKeys(username);
			lognPg.getPassword().sendKeys(password);
			lognPg.logInBtn().click();
	    }
	 
	@Then("^Verify that user is sucessfully logged in$")
	public void verify_that_user_is_sucessfully_logged_in() throws Throwable {
		portalPage pp = new portalPage(driver);
		Assert.assertTrue(pp.courseSearchBar().isDisplayed());
		
	}
	

    @And("^Close all the Browsers$")
    public void close_all_the_browsers() throws Throwable {
        driver.quit();
    }


}

