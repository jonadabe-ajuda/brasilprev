package br.com.brasilprev.application.customers.command;

import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.repository.RepositoryCustomer;


/**
 * Recover customers
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @param  methods execute cpf
 * @return CustomerDTO
 */
public class RecoverCustomerCPF {
	
	private final RepositoryCustomer repositoryCustomer;

	public RecoverCustomerCPF(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public CustomerDTO execute ( String cpf ) {
		
		CustomersEntity  customer = repositoryCustomer.findByCustomer(cpf);
		
		if ( customer != null ) {
			CustomerDTO customerDTO = new CustomerDTO(customer.getName(), 
													 customer.getAddress().getStreet(),
													 customer.getAddress().getNumber(), 
													 customer.getAddress().getDistrict(),
													 customer.getAddress().getCity(), 
													 customer.getAddress().getState(),
													 customer.getAddress().getZipCode());
			return customerDTO;
		} else {
			return new CustomerDTO();
		}
		 
	}	
		

}
