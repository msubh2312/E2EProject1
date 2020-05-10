package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitleTest extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 log.info("Driver initialized for ValidateTitle");
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to homepage");
	}
	@Test
	public void validateTitle() {
		LandingPage l = new LandingPage(driver);
		String title = l.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES");
		log.info("Successfully validated landing page text");
		if(title.equalsIgnoreCase("Featured Courses")) {
			System.out.println("Landed on : "+driver.getCurrentUrl());
			System.out.println("Validation successfull");
		}
		
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();	
		log.info("ValidateTitle driver closed");
	}


}
