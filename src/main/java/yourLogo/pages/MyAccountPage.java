package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work with account page
 * @author Saranya Sasidharan
 *
 */
public class MyAccountPage {
	
	@FindBy(linkText = "Home")
	private WebElement home;
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void returnHOme() {
		home.click();
	}

}
