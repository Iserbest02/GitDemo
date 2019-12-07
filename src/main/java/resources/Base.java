package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
  
	public static WebDriver driver; // declare the webdriver in
	public Properties prop; // declaring our properties

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties(); // WE ARE calling BROWSER from DATA.properties that one we created it.
		FileInputStream fis = new FileInputStream("C:\\Users\\ibrah\\E2ENewProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C://webdriver//chromedriver.exe");
			driver = new ChromeDriver();
			// we are using f else condition and calling browser thru .propretiesFile

		} else if (browserName.equals("firefox")) {
			// execute in firefox driver

		} else if (browserName.equals("IE")) {
			// IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}	
	public void getScreenshot(String result) throws IOException {		
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ibrah\\"+result+"screenshots.png"));
	}
	}	