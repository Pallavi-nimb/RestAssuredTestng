package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;


public class CartPage extends BasePage {

	
	private final By productnameadded=By.cssSelector("td[class='product-name'] a");
	private final By checkoutbutton=By.xpath("//a[normalize-space()='Proceed to checkout']");
	

	public CartPage(WebDriver driver) {
		super(driver);
	
		// TODO Auto-generated constructor stub
	}
	
	public String getproductname()
	{
		return Wait.until(ExpectedConditions.visibilityOfElementLocated(productnameadded)).getText();
		
	}
	
	public CheckoutPage checkoutbutton()
	{
		 Wait.until(ExpectedConditions.elementToBeClickable(checkoutbutton)).click();
	        return new CheckoutPage(driver);
		
		
	}
	
}
