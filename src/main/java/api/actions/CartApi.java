package api.actions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import Utils.ConfigLoader;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CartApi {
private static Cookies cookies;


public CartApi() {}

public CartApi(Cookies cookies) {
	
	this.cookies=cookies;
}


public static Cookies getcookies()
{
	return cookies;
}

	public Response addTocart(int productid,int quantity)
	{
		
		  Header header = new Header("content-type","application/x-www-form-urlencoded");
		  Headers headers = new Headers(header);
		 HashMap<String, Object> formparams = new HashMap<String, Object>();
		 formparams.put("product_sku", ""); formparams.put("product_id",productid); formparams.put("quantity", quantity);
		  
		 if(cookies==null)
		 {
			 cookies=new Cookies();
		 }
		 Response response =
		  given().baseUri(ConfigLoader.getInstance().getBaseUrl()).headers(headers).
		 formParams(formparams).cookies(cookies).log().all()
		 .when().post("?wc-ajax=add_to_cart")
		 .then().log().all().extract().response();
		 
		 if (response.getStatusCode()!=200) { throw new
		  RuntimeException("Failed to add product" + productid + "to the cart" +", HTTP Status code: "+ response.getStatusCode()); }
		 
		 this.cookies=response.getDetailedCookies();
		 return response;
	}

}
