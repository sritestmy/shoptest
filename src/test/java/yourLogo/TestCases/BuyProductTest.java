package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BuyProductTest extends BaseTest{

	String expectedMessage = "complete";
	
	public BuyProductTest() {
		
		super();
	}
	
	
	@Test(dataProvider = "GetProductData", dataProviderClass = TestDataHandler.class)
	public void verifyBuyProduct(String quantity, String size, String colour) throws InterruptedException {
		home.SignUpButton();
		login.Login_account(email, password);
		account.returnHOme();
		home.selectTshirt();
		pdtCategory.clickMore();
		pdtDesc.prepareCart(quantity, size, colour);
		cartSummary.proceedToCheck();
		cartAddress.proceedToCheck();
		cartShip.proceedShipping();
		String actualMessage = cartPayment.completeOrder();
		if(actualMessage.contains(expectedMessage)) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
}
