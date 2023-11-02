package yourLogo.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Holds objects and methods to work with registration page
 * @author Saranya Sasidharan
 *
 */
public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy(id = "id_gender1")
	private WebElement male;
	@FindBy(id = "id_gender2")
	private WebElement female;
	@FindBy(id = "customer_firstname")
	private WebElement firstName;
	@FindBy(id = "customer_lastname")
	private WebElement lastName;
	@FindBy(id = "email")
	private WebElement emailId;
	@FindBy(id = "passwd")
	private WebElement password;
	@FindBy(id = "days")
	private WebElement date;
	@FindBy(id = "months")
	private WebElement month;
	@FindBy(id = "years")
	private WebElement year;
	@FindBy(id = "firstname")
	private WebElement addressfirstName;
	@FindBy(id = "lastname")
	private WebElement addresslastName;
	@FindBy(id = "company")
	private WebElement companyName;
	@FindBy(id = "address1")
	private WebElement addressLine1;
	@FindBy(id = "address2")
	private WebElement addressLine2;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(id = "id_state")
	private WebElement state;
	@FindBy(id = "postcode")
	private WebElement postCode;
	@FindBy(id = "id_country")
	private WebElement country;
	@FindBy(id = "other")
	private WebElement additionalInfo;
	@FindBy(id = "phone")
	private WebElement homePhone;
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;
	@FindBy(id = "alias")
	private WebElement addressAlias;
	@FindBy(id = "submitAccount")
	private WebElement register;
	@FindAll(@FindBy(xpath = "//*[contains(@class, 'alert')]/p"))
	private List<WebElement> error;
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void title(String gender) throws Exception {
		if(gender.equalsIgnoreCase("male")) {
			male.click();
		}
		else if(gender.equalsIgnoreCase("female")) {
			female.click();
		}
		else {
			throw new Exception("Incorrect Title");
		}
	}
	//name
	public void first_name(String first_name) {
		firstName.sendKeys(first_name);
	}
	public void last_name(String last_name) {
		lastName.sendKeys(last_name);
	}
	
	
	//login details
	public void enter_email(String email_id) {
		String current_id = emailId.getText();
		if(!current_id.equals(email_id)){
			emailId.clear();
			emailId.sendKeys(email_id);
		}
	}
	public void enter_pwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void DOB(String date_, String month_, String year_) {
		Select s1 = new Select(date);
		s1.selectByValue(date_);
		Select s2 = new Select(month);
		s2.selectByValue(month_);
		Select s3 = new Select(year);
		s3.selectByValue(year_);
	}
	
	//address
	public void adr_first_name(String firstname) {
		addressfirstName.sendKeys(firstname);
	}
	public void adr_last_name(String lastname) {
		addresslastName.sendKeys(lastname);
	}
	public void company_name(String comp) {
		companyName.sendKeys(comp);
	}
	public void adr_line1(String address1) {
		addressLine1.sendKeys(address1);
	}
	public void adr_line2(String address2) {
		addressLine2.sendKeys(address2);
	}
	public void city_name(String cityName) {
		city.sendKeys(cityName);
	}
	public void state_name(String stateName) {
		Select s = new Select(state);
		s.selectByVisibleText(stateName);
	}
	public void zip_code(String zip) {
		postCode.sendKeys(zip);
	}
	public void country_name(String CountryName) {
		country.sendKeys(CountryName);
	}
	public void add_Info(String Info) {
		additionalInfo.sendKeys(Info);
	}
	public void home_phone(String home) {
		homePhone.sendKeys(home);
	}
	public void mobile_phone(String Mob) {
		mobilePhone.sendKeys(Mob);
	}
	public void adr_alias(String address_alias) {
		addressAlias.sendKeys(address_alias);
	}
	
	public void click_register() {
		register.click();
	}
	
	//check for any errors present
	public boolean validation() {
		try {
			if(error.size() > 0) {
				System.out.println(error.get(0).getText());
				return true;
			}
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void register_account(String first_name, String last_name,String email, String pass_word, String DOB, String address_line1, String city_name, String state_name, String zip_code, String country_name, String mob_phone, String alias_address) {
		first_name(first_name);
		last_name(last_name);
		enter_email(email);
		enter_pwd(pass_word);
		String[] date_of_birth = DOB.split("-");
		DOB(date_of_birth[0], date_of_birth[1], date_of_birth[2]);
		adr_line1(address_line1);
		city_name(city_name);
		state_name(state_name);
		zip_code(zip_code);
		country_name(country_name);
		mobile_phone(mob_phone);
		adr_alias(alias_address);
		click_register();
	}
}
