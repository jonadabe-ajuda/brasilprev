package br.com.brasilprev.domain.customers.entity;

import br.com.brasilprev.domain.vo.Address;
import br.com.brasilprev.domain.vo.CPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entity of domain with field cpf single
 * Relationship with table CPF and Address
 *  
 * @author jonadabe
 * @param  methods Constructor all attribute
 */
public class CustomersEntity {
	
	@NotNull
	@Valid
	private CPF cpf;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomersEntity field name between 5 and 100")
	private String name;
	
	@NotNull
	@Valid
	private Address address;
	
	public CustomersEntity (CPF cpf, String name) {
		this.cpf = cpf;
		this.name = name;
	}
	
	public void addAddress(String street, int number, String district, String city, String state, String zipCode) {
		this.address = new Address(street, number, district, city, state, zipCode);
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}


	
}
