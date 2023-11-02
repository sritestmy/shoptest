package yourLogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work with Home page
 * @author Saranya Sasidharan
 *
 */
public class HomePage {
	
	@FindBy(className = "login")
	private WebElement signup;
	@FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li/a[text()='Women']")
	private WebElement Women;
	@FindBy(linkText = "T-shirts")
	private WebElement tShirt;
	@FindBy(id = "block_top_menu")
	private WebElement menu;
	@FindBy(id = "search_query_top")
	private WebElement searchBox;
	@FindBy(name = "submit_search")
	private WebElement searchButton;
	
	WebDriver driver;
	Actions action;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void selectTshirt() {
		action.moveToElement(Women).perform();	
		action.moveToElement(tShirt).click().perform();
	}
	
	public void searchProduct(String searchByName) {
		searchBox.sendKeys(searchByName);
		searchButton.click();
	}
	/**
	 * clicking on sign in action navigates to LogIn page
	 * @return log_in page object
	 */
	public void SignUpButton() {
		signup.click();
	}
}
