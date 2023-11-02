package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTotalPriceTest extends BaseTest{

	
	public verifyTotalPriceTest() {
		
		super();
	}
	
	
	@Test(dataProvider = "UpdateProductData", dataProviderClass = TestDataHandler.class)
	public void verifyTotalPrice(String quantity, String size, String color, String newQuantity) throws InterruptedException {
		
		home.SignUpButton();
		login.Login_account(email, password);
		account.returnHOme();
		
		home.selectTshirt();
		pdtCategory.clickMore();
		pdtDesc.prepareCart(quantity, size, color);
		cartSummary.changeQuantity(newQuantity);
		
		float unitPrice = cartSummary.getUnitPrice();
		System.out.println("Unit price is $"+ unitPrice);
		float shipping = cartSummary.getShippingPrice();
		System.out.println("shipping price is $"+ shipping);
		float tax = cartSummary.getTotalTax();
		System.out.println("tax is $"+ tax);
		float totalQuantity = Float.parseFloat(newQuantity);
		System.out.println("Total quantity is "+ totalQuantity);
		Thread.sleep(5000);
		float actualTotalPrice = cartSummary.getTotalPrice();
		//calculate expected total price
		float expectedTotalPrice = unitPrice * totalQuantity + shipping + tax;
		System.out.println("Actual Total price is "+ actualTotalPrice);
		
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}
	
}
