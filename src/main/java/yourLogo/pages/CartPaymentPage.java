package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work in checkout payment page
 * @author Saranya Sasidharan
 *
 */
public class CartPaymentPage {

	@FindBy(partialLinkText = "Pay by check")
	private WebElement checkPayment;
	@FindBy(xpath = "//*[text()='I confirm my order']")
	private WebElement confirm;
	@FindBy(xpath = "//p[@class='alert alert-success']")
	private WebElement message;
	
	WebDriver driver;
	
	public CartPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void payByCheck() {
		checkPayment.click();
	}
	
	public void confirmPayment() {
		confirm.click();
	}
	
	/*
	 * Get the message displayed after confirming order
	 */
	public String checkMessage() {
		String confirmationMsg;
		if (message.isDisplayed())
		{
			confirmationMsg = message.getText();
		}
		else
			confirmationMsg = null;
		return confirmationMsg;
	}
	
	public String completeOrder() {
		payByCheck();
		confirmPayment();
		return checkMessage();
	}
}
