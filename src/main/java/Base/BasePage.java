package Base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ConfigLoader;

public class BasePage<WebElements> {

	public WebDriver driver;
	protected  WebDriverWait Wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		Wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void load(String endPoint)
	{
		driver.get(ConfigLoader.getInstance().getBaseUrl()+ endPoint);
	}
	
	public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
        	Wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }
}
