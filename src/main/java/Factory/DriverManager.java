package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverManager {

public WebDriver initializeDriver()
{

	WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver","D:\\Training and certifications\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	return driver;
	
	}

}
