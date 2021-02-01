package br.com.brasilprev.domain.repository;

import java.util.List;

import br.com.brasilprev.domain.customers.entity.CustomersEntity;

/**
 * Repository from Customer 
 *  
 * @author jonadabe
 * @param  methods insertCustomer CustomersEntity
 * @param  methods updateCustomer CustomersEntity
 * @param  methods deleteCustomer CustomersEntity
 * @param  methods listaAllCustomers CustomersEntity
 * @return findByCustomer CustomersEntity
 * @return listaAllCustomers list from CustomersEntity
 */
public interface RepositoryCustomer {
	
	public void insertCustomer(CustomersEntity customersEntity);
	public void updateCustomer(CustomersEntity customersEntity);
	public void deleteCustomer(CustomersEntity customersEntity);
	public CustomersEntity findByCustomer(String cpf);
	public List<CustomersEntity> listaAllCustomers();

}
