package yourLogo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.maven.surefire.shared.compress.archivers.dump.InvalidFormatException;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import yourLogo.baseManager.DriverManager;

/**
 * Handle test data sheet and capture screenshot
 * @author Saranya Sasidharan
 *
 */
public class TestUtil extends DriverManager{
	
	static String filepath = System.getProperty("user.dir")+ "/src/main/java/yourLogo/TestData/YourLogoTestData.xlsx";
 	static Workbook book;
 	static Sheet sheet;
 	
 	
 	/*
 	 * Get Test data from given sheet
 	 */
	public static Object[][] getTestData(String sheetname){
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int j = 0; j< sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
			
		
		return data;
		
	}
	
	/**
	 * take screenshot and save it in given path
	 * @param TestCaseName
	 * @return file path
	 * @throws IOException
	 */
	public String TakeScreenshotAfterTest(String TestCaseName) throws IOException {
		File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String curdir = System.getProperty("user.dir");
		String destination = curdir + "/screenshots/" + TestCaseName + System.currentTimeMillis() + ".png";
		
		FileUtils.copyFile(sc, new File(destination));
		return destination;
	}
	
	
}
