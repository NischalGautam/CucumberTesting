package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.portalPage;
import resources.base;

public class validatePortalPage extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");

	}

	@Test
	public void validateCourseBtn() {
		portalPage pp = new portalPage(driver);
		// compare the text from the browser with the actual text
		Assert.assertTrue(pp.courseSearchBar().isDisplayed());
		log.info("Successfully validated the course section ");

	}
	
	

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
