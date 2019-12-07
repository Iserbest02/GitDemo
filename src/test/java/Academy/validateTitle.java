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

public class validateTitle extends Base {
	//this line is initializing for log4j 
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
    public void initialize() throws IOException {
   	 driver = initializeDriver();
   	 log.info("Driver is initialized");
   	 driver.get(prop.getProperty("url")); // getting property from data.properties and inherit first also from Base class    	 
   	log.info("Navigated to Home Page");
	}
	

	@Test
	public void basePageNavigation(){

		// We can excess homepage to other class within 2 WAYS
		// One is inheritance (with extends keywords)
		// Second is a creating OBJECT to that class and invoke methods of it

		LandingPage lnd = new LandingPage(driver); // we create an object and call LandingPage class
		// compare the text from the browser with actual text. - Error..
		Assert.assertEquals(lnd.getTitle().getText(), "FEATURED COURSES"); // with assert method we are VALIDATING the case
		log.info("Successfully validated Text message");
	}
	   @AfterTest
	     public void teardown() {
	    	 driver.close();
	    	 driver=null; // closing all the object and save the memory
	    	 
	     }
	
	
}