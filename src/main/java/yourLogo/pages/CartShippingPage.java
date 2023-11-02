package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work in checkout shipment page
 * @author Saranya Sasidharan
 *
 */
public class CartShippingPage {

	@FindBy(xpath = "//button[@type = 'submit']/span[contains(text(), 'Proceed')]")
	private WebElement checkout;
	@FindBy(id = "cgv")
	private WebElement terms;
	
	WebDriver driver;
	
	public CartShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void acceptTerms() {
		if(!terms.isSelected()) {
			terms.click();
		}
	}
	
	
	public void proceedToCheck() {
		checkout.click();
	}
	
	public void proceedShipping() {
		acceptTerms();
		proceedToCheck();
	}
}
