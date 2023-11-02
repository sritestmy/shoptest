package yourLogo.baseManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	public static WebDriver driver;
	public static Properties prop;
	public DriverManager() {
		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/yourLogo/config/Configuration.properties");
			prop.load(in);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void DriverInitialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath") + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.IEDriverServer.driver", prop.getProperty("driverPath") + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Driver "+ browserName + " not supported/Invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
