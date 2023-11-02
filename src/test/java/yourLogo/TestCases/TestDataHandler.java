package yourLogo.TestCases;

import org.testng.annotations.DataProvider;

import yourLogo.utils.TestUtil;

public class TestDataHandler {
	
	String regSheetname = "Registration";
	String pdtSheetname = "ProductDetails";
	String updateSheetname = "UpdateProduct";
	
	@DataProvider
	public Object[][] GetRegistrationData()
	{
		Object data[][] = TestUtil.getTestData(regSheetname);
		return data;
	}
	
	@DataProvider
	public Object[][] GetProductData() {
		
		Object data[][] = TestUtil.getTestData(pdtSheetname);
		return data;
	}
	
	@DataProvider
	public Object[][] UpdateProductData() {
		
		Object data[][] = TestUtil.getTestData(updateSheetname);
		return data;
	}
			}
