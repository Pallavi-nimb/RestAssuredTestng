package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;
import Pages.CartPage;
import Pages.StorePage;

public class ProductThumbnail extends BasePage
{
	private By viewcart=By.xpath("//a[@title='View cart']");

public ProductThumbnail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

private By getaddtocartbutton(String productname)
{
	return By.cssSelector("a[aria-label='Add “"+ productname +"” to your cart']");
}

public ProductThumbnail clickonaddtocart(String productname)
{
	 By addcartm=getaddtocartbutton(productname);


	 driver.findElement(addcartm).click();
	return this;
}

public CartPage clickviewcart()
{
Wait.until(ExpectedConditions.elementToBeClickable(viewcart)).click();
 return new CartPage(driver);
}}