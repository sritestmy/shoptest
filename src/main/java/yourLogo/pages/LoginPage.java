package yourLogo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds objects and methods to work with login page
 * @author Saranya Sasidharan
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "email_create")
	private WebElement createEmail;
	@FindBy(name = "SubmitCreate")
	private WebElement createAcc;
	@FindBy(id = "email")
	private WebElement emailId;
	@FindBy(id = "passwd")
	private WebElement pwd;
	@FindBy(id = "SubmitLogin")
	private WebElement logIn;
	@FindAll(@FindBy(xpath = "//div[@id='create_account_error']/ol/li"))
	private List<WebElement> createAccErr;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acc_email(String email_id) {
		createEmail.sendKeys(email_id);
	}
	
	public void create_acc() {
		createAcc.click();
	}
	
	public void enter_email(String email_id) {
		emailId.sendKeys(email_id);
	}
	
	public void enter_password(String password) {
		pwd.sendKeys(password);
	}
	
	public void Log_In() {
		logIn.click();
	}
	
	/**
	 * Check error message is displayed or not
	 * @return boolean
	 */
	public boolean get_emailError() {
		try {
			System.out.println(createAccErr.get(0).getText());
			return true;
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("No error");
			return false;
		}
	}
	
	/**
	 * Clicking on create an account navigates to registration page
	 * @param email_id
	 * @return registration page object
	 */
	public RegistrationPage create_account(String email_id) {
		acc_email(email_id);
		create_acc();
		if(get_emailError()) {
			return null;
		}
		else{
			RegistrationPage register = new RegistrationPage(driver);
			return register;
		}
		
	}
	
	public void Login_account(String email_id, String password) {
		enter_email(email_id);
		enter_password(password);
		Log_In();
	}
	
	
}
