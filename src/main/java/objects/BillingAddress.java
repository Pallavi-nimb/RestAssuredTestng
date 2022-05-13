
 package objects;
 
 public class BillingAddress {
 
  private String firstName;
  private String lastName;
  private String country;
  private String addresslineOne; 
  private String city; 
  private String PostalCodePIN; 
  private String state;
  private String email;
  
  
  public BillingAddress() {
  
  } 
  
  public BillingAddress(String firstName, String lastName, String country, String
		  addresslineOne, String city,String PostalCodePIN ,String email)
  { 
	  this.firstName= firstName;
  this.lastName = lastName; 
  this.country= country;
  this.addresslineOne = addresslineOne;
  this.city = city; 
  this.PostalCodePIN = PostalCodePIN; 
  this.email = email; }

 public String getFirstName() { 
	 return firstName; 
}
 public BillingAddress
 setFirstName(String firstName) 
 { 
	 this.firstName = firstName; return this; 
 }
 public String getLastName() { 
	 return lastName; } 
 
 public BillingAddress setlastName(String lastName) 
 { this.lastName = lastName;
 return this; 
 }

	
	 public String getCountry() { 
		 return country; 
		 }
	
	 public BillingAddress setCountry(String country) { 
		 this.country = country;
	 return this; }
	 

	public String getAddresslineOne() {
		return addresslineOne;
	}

	public BillingAddress setAddresslineOne(String addresslineOne) {
		this.addresslineOne = addresslineOne;
		return this;
	}

	public String getCity() {
		return city;
	}

	public BillingAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getPostalCode() {
		return PostalCodePIN;
	}

	public BillingAddress setPostalCode(String PostalCodePIN) {
		this.PostalCodePIN = PostalCodePIN;
		return this;
	}

	
	 public String getState() { 
		 return state; 
		 }
	 
	 public BillingAddress setState(String state) { 
		 this.state = state;
		 return this; }
	

	public String getEmail() {
		return email;
	}

	public BillingAddress setEmail(String email) {
		this.email = email;
		return this;
	}

}
 