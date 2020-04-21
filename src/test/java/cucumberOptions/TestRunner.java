package cucumberOptions;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Nischal\\Desktop\\Cucumber Automation\\FrameworkProject\\src\\test\\java\\features",
		glue = "stepsDefinitions",
		strict = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
