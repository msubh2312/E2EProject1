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

public class validateNavBarTest extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 log.info("Driver initialized for ValidateNavBar");
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to homepage");
	}
	@Test
	public void validateNavBar() throws IOException {
	
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Successfully validated Navigation bar");
		//Assert.assertFalse(l.getNavBar().isDisplayed());---->> deliberately fails the test case
		if(l.getNavBar().isDisplayed()) {
			System.out.println("Landed on : "+driver.getCurrentUrl());
			System.out.println("Validation successfull");
		}
		
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();	
		log.info("ValidateNavBar driver closed");
	}

}
