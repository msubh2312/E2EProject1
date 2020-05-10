package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SUBH\\Desktop\\Testing Projects\\eclipse\\E2EProject1\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
		 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUBH\\Desktop\\Testing Projects\\eclipse\\E2EProject1\\src\\main\\java\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUBH\\Desktop\\Testing Projects\\eclipse\\E2EProject1\\src\\main\\java\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUBH\\Desktop\\Testing Projects\\eclipse\\E2EProject1\\src\\main\\java\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

}
