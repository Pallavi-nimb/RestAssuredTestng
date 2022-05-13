package org.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Base.BasePage;
import Base.BaseTest;
import Component.ProductThumbnail;
import Pages.CartPage;
import Pages.HomePage;
import Pages.StorePage;
import Utils.JacksonUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import objects.Product;
@Epic("spotify")
public class AddToCartTest extends BaseTest{

    @Story("create playliststory")  
	@Link("https://example.org")
	@Issue("123")
	@TmsLink("test-1")

    @Description("this is description")  
	@Test(description="add products to the cart")
	
	public void addToCartFromStorePage() throws StreamReadException, DatabindException, IOException, InterruptedException
	{
		
		Product product=new Product(1215);
Thread.sleep(3000);
		ProductThumbnail StorePage=new HomePage(driver).load().getProductThumbnail().clickonaddtocart(product.getName());
		CartPage CartPage=StorePage.clickviewcart();
		Assert.assertEquals(CartPage.getproductname(),product.getName());
		
	}
	
	@Test(dataProvider="getfeaturedproducts")
	public void addToCartFeaturedProducts(Product product) throws InterruptedException
	{
		CartPage cartpage=new StorePage(driver).load().getProductThumbnail().clickonaddtocart(product.getName()).clickviewcart();
	
		Assert.assertEquals(cartpage.getproductname(),product.getName());	
	}
	
	
	@DataProvider(name="getfeaturedproducts",parallel=false)
	public Object[] getFeaturedProduct() throws StreamReadException, DatabindException, IOException
	{
		return JacksonUtils.deserializeJson("products.json", Product[].class);
	}
}
