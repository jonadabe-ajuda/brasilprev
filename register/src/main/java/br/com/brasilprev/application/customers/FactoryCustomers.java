package br.com.brasilprev.application.customers;
/**
 * Build to create customerEntity.
 *  
 * @author jonadabe
 * @param  methods withCPFName String cpf and String name
 * @param  methods addressComplete String street, int number, String district, String city, String state, String zipCodee
 * @return CustomerEntity
 */
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.vo.CPF;

public class FactoryCustomers {
	
	private CustomersEntity customersEntity;
	
	public FactoryCustomers withCPFName(String cpf, String name) {
		this.customersEntity = new CustomersEntity(new CPF(cpf), name);
		return this;
	}
	
	public FactoryCustomers addressComplete(String street, int number, String district, String city, String state, String zipCode) {
		this.customersEntity.addAddress(street, number, district, city, state, zipCode);
		return this;
	}
	
	public CustomersEntity create () {
		return this.customersEntity;
	}
	
	

}
