
package yourLogo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class userWishListTest extends BaseTest{
	
	String expectedMessage = "You must be logged in to manage your wishlist.";
	

public userWishListTest() {
		
		super();
	}
	
	@Test
	public void verifyWishList() throws InterruptedException {
		
		home.selectTshirt();
		String msg = pdtCategory.addToWishlist();
		Assert.assertEquals(msg, expectedMessage);
		
	}
	
}
