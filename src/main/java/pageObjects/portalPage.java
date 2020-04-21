package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalPage {

	public WebDriver driver;
	
	private By searchBar = By.name("query");
	
	public portalPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement courseSearchBar()
	{
		return driver.findElement(searchBar);
	}
	
}
