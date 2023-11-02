package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class userLoginTest extends BaseTest{
	String expTitle = "My account - My Store";
	
	public userLoginTest() {
		super();
	}
	
	
	/*
	 * Validate user login scenario
	 */
	
	@Test
	public void LoginTest() {
		home.SignUpButton();
		login.Login_account(email, password);
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	  

}
