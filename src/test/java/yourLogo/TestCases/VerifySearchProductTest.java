package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySearchProductTest extends BaseTest{
	
	
	public VerifySearchProductTest() {
		super();
	}

	
	@Test
	public void verifySearchProductByName() {
		home.selectTshirt();
		String firstProductName = pdtCategory.getProductName();
		home.searchProduct(firstProductName);
		String resultProductName = pdtCategory.getProductName();
		Assert.assertEquals(firstProductName, resultProductName);
	}
	
}
