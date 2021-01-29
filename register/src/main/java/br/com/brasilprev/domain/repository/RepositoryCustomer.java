package br.com.brasilprev.domain.repository;

import java.util.List;

import br.com.brasilprev.domain.customers.entity.CustomersEntity;

public interface RepositoryCustomer {
	
	public void insertCustomer(CustomersEntity customersEntity);
	public void updateCustomer(CustomersEntity customersEntity);
	public void deleteCustomer(CustomersEntity customersEntity);
	public CustomersEntity findByCustomer(String cpf);
	public List<CustomersEntity> listaAllCustomers();

}
