package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePageTest extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	WebDriver driver;
	
	LandingPage l;
	LoginPage lpg ;
	@BeforeTest
	public void basePageNavigation() throws IOException {
		//1...there are two ways to access methos of a diferent class
		 //inheritance-we extended base class
		 
		 driver = initializeDriver();
		 log.info("Driver initialized for HomePage");
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to homepage");
		 l=new LandingPage(driver);
		 lpg = l.getLogin();	
		 log.info("Login button clicked");
	}
	
	@Test(dataProvider="getdata")
	public void validateloginpage(String Arg1, String Arg2) throws InterruptedException {
		
		driver.getCurrentUrl();
		if((driver.getCurrentUrl()).contains("https://sso.teachable.com/secure/9521/users/sign_in"))
		{
			System.out.println("landed on : "+driver.getCurrentUrl());
			System.out.println("Login page validated");
			log.info("Entered Login page");
		}		
		lpg.setEmail().sendKeys(Arg1);
		log.info("Email Entered");
		lpg.setPassword().sendKeys(Arg2);
		log.info("password entered");
		lpg.clickSignIn();
		log.info("Clicked sign in");
		Thread.sleep(5000l);
		System.out.println(lpg.error());
		lpg.setEmail().clear();
		}
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[3][2];
		data[0][0]="zxcv@asdeffwf.com";
		data[0][1]="mnbvc";
		data[1][0]="asdf@lkjh.com";
		data[1][1]="lkjhg";
		data[2][0]="qweqe@pokoiu.com";
		data[2][1]="ryturytu";
		
		return data;
	}
	
	@AfterTest
	public void teardown(){
		driver.close();	
		log.info("Homepage driver closed");
	}

				
}
	
