package org.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.StorePage;

public class SearchTest extends BaseTest {

@Test
public void searchWithPartialMatch() throws InterruptedException
{
	StorePage StorePage=new HomePage(driver).load().getMyHeader().clickStoreMenuLink();
	String Searchfor="Blue";
	StorePage storepage=new StorePage(driver).load().Entertxtinsrchfld(Searchfor).clickSerachbtn();
	Thread.sleep(2000);
	Assert.assertEquals(storepage.gettitle() , "Search results: “" + Searchfor + "”");
			
}


	}


