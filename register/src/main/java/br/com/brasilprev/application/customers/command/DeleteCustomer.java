package br.com.brasilprev.application.customers.command;

import br.com.brasilprev.application.customers.dto.CustomerDTO;
import br.com.brasilprev.domain.customers.entity.CustomersEntity;
import br.com.brasilprev.domain.repository.RepositoryCustomer;
import br.com.brasilprev.domain.vo.CPF;

/**
 * Update customers
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @param  methods execute CustomerDTO
 * @return CustomerDTO
 */
public class DeleteCustomer {
	
	private final RepositoryCustomer repositoryCustomer;

	public DeleteCustomer(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public void execute ( CustomerDTO customerDTO ) {
		CustomersEntity customersEntity = new CustomersEntity(new CPF(customerDTO.getCpf()), null);
		repositoryCustomer.deleteCustomer(customersEntity);
	}

}