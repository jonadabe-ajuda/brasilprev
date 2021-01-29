package br.com.brasilprev.domain.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Address {
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "Address field street between 5 and 100")
	private String street;
	
	@NotNull
	private Integer number;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "Address field district between 5 and 100")
	private String district;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "Address field city between 5 and 100")	
	private String city;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "Address field state between 5 and 100")	
	private String state;
	
	@NotNull
	@NotEmpty
	@Size(min = 8,max = 8,message = "Address field zipCode equal 8")		
	private String zipCode;
	
	public Address(String street, int number, String district, String city, String state, String zipCode) {
		super();
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public Integer getNumber() {
		return number;
	}

	public String getDistrict() {
		return district;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}
	
		
	

}
