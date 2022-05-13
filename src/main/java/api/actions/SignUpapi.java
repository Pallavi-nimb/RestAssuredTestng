package api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import objects.User;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import Utils.ConfigLoader;

public class SignUpapi {
	private Cookies cookies;

	public Cookies getCookies() {
		return cookies;
	}
	
	
	
	 public String fetchregisternoncevalueusinggrovy() { Response
	 response=getAccount(); return response.htmlPath().
	 getString("**.findAll {it.@name=='woocommerce-register-nonce' }.@value");
	 
	 }
	 
	 
	  public String fetchregisternoncevalueusingjsoap() { Response response =
	  getAccount(); Document doc = Jsoup.parse(response.body().prettyPrint());
	  Element element = doc.selectFirst("#woocommerce-register-nonce");
	  
	  return element.attr("value"); 
	  }
	  
	 
	
	public Response getAccount()
	{
		
		Cookies cookies=new Cookies();
		Response response=given().baseUri(ConfigLoader.getInstance().getBaseUrl()).cookies(cookies).log().all()
		.when().get("/account").then().log().all().extract().response();
		 if (response.getStatusCode() != 200) { throw new
			  RuntimeException("Failed to fetch the account,http status code:" +
			  response.getStatusCode()); }
			return response;

	}
	


	public Response register(User user1) {
 
  Cookies cookies = new Cookies(); 
  Header header = new Header("content-type","application/x-www-form-urlencoded");
  Headers headers = new Headers(header);
 HashMap<String, String> formparams = new HashMap<String, String>();
 formparams.put("user", user1.getUser()); formparams.put("email",user1.getEmail()); formparams.put("email", user1.getPassword());
  formparams.put("woocommerce-register-nonce",
  fetchregisternoncevalueusingjsoap()); formparams.put("register", "register");
 
 Response response =
  given().baseUri(ConfigLoader.getInstance().getBaseUrl()).headers(headers).
 formParams(formparams).cookies(cookies).log().all()
 .when().post("/account")
 .then().log().all().extract().response();
 
 if (response.getStatusCode()!=302) { throw new
  RuntimeException("Failed to fetch the account,http status code:" +
 response.getStatusCode()); }
 
 this.cookies=response.getDetailedCookies();
 return response;
 }
}