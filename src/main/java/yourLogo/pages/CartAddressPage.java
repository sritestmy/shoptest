package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work in checkout address page
 * @author Saranya Sasidharan
 *
 */
public class CartAddressPage {

	@FindBy(xpath = "//button[@type = 'submit']/span[contains(text(), 'Proceed')]")
	private WebElement checkout;
	
	WebDriver driver;
	
	public CartAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void proceedToCheck() {
		checkout.click();
	}
}
