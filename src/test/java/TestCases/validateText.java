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

public class validateText extends base {
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
	public void validateText() {
	 lp = new LandingPage(driver);
		// compare the text from the browser with the actual text
		System.out.println(lp.getText().getText());
		log.info("Successfully extracted the text from the Homepage");

		Assert.assertEquals(lp.getText().getText(), "Featured Courses");
		log.info("Successfully validated text");

	}
	
	@Test
	public void validateBtn()
	{
		lp = new LandingPage(driver);
		lp.getHeadBtn().click();
		log.info("Successfully clicked the view all courses button");
	
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
