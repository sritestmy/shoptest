package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import yourLogo.pages.LoginPage;


public class userRegistrationTest extends BaseTest{
	
	String expTitle = "My account - My Store";
	
	public  userRegistrationTest() {
		super();
	}
	
	/*
	 * Validate on clicking signUp
	 * user is navigated to authentication page
	 */
	
	  public LoginPage Authentication() {
		  home.SignUpButton();
	  Assert.assertEquals(driver.getTitle(), "Login - My Store"); 
	  return login; }
	 
	
	/*
	  Validate user registration form
	 */
	
	  @Test(dataProvider = "GetRegistrationData", enabled = true, priority = 200, dataProviderClass = TestDataHandler.class)
	  public void UserRegistration(String first_name, String last_name, String DOB, String address_line1, String city_name, String state_name, String zip_code, String country_name, String mob_phone, String alias_address) { 
		  login =Authentication();
		   register = login.create_account(email);
		   try {
		  register.register_account(first_name, last_name, email, password, DOB, address_line1, city_name, state_name, zip_code, country_name, mob_phone, alias_address); 
		   }
		   catch(NullPointerException e) {
			   e.printStackTrace();
		   }
		  Assert.assertEquals(driver.getTitle(), expTitle); 
		  
	  }
	  
	  @Test(priority = 50, enabled = false)
	  public void InvalidEmailTest() {
		  login = Authentication();
		  register = login.create_account(email);
		  Assert.assertTrue(register == null, "Invalid Email Test Case failed");
	  }
	   
	  @Test(priority = 100, enabled = false)
	  public void MandatoryFieldValidation( ) {
		  login = Authentication();
		  register = login.create_account(email);
		  register.click_register();
		  Assert.assertTrue(register.validation(), "Field Validation failed");
	  }

	 
	
}
