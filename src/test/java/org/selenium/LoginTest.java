package org.selenium;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Utils.FakerUtils;
import api.actions.CartApi;
import api.actions.SignUpapi;
import objects.Product;
import objects.User;

public class LoginTest {

	
	@Test
	public void loginDuringCheckout() throws StreamReadException, DatabindException, IOException
	{

		System.out.println(new SignUpapi().fetchregisternoncevalueusingjsoap());
	String Username="pallu"+ new FakerUtils().generaterandomnumber();

		User user=new User().setUser(Username).setEmail(Username +"@askhomedch.com");

		SignUpapi signupapi= new SignUpapi();
		System.out.println(signupapi.register(user));
		
		CartApi cartapi=new CartApi();
		Product product=new Product(1215);
		
		cartapi.addTocart(product.getId(), 1);
	}
}
