package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	private By signIn = By.xpath("//span[contains(text(),'Login')]");
	private By text = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navLink = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By headBtn = By.xpath("//a[@class='btn btn-primary']");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getText()
	{
		return driver.findElement(text);
	}
	
	public WebElement getNavLink()
	{
		return driver.findElement(navLink);
	}
	
	public WebElement getHeadBtn()
	{
		return driver.findElement(headBtn);
	}
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
}
