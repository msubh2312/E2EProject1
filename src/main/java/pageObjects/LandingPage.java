package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//1st way of using page objects
	By signin = By.cssSelector("a[href*='sign_in']");
	//2nd way of using page objects
	@FindBy(css="div.container>div>h2")
	WebElement title;
	
	By navBar = By.cssSelector("nav.navbar-collapse.collapse>ul");
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	public WebElement getTitle() {
		return title;
	}
	
	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lpg=new LoginPage(driver);
		return lpg;
	}
	
	/* 2nd way of using page objects
	@FindBy(css="a[href*='sign_in']")
	private WebElement signIn;
	public WebElement getLogin() {
		return signin.click();
	}
	*/

}
