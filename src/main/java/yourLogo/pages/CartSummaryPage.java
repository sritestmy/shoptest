package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Holds objects and methods to work with cart summary page
 * @author Saranya Sasidharan
 *
 */
public class CartSummaryPage {

	@FindBy(linkText = "Proceed to checkout")
	private WebElement checkout;
	@FindBy(xpath = "//i[@class='icon-plus']")
	private WebElement quantity;
	@FindBy(xpath = "//tr[1]/td[@data-title='Unit price']/span[@class = 'price']")
	private WebElement unitPrice;
	@FindBy(id = "total_shipping")
	private WebElement shippingPrice;
	@FindBy(id = "total_tax")
	private WebElement totalTax;
	@FindBy(id = "total_price")
	private WebElement total;
	
	WebDriver driver;
	
	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void proceedToCheck() {
		checkout.click();
	}
	
	//Update quantity before checkout
	public void changeQuantity(String newQuantity) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(quantity));
		element1.click();
	}
	
	public float getUnitPrice() {
		String unit = unitPrice.getText();
		unit = unit.replace("$", "");
		float unit_price = Float.parseFloat(unit);
		return unit_price;
	}
	
	public float getShippingPrice() {
		String shipping = shippingPrice.getText().replace("$", "");
		float ship_price = Float.parseFloat(shipping);
		return ship_price;
	}
	
	public float getTotalTax() {
		String tax = totalTax.getText().replace("$", "");
		float total_tax = Float.parseFloat(tax);
		return total_tax;
	}
	
	public float getTotalPrice() {
		String totalPrice = total.getText().replace("$", "");
		float total_price = Float.parseFloat(totalPrice);
		return total_price;
	}
}
