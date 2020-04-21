package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

import resources.base;

public class HomePage extends base {
	LoginPage lognPg;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to the Homepage");

		LandingPage landPg = new LandingPage(driver);
		landPg.getLogin().click();
		log.info("Clicked the Homepage Login Button");

		
		
		 lognPg = new LoginPage(driver);
		
		lognPg.getEmail().sendKeys(Username);
		log.info("Entered the Username");

		lognPg.getPassword().sendKeys(Password);
		log.info("Entered the Password");

		lognPg.logInBtn().click();
		log.info("Clicked the Signin Button");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null; // After our test execution is completed set driver = null to avoid unnecessary
						// wastage of the memory
	}

	// Method to supply data for a test method.The annotates method must retrun an
	// object[][] where each object[]
	// can be assigned the parameter list of the test method.
	@DataProvider(name = "getData")
	public Object[][] getData() {
		// Row stands for how many different data tyes test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][2];

		// 0th row

		data[0][0] = "nonrestricteduser@qw.com";

		data[0][1] = "123456";

		// 1st row

		data[1][0] = "aryan@qw.com";

		data[1][1] = "456788";

		return data;
	}

}
