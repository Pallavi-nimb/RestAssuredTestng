package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;

public class HomePage extends BasePage{

	
	//private final By storemenuelink = By.cssSelector("#menu-item-1227 > a");
private Component.ProductThumbnail ProductThumbnail;

private Component.MyHeader MyHeader;

	public Component.ProductThumbnail getProductThumbnail() {
	return ProductThumbnail;
}

	public Component.MyHeader getMyHeader() {
		return MyHeader;
	}
	/*
	 * public void setProductThumbnail(Component.ProductThumbnail productThumbnail)
	 * { ProductThumbnail = productThumbnail; }
	 */

	public HomePage(WebDriver driver) {
		super(driver);
		MyHeader=new Component.MyHeader(driver);
		ProductThumbnail=new Component.ProductThumbnail(driver);
		
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * public StorePage clickStoreMenuLink() {
	 * Wait.until(ExpectedConditions.elementToBeClickable(storemenuelink)).click();
	 * return new StorePage(driver); }
	 */
	public HomePage load()
	{
		load("/");
		return this;
	}
	
	}


