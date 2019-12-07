package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

//Adding logs 
//Generating html reports
//Screenshots on failure
//jenkins intergration


public class validateNavigationBar extends Base {
	//this line is initializing for log4j 
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
     @BeforeTest
     public void initialize() throws IOException {
    	 driver = initializeDriver();
	     driver.get(prop.getProperty("url")); // getting property from data.properties and inherit from Base class    	 
     }
     
     
     @Test
     public void basePageNavigation() {
    	 
	// We can excess homepage to other class within 2 WAYS
	// One is inheritance (with extends keywords)
	// Second is a creating OBJECT to that class and invoke methods of it

	LandingPage lnd = new LandingPage(driver); // we create an object and call LandingPage class
	// compare the text from the browser with actual text. - ( so you can catch the ERROR)
	Assert.assertTrue(lnd.getNavigationBar().isDisplayed());
    log.info("Navigation bar is displayed");
	}
     
     @AfterTest
     public void teardown() {
    	 driver.close();
     }
     
     
     
        
}