package api.actions;

import Utils.FakerUtils;
import objects.User;

public class Dummyclass {

	
public static void main(String[]args) {
	
	
	//new SignUpapi().getAccount();
	
	
	//System.out.println(new SignUpapi().fetchregisternoncevalueusinggrovy());
	

	//System.out.println(new SignUpapi().fetchregisternoncevalueusingjsoap());
	/*String Username="pallu"+ new FakerUtils().generaterandomnumber();

	User user=new User().setUser(Username).setEmail(Username +"@askhomedch.com");

	SignUpapi signupapi= new SignUpapi();
	System.out.println(signupapi.register(user));
	System.out.println(signupapi.getCookies());*/
	
	
	
	CartApi cartapi=new CartApi();
	cartapi.addTocart(1215, 1);
	System.out.println(CartApi.getcookies());
}
}
