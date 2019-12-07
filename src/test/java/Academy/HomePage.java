package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base { // we are using "extends" keyword and using java inheritance Methods
	// this line is initializing for log4j
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url")); // getting property from data.properties and declare first in Base class
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url")); // getting property from data.properties and declare first in Base class

		// We can excess homepage to other class within 2 WAYS
		// One is inheritance (with extends keywords)
		// Second is a creating OBJECT to that class and invoke methods of it

		LandingPage lnd = new LandingPage(driver); // we create an object and call LandingPage class
		lnd.getLogin().click(); // driver.findElement(By.css())

		LoginPage lgnpg = new LoginPage(driver); // creating an object for loginpage class
		lgnpg.getEmail().sendKeys(Username); // fill the email by sendKeys
		lgnpg.getPassword().sendKeys(Password); // fill the password using sendKeys
		// System.out.println(text);
		log.info(text);
		lgnpg.getLogin().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types should run
		// column stands for how many values per each test
		// 0th row
		Object[][] data = new Object[2][3]; // [row][column]
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "21345";
		data[0][2] = "Restricted User";

//			//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "78910";
		data[1][2] = "NON Restricted User";

		return data;

	}

}