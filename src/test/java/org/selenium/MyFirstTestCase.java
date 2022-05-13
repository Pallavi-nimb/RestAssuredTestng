package org.selenium;

import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Base.BaseTest;
import Pages.Accountloginregi;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.StorePage;
import Utils.ConfigLoader;
import Utils.JacksonUtils;
import objects.BillingAddress;
import objects.Product;
import objects.User;

public class MyFirstTestCase extends BaseTest{

	@Test
	
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, StreamReadException, DatabindException, IOException 
	{
		
		Product product=new Product(1215);
				
		BillingAddress billingAddress=JacksonUtils.deserializeJson("MyBillingAddress.json", BillingAddress.class);
		
		//BillingAddress BillingAddress= new BillingAddress()
				/*.setFirstName("pallavi")
				.setLastName("nimbalkar").
				setCountry("India").
				setAddresslineOne("4556 scetor6").
				setCity("Mumbai").
				setState("Maharashtra").
				setPostalCode("400100").
				setEmail("pallavinimbalkar10@gmail.com");*/
		
		
		//BillingAddress BillingAddress= new BillingAddress("pallavi","nimbalkar","India","4556 azad","Mumbai","Maharashtra","400100","pallavinimbalkar10@gmail.com");
		
		StorePage StorePage=new HomePage(driver).load().getMyHeader().clickStoreMenuLink().Entertxtinsrchfld("blue").clickSerachbtn();
		Thread.sleep(2000);
		Assert.assertEquals(StorePage.gettitle(), "Search results: “blue”");
		StorePage.getProductThumbnail().clickonaddtocart(product.getName());
		CartPage CartPage=StorePage.getProductThumbnail().clickviewcart();
		Assert.assertEquals(CartPage.getproductname(),product.getName());
		
		CheckoutPage CheckoutPage=CartPage.checkoutbutton().setBillingAddress(billingAddress);
		/*
		 * CheckoutPage.enterfirstname("pallavih"). enterlastname1("Nimbalkar").
		 * selectcountry("India"). enteraddress("556 azad nagar"). entercity("mumbai").
		 * selectstate("Maharashtra").
		 * enterpostalcode("400711").emailid("Pallavinimbalkar10@gmail.com");
		 */
	}
@Test

public void guestcheckoutusingdirectbanktransferlogin() throws InterruptedException, StreamReadException, DatabindException, IOException
{
	
	Product product=new Product(1215);
	User user=new User(ConfigLoader.getInstance().getuser(), ConfigLoader.getInstance().getemail(),ConfigLoader.getInstance().getpassword());
	//User user=new User("chhh","hdjashd@gmail.com","jshdjsahdjk");
	StorePage StorePage=new HomePage(driver).load().getMyHeader().clickStoreMenuLink().Entertxtinsrchfld("blue").clickSerachbtn();
	Thread.sleep(2000);
	Assert.assertEquals(StorePage.gettitle(), "Search results: “blue”");
	StorePage.getProductThumbnail().clickonaddtocart(product.getName());
	CartPage CartPage=StorePage.getProductThumbnail().clickviewcart();
	Assert.assertEquals(CartPage.getproductname(),product.getName());
	CheckoutPage CheckoutPage=CartPage.checkoutbutton();
	Accountloginregi Accountloginregi =CheckoutPage.accountlogin();
	
	Accountloginregi.setUser(user).
	registerclick();
}

}
