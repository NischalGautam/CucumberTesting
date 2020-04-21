package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavLink extends base {
	LandingPage lp;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");

	}

	@Test
	public void validateNavLink() {
		lp = new LandingPage(driver);
		// compare the text from the browser with the actual text
		Assert.assertTrue(lp.getNavLink().isDisplayed());
		log.info("Successfully validated the Navlink button");

	}
	
	

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
