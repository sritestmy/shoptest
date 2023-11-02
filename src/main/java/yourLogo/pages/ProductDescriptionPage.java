package yourLogo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage {

	@FindBy(id = "quantity_wanted")
	private WebElement quantity;
	@FindBy(id = "group_1")
	private WebElement selectSize;
	@FindAll(@FindBy(xpath = "//ul[@id='color_to_pick_list']/li/a"))
	private List<WebElement> color;
	@FindBy(name = "Submit")
	private WebElement addToCart;
	@FindBy(linkText = "Proceed to checkout")
	private WebElement checkout;
	
	WebDriver driver;
	
	public ProductDescriptionPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void changeQuantity(String userQuantity) {
		quantity.clear();
		quantity.sendKeys(userQuantity);
	}
	
	public void chooseSize(String size) {
		Select sel = new Select(selectSize);
		sel.selectByVisibleText(size);
	}
	
	public void chooseColor(String Usercolor) {
		
		for(WebElement e: color) {
			String temp = e.getAttribute("name");
			if(temp.equalsIgnoreCase(Usercolor)) {
				e.click();
				break;
			}
		}
	}
	
	public void submit() {
		addToCart.click();
	}
	
	public void proceedToCheckout() {
		try {
		if(checkout.isEnabled()) {
			checkout.click();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepareCart(String quant, String size, String colour) {
		changeQuantity(quant);
		chooseSize(size);
		chooseColor(colour);
		submit();
		proceedToCheckout();
	}
	
	
}
