package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage {

	@FindBy(xpath = "//ul[@class='product_list grid row']/li[1]")
	private WebElement first_element;
	@FindBy(xpath = "//a[@title='View']")
	private WebElement more;
	@FindBy(xpath = "//a[@class='addToWishlist wishlistProd_1']")
	private WebElement wishlist;
	@FindBy(xpath = "//p[@class='fancybox-error']")
	private WebElement wishlishtError;
	@FindBy(xpath = "//ul[@class='product_list grid row']/li/div/div/h5/a[@class='product-name']")
	private WebElement productName;
	
	WebDriver driver;
	Actions action;
	
	
	public ProductCategoryPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	public void clickMore() {
		
		action.moveToElement(first_element).moveToElement(more).click().perform();
	}
	
	public String getProductName() {
		return productName.getAttribute("title");
	}
	
	/*
	 * Add first element displayed to wish list
	 */
	public String addToWishlist() throws InterruptedException {
		action.moveToElement(first_element).moveToElement(wishlist).click().perform();
		Thread.sleep(500);
		if(wishlishtError.isDisplayed())
		{
			return wishlishtError.getText();
		}
		else
			return "No error";
	}
}
