package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;
import Component.MyHeader;




public class StorePage extends BasePage {

	
	private By searchfield=By.cssSelector("#woocommerce-product-search-field-0");
	private By searchbtn= By.cssSelector("#woocommerce_product_search-1 > form > button");
	private By title=By.cssSelector("header.woocommerce-products-header");
	//private By viewcart=By.xpath("//a[@title='View cart']");

	
	private Component.MyHeader MyHeader;
	

	private Component.ProductThumbnail ProductThumbnail;

	public Component.ProductThumbnail getProductThumbnail() {
		return ProductThumbnail;
	}

	/*
	 * public void setProductThumbnail(Component.ProductThumbnail productThumbnail)
	 * { ProductThumbnail = productThumbnail; }
	 */
	public Component.MyHeader getMyHeader() {
		return MyHeader;
	}

	/*
	 * public void setMyHeader(Component.MyHeader myHeader) { MyHeader = myHeader; }
	 */
	public StorePage(WebDriver driver) {
		super(driver);
		MyHeader=new MyHeader(driver);
		ProductThumbnail=new Component.ProductThumbnail(driver);
	}

	public StorePage load()
	{
		load("/store");
		return this;
	}
	public StorePage Entertxtinsrchfld(String txt)
	{
		         
		Wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield)).sendKeys(txt);
        return this;
		}
	

	public StorePage clickSerachbtn() //functional page object
	{
		 Wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
	        return this;
	}
	

	public  String gettitle()
	{
		 return Wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
		
	}
	
	

	/*
	 * private By getaddtocartbutton(String productname) { return
	 * By.cssSelector("a[aria-label='Add “"+ productname +"” to your cart']"); }
	 * 
	 * public StorePage clickonaddtocart(String productname) { By
	 * addcartm=getaddtocartbutton(productname);
	 * 
	 * 
	 * driver.findElement(addcartm).click(); return this; }
	 * 
	 * public CartPage clickviewcart() {
	 * Wait.until(ExpectedConditions.elementToBeClickable(viewcart)).click(); return
	 * new CartPage(driver); }
	 */
	}



