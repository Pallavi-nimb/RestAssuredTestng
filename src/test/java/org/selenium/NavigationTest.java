package org.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.StorePage;

public class NavigationTest extends BaseTest{

	@Test
	public void NavigateFromHomeToStoreUsingMainMenu() throws InterruptedException
	{
		StorePage StorePage=new HomePage(driver).load().getMyHeader().clickStoreMenuLink();
		Thread.sleep(2000);
		Assert.assertEquals(StorePage.gettitle(), "Store");
	}
}
