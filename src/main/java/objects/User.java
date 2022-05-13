package objects;

public class User {

	
	private String user1;
	private String email;
	private String password;

	public User(String user1,String email, String password)
	{
	this.user1=user1;
	this.email=email;
	this.password=password;
	}
	
	public User()
	{
		
	}
	
	public String getUser() {
		return user1;
	}
	public User setUser(String user1) {
		this.user1 = user1;
		return this;
	}
	public String getEmail() {
	return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
}
	
