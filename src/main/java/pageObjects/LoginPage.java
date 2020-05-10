package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#user_email")
	WebElement userEmail;
	
	By userPassword = By.cssSelector("#user_password");
	
	@FindBy(css="input[name='commit']")
	WebElement signinBtn;

	By Error = By.cssSelector("div.row>div>div>div>div>div");
	
	public WebElement setEmail() {
		return userEmail;
	}
	
	public WebElement setPassword() {
		return driver.findElement(userPassword);
	}

	public void clickSignIn() {
		signinBtn.click();		
	}
	public int errorIfExist() {
		return driver.findElements(Error).size();
	}
	
	public String error() {
		return driver.findElement(Error).getText();
	}

}
