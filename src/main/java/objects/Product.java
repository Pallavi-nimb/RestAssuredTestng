package objects;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Utils.JacksonUtils;

public class Product {
	private int id;
	private String name;
	
	
	public Product() {
		
	}
	
public Product(int id) throws StreamReadException, DatabindException, IOException {
		
	Product[] Products=JacksonUtils.deserializeJson("products.json", Product[].class);
	for(Product Product:Products) {
		if(Product.id==id)
		{
			this.id=id;
			this.name=Product.getName();
		}
	}
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
