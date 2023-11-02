package yourLogo.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


import yourLogo.baseManager.DriverManager;
import yourLogo.pages.CartAddressPage;
import yourLogo.pages.CartPaymentPage;
import yourLogo.pages.CartShippingPage;
import yourLogo.pages.CartSummaryPage;
import yourLogo.pages.HomePage;
import yourLogo.pages.LoginPage;
import yourLogo.pages.MyAccountPage;
import yourLogo.pages.ProductCategoryPage;
import yourLogo.pages.ProductDescriptionPage;
import yourLogo.pages.RegistrationPage;
import yourLogo.utils.TestUtil;

public class BaseTest extends DriverManager{
	
	TestUtil util;
	LoginPage login;
	HomePage home;
	ProductCategoryPage pdtCategory;
	ProductDescriptionPage pdtDesc;
	CartSummaryPage cartSummary;
	CartAddressPage cartAddress;
	CartShippingPage cartShip;
	CartPaymentPage cartPayment;
	MyAccountPage account;
	RegistrationPage register;
	
	String email;
	String password;
	String screenshotPath;
	
	
	@BeforeMethod
	public void setUp() {
		DriverInitialization();	
		home = new HomePage(driver);
		pdtCategory = new ProductCategoryPage(driver);
		login = new LoginPage(driver);
		pdtDesc = new ProductDescriptionPage(driver);
		cartSummary = new CartSummaryPage(driver);
		account = new MyAccountPage(driver);
		cartAddress = new CartAddressPage(driver);
		cartShip = new CartShippingPage(driver);
		cartPayment = new CartPaymentPage(driver);
		register = new RegistrationPage(driver);
		util = new TestUtil();
		
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		
		
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}
	
	

}
