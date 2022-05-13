package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Base.BasePage;
import objects.User;

public class Accountloginregi extends BasePage{

	private By usernamefield =By.xpath("//input[@id='reg_username']");
	private By emailidfield=By.cssSelector("#reg_email");
	private By passwordfield=By.cssSelector("#reg_password");
	private By registerbuttonfield=By.xpath("//button[@name='register']");
	
	public Accountloginregi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Accountloginregi usernamesenter(String user)
	{
	driver.findElement(usernamefield).sendKeys(user);
	return this;
	}
	public Accountloginregi emailidenter(String email)
	{
	driver.findElement(emailidfield).sendKeys(email);
	return this;
	}
	public Accountloginregi passwordenter(String password)
	{
	driver.findElement(passwordfield).sendKeys(password);
	return this;
	}
	public Accountloginregi registerclick()
	{
	driver.findElement(registerbuttonfield).click();
	return this;
	}
	
	  public <user> Accountloginregi setUser(user user){
	        return usernamesenter(((User) user).getUser()).
	        		emailidenter(((User) user).getEmail()).passwordenter(((User) user).getPassword());
	        		
	    }
	
	
}
