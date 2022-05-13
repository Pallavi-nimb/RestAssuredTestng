package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;
import Pages.StorePage;

public class MyHeader extends BasePage {
	
	private final By storemenuelink = By.cssSelector("#menu-item-1227 > a");
	
	public MyHeader(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public StorePage clickStoreMenuLink()
	{
		Wait.until(ExpectedConditions.elementToBeClickable(storemenuelink)).click();
		return new StorePage(driver);
	}


}
