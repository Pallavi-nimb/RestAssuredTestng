package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import objects.BillingAddress;

public class CheckoutPage extends BasePage {

	private By firstName = By.cssSelector("#billing_first_name");
	private By LastName = By.xpath("//input[@id='billing_last_name']");
	private By address = By.cssSelector("#billing_address_1");
	private By City = By.xpath("//input[@id='billing_city']");
	private By postalcode1 =By.cssSelector("#billing_postcode");
	private By Emailid = By.xpath("//input[@id='billing_email']");
	private By orderplaced = By.xpath("//button[@id='place_order']");
	private By Accountlink = By.xpath("//li[@id='menu-item-1237']//a[@class='menu-link'][normalize-space()='Account']");
	private By countrydropdown = By.cssSelector("#billing_country");
	private By Statedropdown = By.cssSelector("input.select2-search__field");
	private final By Overlay = By.cssSelector(".blockUI.blockOverlay");

	private final By countrydropdown2 = By.id("select2-billing_country-container");
	private final By ststedropdown2=By.id("billing_state");
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public CheckoutPage enterfirstname(String firstname) {
		WebElement e = Wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		e.clear();
		e.sendKeys(firstname);
		return this;
	}

	public CheckoutPage enterlastname(String lastname) {
		WebElement e = Wait.until(ExpectedConditions.visibilityOfElementLocated(LastName));
		e.clear();
		e.sendKeys(lastname);
		return this;
	}

	
	 public CheckoutPage selectcountry(String country) throws InterruptedException
	 { 
		 
		 
	 
	 
	 Wait.until(ExpectedConditions.elementToBeClickable(countrydropdown2)).click();
	  
	
		 /* WebElement sk= driver.findElement(By.cssSelector("input[role='combobox']"));
		 * sk.sendKeys("India"); Actions Action=new Actions(driver); WebElement
		 * s=driver.findElement(By.xpath(
		 * "//li[@id='select2-billing_country-result-ygzr-IN']"));
		 * Action.moveToElement(s).click().build().perform();
		 */
	// Wait.until(ExpectedConditions.elementToBeClickable(countrydropdown2)).click();
     WebElement e = Wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//li[text()='" + country + "']")));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
     e.click();
     return this;
	 
	 }
	 

	public CheckoutPage enteraddress(String addresslineOne) {
		WebElement p = Wait.until(ExpectedConditions.visibilityOfElementLocated(address));
p.sendKeys("uyuyu");
		return this;
	}

	public CheckoutPage entercity(String city) {
		WebElement e = Wait.until(ExpectedConditions.visibilityOfElementLocated(City));
		e.clear();
		e.sendKeys(city);
		return this;
	}

	public CheckoutPage selectstate(String state) {
		/*
		 * Wait.until(ExpectedConditions.elementToBeClickable(Statedropdown)).click();
		 * WebElement e =
		 * Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+
		 * state +"']"))); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", e); e.click();
		 */
		WebElement opp=driver.findElement(ststedropdown2);
		  Select select =new Select(opp);
		  select.selectByVisibleText(state);
		 
		return this;
	}

	public CheckoutPage enterpostalcode( String PostalCodePIN) {
	driver.findElement(postalcode1).sendKeys("400705");
	return this;
	}

	public CheckoutPage emailid(String emailid) {

		WebElement e = Wait.until(ExpectedConditions.visibilityOfElementLocated(Emailid));
		e.clear();
		e.sendKeys(emailid);
		return this;
	}

	public CheckoutPage setBillingAddress(BillingAddress BillingAddress) throws InterruptedException {
		return enterfirstname(BillingAddress.getFirstName()).enterlastname(BillingAddress.getLastName())
				.selectcountry(BillingAddress.getCountry()).enteraddress(BillingAddress.getAddresslineOne())
				.entercity(BillingAddress.getCity()).selectstate(BillingAddress.getState())
				.enterpostalcode(BillingAddress.getPostalCode()).emailid(BillingAddress.getEmail());
	}

	public CheckoutPage placeorder() {
		waitForOverlaysToDisappear(Overlay);
		driver.findElement(orderplaced).click();
		return this;
	}

	public Accountloginregi accountlogin() {
		driver.findElement(Accountlink).click();
		return new Accountloginregi(driver);

	}
}
